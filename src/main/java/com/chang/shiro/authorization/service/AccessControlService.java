package com.chang.shiro.authorization.service;

import com.chang.shiro.authorization.domain.model.authorization.UrlResource;
import com.chang.shiro.authorization.domain.vo.request.UrlResourceCreateRequest;
import com.chang.shiro.authorization.domain.vo.request.UrlResourceQueryRequest;
import com.chang.shiro.authorization.persistent.repository.RoleRepository;
import com.chang.shiro.authorization.persistent.repository.UrlResourceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AccessControlService {

    @Autowired
    private UrlResourceRepository urlResourceRepository;

    @Autowired
    private RoleRepository roleRepository;

    public List<UrlResource> urlResourceQuery(UrlResourceQueryRequest request) {
        return urlResourceRepository.urlResourceQuery(request);
    }

    public Boolean createOrUpdate(UrlResourceCreateRequest request) {
        if(null == request.getId()) {

        }
        return true;
    }
}
