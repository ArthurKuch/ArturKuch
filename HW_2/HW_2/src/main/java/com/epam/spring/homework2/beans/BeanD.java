package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validation.MyValidation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Artur Kuch
 */

@Component
public class BeanD implements MyValidation {
    @Value("${beanD.name}")
    private String name;
    @Value("${beanD.value}")
    private int value;

    private void initMethod(){
        System.out.println("BeanD: init method");
    }

    private void destroyMethod(){
        System.out.println("BeanD: destroy method");
    }

    @Override
    public String toString() {
        return "BeanD{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public void validate() {
        if(this.name == null){
            this.name = "BeanD name";
        }
        if(this.value < 0){
            this.value = 4;
        }
    }
}
