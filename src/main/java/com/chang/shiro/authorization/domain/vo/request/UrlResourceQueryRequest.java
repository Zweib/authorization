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
public class UrlResourceQueryRequest {

    @ApiModelProperty(value = "url pattern")
    private String url;

    @ApiModelProperty(value = "method")
    private RequestMethod method;

    @ApiModelProperty(value = "description pattern")
    private String description;

    private Integer page;

    private Integer size;
}
