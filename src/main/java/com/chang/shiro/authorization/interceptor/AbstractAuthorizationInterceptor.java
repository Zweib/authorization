package com.chang.shiro.authorization.interceptor;

import com.chang.shiro.authorization.domain.model.authorization.RoleResourceBind;
import com.chang.shiro.authorization.domain.model.authorization.UrlResource;
import com.chang.shiro.authorization.domain.model.authorization.UserRoleBind;
import com.chang.shiro.authorization.persistent.repository.RoleUrlResourceBindRepository;
import com.chang.shiro.authorization.persistent.repository.UrlResourceRepository;
import com.chang.shiro.authorization.persistent.repository.UserRoleBindRepository;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public abstract class AbstractAuthorizationInterceptor extends HandlerInterceptorAdapter {

    private final UserRoleBindRepository userRoleBindRepository;

    private final UrlResourceRepository urlResourceRepository;

    private final RoleUrlResourceBindRepository roleUrlResourceBindRepository;

    public AbstractAuthorizationInterceptor(UserRoleBindRepository userRoleBindRepository,
                                            UrlResourceRepository urlResourceRepository,
                                            RoleUrlResourceBindRepository roleUrlResourceBindRepository) {
        super();
        this.userRoleBindRepository = userRoleBindRepository;
        this.urlResourceRepository = urlResourceRepository;
        this.roleUrlResourceBindRepository = roleUrlResourceBindRepository;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        // whether the request is int white list.
        if(inWhiteList(request)) {
            return true;
        }

        Long userId = getUserId(request);

        String url = request.getRequestURI();
        String method = request.getMethod();

        List<UserRoleBind> userRoleBindList = userRoleBindRepository.getUserRoleBindByUserId(userId);
        UrlResource urlResource = urlResourceRepository.getUrlResourceByUrl(url, method);
        if (null == urlResource) {
//            throw new UnauthenticatedException();
            return false;
        }
        List<RoleResourceBind> roleResourceBindList =
                roleUrlResourceBindRepository.getRoleResourceBindsByUrlResourceId(urlResource.getId());

        // whether userRoleBindList and roleResourceBindList has same roleId;
        for (RoleResourceBind roleResourceBind : roleResourceBindList) {
            for(UserRoleBind userRoleBind : userRoleBindList) {
                if(roleResourceBind.getRoleId().equals(userRoleBind.getRoleId())) {
                    return true;
                }
            }
        }

//        throw new UnauthenticatedException();
        return false;
    }

    protected boolean inWhiteList(HttpServletRequest request) {
        return false;
    }

    protected abstract Long getUserId(HttpServletRequest request);

}
