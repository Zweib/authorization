package com.chang.shiro.authorization.domain.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMethod;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UrlResourceCreateRequest {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "url")
    private String url;

    // url 请求方法
    @ApiModelProperty(value = "url method, value: PUT POST GET DELETE ...")
    private RequestMethod method;

    // url funciton description
    @ApiModelProperty(value = "url description")
    private String description;

    @ApiModelProperty(value = "status")
    private Boolean status;

}
