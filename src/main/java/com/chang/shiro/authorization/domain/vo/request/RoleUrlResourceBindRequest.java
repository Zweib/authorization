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
public class RoleUrlResourceBindRequest {

    @ApiModelProperty(value = "role id")
    private Long roleId;

    @ApiModelProperty(value = "url resource id")
    private Long urlResourceId;

}
