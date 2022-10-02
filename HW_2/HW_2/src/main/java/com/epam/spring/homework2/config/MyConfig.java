package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.*;
import org.springframework.context.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author Artur Kuch
 */
@Configuration
@PropertySource("classpath:HW2.properties")
@Import(MyAnotherConfig.class)
public class MyConfig {

    @Bean(initMethod = "initMethod",
          destroyMethod = "destroyMethod")
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public BeanD getBeanD(){
        return new BeanD();
    }

    @Bean(initMethod = "initMethod",
          destroyMethod = "destroyMethod")
    @DependsOn("getBeanD")
    public BeanB getBeanB(){
        return new BeanB();
    }

    @Bean(initMethod = "initMethod",
          destroyMethod = "destroyMethod")
    @DependsOn("getBeanB")
    public BeanC getBeanC(){
        return new BeanC();
    }

    @Bean
    public BeanA getBeanA(){
        return new BeanA();
    }

    @Bean
    @Lazy
    public BeanF getBeanF(){
        return new BeanF();
    }
}
