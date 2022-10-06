package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.exceptions.ValidationException;
import com.epam.spring.homework2.validation.MyValidation;
import org.springframework.stereotype.Component;

/**
 * @author Artur Kuch
 */

@Component
public class BeanF implements MyValidation {
    private String name;
    private int value;

    @Override
    public String toString() {
        return "BeanF{" +
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
