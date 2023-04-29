package com.mg.eco;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan
@EnableAspectJAutoProxy
public class ApplicationConfig implements WebMvcConfigurer {
    static {
        System.out.println("----------------------------------------CONFIG----------------------------------");
        System.out.println("----------------------------------------CONFIG----------------------------------");
        System.out.println("----------------------------------------CONFIG----------------------------------");
        System.out.println("----------------------------------------CONFIG----------------------------------");
        System.out.println("----------------------------------------CONFIG----------------------------------");
        System.out.println("----------------------------------------CONFIG----------------------------------");
        System.out.println("----------------------------------------CONFIG----------------------------------");
        System.out.println("----------------------------------------CONFIG----------------------------------");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setOrder(0);
        return viewResolver;
    }

}
