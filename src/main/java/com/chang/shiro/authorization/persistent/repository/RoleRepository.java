package com.chang.shiro.authorization.persistent.repository;

import com.chang.shiro.authorization.domain.model.authorization.Role;
import com.chang.shiro.authorization.persistent.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RoleRepository {

    @Autowired
    private RoleDao roleDao;

    public Role getRoleById(Long id) {
        Optional<Role> roleOpt = roleDao.findById(id);
        if (!roleOpt.isPresent()) {
            return null;
        }
        return roleOpt.get();
    }

    public List<Role> getRoleList() {
        return roleDao.findAll();
    }

}
