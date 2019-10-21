package com.chang.shiro.authorization.persistent.dao;

import com.chang.shiro.authorization.domain.model.authorization.UserRoleBind;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRoleBindDao extends MongoRepository<UserRoleBind, Long> {

    List<UserRoleBind> getUserRoleBindByUserId(Long userId);

}
