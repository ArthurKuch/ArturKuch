package com.epam.spring.homework1.beans;

import org.springframework.stereotype.Component;

/**
 * @author Artur Kuch
 */
@Component
public class BeanB {
    public BeanB() {
        System.out.println(this.getClass().getSimpleName());
    }
}
