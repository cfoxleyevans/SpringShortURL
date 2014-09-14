package com.chrisfoxleyevans.shorturl.conf;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class Initializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(ApplicationConfiguration.class);

        ServletRegistration.Dynamic dynamicServlet =
                servletContext.addServlet("dynamic", new DispatcherServlet(webApplicationContext));
        dynamicServlet.setLoadOnStartup(1);
        dynamicServlet.addMapping("/");
    }
}
