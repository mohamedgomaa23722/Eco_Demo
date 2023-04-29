package com.mg.eco;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext applicationContext =
                new AnnotationConfigWebApplicationContext();
        applicationContext.register(ApplicationConfig.class);
        DispatcherServlet servlet = new DispatcherServlet(applicationContext);
        ServletRegistration.Dynamic registration =
                servletContext.addServlet("mvc-dispatcher", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");

        System.out.println("----------------------------------------INITIALIZER----------------------------------");
        System.out.println("----------------------------------------INITIALIZER----------------------------------");
        System.out.println("----------------------------------------INITIALIZER----------------------------------");
        System.out.println("----------------------------------------INITIALIZER----------------------------------");
        System.out.println("----------------------------------------INITIALIZER----------------------------------");
        System.out.println("----------------------------------------INITIALIZER----------------------------------");
        System.out.println("----------------------------------------INITIALIZER----------------------------------");
    }
}
