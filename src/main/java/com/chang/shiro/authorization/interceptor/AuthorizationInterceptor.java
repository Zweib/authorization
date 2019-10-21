package com.chang.shiro.authorization.interceptor;

import com.chang.shiro.authorization.persistent.repository.RoleUrlResourceBindRepository;
import com.chang.shiro.authorization.persistent.repository.UrlResourceRepository;
import com.chang.shiro.authorization.persistent.repository.UserRoleBindRepository;

import javax.servlet.http.HttpServletRequest;

public class AuthorizationInterceptor extends AbstractAuthorizationInterceptor {

    String USER_IDENTITY = "X-USER-IDENTITY";

    public AuthorizationInterceptor(UserRoleBindRepository userRoleBindRepository,
                                    UrlResourceRepository urlResourceRepository,
                                    RoleUrlResourceBindRepository roleUrlResourceBindRepository) {
        super(userRoleBindRepository, urlResourceRepository, roleUrlResourceBindRepository);
    }

    @Override
    protected Long getUserId(HttpServletRequest request) {
//        UserIdentity UserIdentity = (UserIdentity) RequestContextHolder.getRequestAttributes().getAttribute(USER_IDENTITY, SCOPE_REQUEST);
        return 12321L;
    }

    @Override
    protected boolean inWhiteList(HttpServletRequest request) {
        return true;
    }


}
