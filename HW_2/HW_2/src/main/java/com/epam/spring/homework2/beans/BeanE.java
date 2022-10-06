package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.exceptions.ValidationException;
import com.epam.spring.homework2.validation.MyValidation;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author Artur Kuch
 */

@Component
public class BeanE implements MyValidation {
    private String name;
    private int value;

    @PostConstruct
    private void postConstruct(){
        System.out.println("BeanE: PostConstruct method");
    }

    @PreDestroy
    private void preDestroy(){
        System.out.println("BeanE: PreDestroy method ");
    }

    @Override
    public String toString() {
        return "BeanE{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
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
