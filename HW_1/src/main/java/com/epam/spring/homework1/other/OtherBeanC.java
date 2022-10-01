package com.epam.spring.homework1.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Artur Kuch
 */
@Component
public class OtherBeanC {
    @Autowired
    private OtherBeanC beanC;

    public OtherBeanC() {
        System.out.println(beanC);
    }
}
