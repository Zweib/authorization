package com.chang.shiro.authorization.domain.model.authorization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResourceBind {

    private Long id;

    private Long roleId;

    private Long urlResourceId;

    private Date createTime;

    private Date updateTime;
}
