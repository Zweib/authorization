package com.chang.shiro.authorization.config;

import com.chang.shiro.authorization.interceptor.AuthorizationInterceptor;
import com.chang.shiro.authorization.persistent.repository.RoleUrlResourceBindRepository;
import com.chang.shiro.authorization.persistent.repository.UrlResourceRepository;
import com.chang.shiro.authorization.persistent.repository.UserRoleBindRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class BasicWebConfig implements WebMvcConfigurer {

    @Autowired
    private UserRoleBindRepository userRoleBindRepository;

    @Autowired
    private UrlResourceRepository urlResourceRepository;

    @Autowired
    private RoleUrlResourceBindRepository roleUrlResourceBindRepository;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthorizationInterceptor(userRoleBindRepository,
                urlResourceRepository, roleUrlResourceBindRepository));
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders(CorsConfiguration.ALL)
                .allowedMethods("POST", "PUT", "OPTIONS", "GET", "DELETE", "PATCH")
                .allowCredentials(true)
                .allowedOrigins("*");
    }

}
