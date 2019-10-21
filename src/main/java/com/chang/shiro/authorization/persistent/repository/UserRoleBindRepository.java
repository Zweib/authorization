package com.chang.shiro.authorization.persistent.repository;

import com.chang.shiro.authorization.domain.model.authorization.UserRoleBind;
import com.chang.shiro.authorization.persistent.dao.UserRoleBindDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRoleBindRepository {

    @Autowired
    private UserRoleBindDao userRoleBindDao;

    public List<UserRoleBind> getUserRoleBindByUserId(Long userId) {
        return userRoleBindDao.getUserRoleBindByUserId(userId);
    }

}
