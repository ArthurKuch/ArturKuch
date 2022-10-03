package com.epam.spring.homework2.another;

import com.epam.spring.homework2.validation.MyValidation;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author Artur Kuch
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessbeforeInitialization using on: " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof MyValidation){
            System.out.println("postProcessAfterInitialization using on:  " + beanName);
            ((MyValidation) bean).validate();
        }
        return bean;
    }
}
