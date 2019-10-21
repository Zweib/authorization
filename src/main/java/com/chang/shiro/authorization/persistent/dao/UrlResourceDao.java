package com.chang.shiro.authorization.persistent.dao;

import com.chang.shiro.authorization.domain.model.authorization.UrlResource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlResourceDao extends MongoRepository<UrlResource, Long> {

    Optional<UrlResource> getUrlResourceByUrlAndMethod(String url, String method);

}
