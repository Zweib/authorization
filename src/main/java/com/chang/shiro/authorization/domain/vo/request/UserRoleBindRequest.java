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
public class UserRoleBindRequest {

    @ApiModelProperty(value = "operator id")
    private Long userId;

    @ApiModelProperty(value = "role id")
    private Long roleId;
}
