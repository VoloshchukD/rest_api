package com.epam.esm.core.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    public static final String SPRING_PROFILE_PROPERTY = "spring.profiles.active";

    public static final String VM_PROFILE_PROPERTY = "profile.active";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        servletContext.setInitParameter(SPRING_PROFILE_PROPERTY,
                System.getProperty(VM_PROFILE_PROPERTY));
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
