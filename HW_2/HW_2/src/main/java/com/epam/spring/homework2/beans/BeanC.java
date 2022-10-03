package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validation.MyValidation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Artur Kuch
 */

@Component
public class BeanC implements MyValidation {
    @Value("${beanC.name}")
    private String name;
    @Value("${beanC.value}")
    private int value;

    private void initMethod(){
        System.out.println("BeanC: init method");
    }

    private void destroyMethod(){
        System.out.println("BeanC: destroy method");
    }

    @Override
    public String toString() {
        return "BeanC{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public void validate() {
        if(this.name == null){
            this.name = "BeanC name";
        }
        if(this.value < 0){
            this.value = 3;
        }
    }
}