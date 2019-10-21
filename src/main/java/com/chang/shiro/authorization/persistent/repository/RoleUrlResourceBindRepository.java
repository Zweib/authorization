package com.chang.shiro.authorization.persistent.repository;

import com.chang.shiro.authorization.domain.model.authorization.RoleResourceBind;
import com.chang.shiro.authorization.persistent.dao.RoleUrlResourceBindDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleUrlResourceBindRepository {

    @Autowired
    private RoleUrlResourceBindDao roleUrlResourceBindDao;

    public List<RoleResourceBind> getRoleResourceBindsByRoleId(Long roleId) {
        return null;
    }

    public List<RoleResourceBind> getRoleResourceBindsByUrlResourceId(Long urlResourceId) {
        return roleUrlResourceBindDao.findRoleResourceBindsByUrlResourceId(urlResourceId);
    }

}
