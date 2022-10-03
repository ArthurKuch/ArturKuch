package com.epam.spring.homework2.app;

import com.epam.spring.homework2.config.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;


/**
 * @author Artur Kuch
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));

        ctx.close();
    }

}