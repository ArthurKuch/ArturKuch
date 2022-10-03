package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validation.MyValidation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * @author Artur Kuch
 */

@Component
public class BeanB implements MyValidation {
    @Value("${beanB.name}")
    private String name;
    @Value("${beanB.value}")
    private int value;

    private void initMethod(){
        System.out.println("BeanB: init method");
    }

    private void destroyMethod(){
        System.out.println("BeanB: destroy method");
    }

    public void modify(){
        System.out.println("BeanB: modify method");
    }

    @Override
    public String toString() {
        return "BeanB{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public void validate() {
        if(this.name == null){
            this.name = "BeanB name";
        }
        if(this.value < 0){
            this.value = 2;
        }
    }
}