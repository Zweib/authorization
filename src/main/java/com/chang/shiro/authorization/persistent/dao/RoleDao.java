package com.chang.shiro.authorization.persistent.dao;

import com.chang.shiro.authorization.domain.model.authorization.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends MongoRepository<Role, Long> {
}
