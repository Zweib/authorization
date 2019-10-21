package com.chang.shiro.authorization.domain.model.authorization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    // role id
    private Long id;

    // role name;
    private String name;

    // role description;
    private String description;

    private Boolean status;

    private Date createTime;

    private Date updateTime;

}
