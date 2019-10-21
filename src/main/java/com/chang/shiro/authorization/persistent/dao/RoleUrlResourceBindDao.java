package com.chang.shiro.authorization.persistent.dao;

import com.chang.shiro.authorization.domain.model.authorization.RoleResourceBind;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleUrlResourceBindDao extends MongoRepository<RoleResourceBind, Long> {

    List<RoleResourceBind> findResourcesByRoleId(Long roleId);

    List<RoleResourceBind> findRoleResourceBindsByUrlResourceId(Long urlResourceId);

}
