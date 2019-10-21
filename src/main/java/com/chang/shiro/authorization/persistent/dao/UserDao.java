package com.chang.shiro.authorization.persistent.dao;

import com.chang.shiro.authorization.domain.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends MongoRepository<User, Long> {
}
