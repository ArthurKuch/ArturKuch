package com.epam.spring.homework1.beans;

import org.springframework.stereotype.Component;

/**
 * @author Artur Kuch
 */
@Component
public class BeanC {
    public BeanC() {
        System.out.println(this.getClass().getSimpleName());
    }
}
