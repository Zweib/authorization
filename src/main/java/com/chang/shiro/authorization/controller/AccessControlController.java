package com.chang.shiro.authorization.controller;

import com.chang.shiro.authorization.domain.model.authorization.UrlResource;
import com.chang.shiro.authorization.domain.vo.request.*;
import com.chang.shiro.authorization.service.AccessControlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/authorize")
@Api(value = "权限控制相关")
public class AccessControlController {

    @Autowired
    private AccessControlService accessControlService;

    @ApiOperation(value = "查询资源")
    @RequestMapping(value = "/urlResource/query", method = RequestMethod.POST)
    @ResponseBody
    public List<UrlResource> urlResourceQuery(@RequestBody UrlResourceQueryRequest urlResourceQueryRequest) {
        List<UrlResource> list = accessControlService.urlResourceQuery(urlResourceQueryRequest);
        return list;
    }

    @ApiOperation(value = "创建/修改资源")
    @RequestMapping(value = "/urlResource/createOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public Boolean urlResourceCreate(@RequestBody UrlResourceCreateRequest urlResourceCreateRequest) {
        Boolean result = accessControlService.createOrUpdate(urlResourceCreateRequest);
        return result;
    }

    @ApiOperation(value = "删除资源")
    @RequestMapping(value = "/urlResource/create", method = RequestMethod.POST)
    @ResponseBody
    public String urlResourceDelete(@RequestBody UrlResourceCreateRequest urlResourceCreateRequest) {
        return "hello";
    }

    @ApiOperation(value = "查询角色")
    @RequestMapping(value = "/role/query", method = RequestMethod.POST)
    @ResponseBody
    public String roleQuery() {
        return "hello";
    }

    @ApiOperation(value = "创建或修改角色")
    @RequestMapping(value = "/role/createOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public String roleCreate(@RequestBody RoleCreateRequest roleCreateRequest) {
        return "hello";
    }

    @ApiOperation(value = "角色资源绑定")
    @RequestMapping(value = "/role/createOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public String roleUrlResourceBind(@RequestBody RoleUrlResourceBindRequest roleUrlResourceBindRequest) {
        return "hello";
    }

    @ApiOperation(value = "角色资源绑定")
    @RequestMapping(value = "/userRole/createOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public String userRoleBind(@RequestBody UserRoleBindRequest userRoleBindRequest) {
        return "hello";
    }



}
