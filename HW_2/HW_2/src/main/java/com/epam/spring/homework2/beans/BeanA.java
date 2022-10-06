package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.exceptions.ValidationException;
import com.epam.spring.homework2.validation.MyValidation;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author Artur Kuch
 */

@Component
public class BeanA implements InitializingBean, DisposableBean, MyValidation {
    private String name;
    private int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String
    toString() {
        return "BeanA{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("BeanA: after properties");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("BeanA: destroy using overriding method");
    }

    @Override
    public void validate() {
        if(name == null || value < 0){
            try {
                throw new ValidationException(getClass().getSimpleName());
            } catch (ValidationException e) {
                System.out.println(getClass().getSimpleName() + " validation exception");
            }
        }
    }
}
