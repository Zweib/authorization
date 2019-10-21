package com.chang.shiro.authorization.persistent.repository;

import com.chang.shiro.authorization.domain.model.authorization.UrlResource;
import com.chang.shiro.authorization.domain.vo.request.UrlResourceCreateRequest;
import com.chang.shiro.authorization.domain.vo.request.UrlResourceQueryRequest;
import com.chang.shiro.authorization.persistent.dao.UrlResourceDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UrlResourceRepository {

    @Autowired
    private UrlResourceDao urlResourceDao;

    @Autowired
    private MongoTemplate mongoTemplate;

    public UrlResource getUrlResourceByUrl(Long id) {
        Optional<UrlResource> urlResourceOpt = urlResourceDao.findById(id);
        if (!urlResourceOpt.isPresent()) {
            return null;
        }
        return urlResourceOpt.get();
    }

    public UrlResource getUrlResourceByUrl(String url, String method) {
        Optional<UrlResource> urlResourceOpt = urlResourceDao.getUrlResourceByUrlAndMethod(url, method);
        if (!urlResourceOpt.isPresent()) {
            return null;
        }
        return urlResourceOpt.get();
    }

    public List<UrlResource> urlResourceQuery(UrlResourceQueryRequest request) {
        Pageable page = PageRequest.of(request.getPage() - 1, request.getSize());
        Criteria criteria = buildCriteria(request);
        Query query = Query.query(criteria)
                .with(page)
                .with(Sort.by(Sort.Direction.ASC, "createTime"));
        List<UrlResource> results = mongoTemplate.find(query, UrlResource.class, "urlResource");
        return results;
    }

    public Long urlResourceCount(UrlResourceQueryRequest request) {
        Criteria criteria = buildCriteria(request);
        Query countQuery = Query.query(criteria);
        Long count = mongoTemplate.count(countQuery, UrlResource.class, "urlResource");
        return count;
    }

    //构建查询条件
    private Criteria buildCriteria(UrlResourceQueryRequest request) {

        Criteria criteria = new Criteria();

        if (StringUtils.isNotBlank(request.getUrl())) {
            criteria.and("url").regex(request.getUrl());
        }
        if (null != request.getMethod()) {
            criteria.and("method").is(request.getMethod().name());
        }
        if (StringUtils.isNotBlank(request.getDescription())) {
            criteria.and("description").regex(request.getDescription());
        }

        return criteria;
    }


}
