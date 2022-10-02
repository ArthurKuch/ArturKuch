package com.epam.spring.homework2.beans;

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
        if(this.name == null){
            this.name = "BeanA name";
        }
        if(this.value < 0){
            this.value = 1;
        }
    }
}
