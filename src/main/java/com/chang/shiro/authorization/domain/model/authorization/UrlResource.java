package com.chang.shiro.authorization.domain.model.authorization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlResource {

    private Long id;

    // url
    private String url;

    // url 请求方法
    private String method;

    // url funciton description
    private String description;

    // url 状态
    private Boolean status;

    private Date createTime;

    private Date updateTime;
}
