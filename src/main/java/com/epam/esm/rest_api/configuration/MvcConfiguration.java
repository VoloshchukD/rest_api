package com.epam.esm.rest_api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.Collections;

@Configuration
@ComponentScan("com.epam.esm.rest_api")
@EnableWebMvc
public class MvcConfiguration {

    @Bean
    public MappingJackson2HttpMessageConverter createMessageConverter() {
        return new MappingJackson2HttpMessageConverter();
    }

    @Bean
    public RequestMappingHandlerAdapter createMappingHandler() {
        RequestMappingHandlerAdapter mappingHandlerAdapter = new RequestMappingHandlerAdapter();
        mappingHandlerAdapter.setMessageConverters(Collections.singletonList(createMessageConverter()));
        return new RequestMappingHandlerAdapter();
    }

}
