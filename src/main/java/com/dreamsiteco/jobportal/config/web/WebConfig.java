package com.dreamsiteco.jobportal.config.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/// <summary>Inside this class we are going t to implement WebMVCConfigurer</summary>

@Configuration

public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureApiVersioning(ApiVersionConfigurer configurer) {
        configurer.useMediaTypeParameter(MediaType.parseMediaType("application/vnd.dreamsiteco+json"),"v")
                .addSupportedVersions("1.0","2.0")
                .setDefaultVersion("1.0"); //Using useMediaType to control the API versioning inside my application

    }


    /// <summary>Configuring a Prefix for all controllers  </summary>
    /// <params>Prefix: the prefix to apply (e.g /api)</params>
    /// <params>Predicate: a predicate for matching a controller types
    ///  (e.g controllerType->true or the unmaned variable type(_) as used) Allow our prefix
    /// part to be applied throughout our application</params>
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix("/api",_->true);
    }
}
