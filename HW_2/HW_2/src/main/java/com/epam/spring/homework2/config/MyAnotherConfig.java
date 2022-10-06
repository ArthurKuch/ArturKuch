package com.epam.spring.homework2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Artur Kuch
 */
@Configuration
@ComponentScan({"com.epam.spring.homework2.another",
        "com.epam.spring.homework2.beans"})
public class MyAnotherConfig {
}
