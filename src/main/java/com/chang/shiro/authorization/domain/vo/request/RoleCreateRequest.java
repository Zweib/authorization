package com.chang.shiro.authorization.domain.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleCreateRequest {

    @ApiModelProperty(value = "role id")
    private Long roleId;

    // role name;
    @ApiModelProperty(value = "role name")
    private String name;

    // role description;
    @ApiModelProperty(value = "role description")
    private String description;

    @ApiModelProperty(value = "role status")
    private Boolean status;

}
