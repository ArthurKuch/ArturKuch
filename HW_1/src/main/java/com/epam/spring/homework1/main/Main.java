package com.epam.spring.homework1.main;

import com.epam.spring.homework1.config.BeansConfig;
import com.epam.spring.homework1.pet.Cheetah;
import com.epam.spring.homework1.pet.Pet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Artur Kuch
 */
public class Main {

    public static void main(String[] args) {
        //The main 9 points are ready
       AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeansConfig.class);
        ctx.getBean(Pet.class).printPets();

        //Experiment with the 10 point
        System.out.println(ctx.getBean(Cheetah.class));
        System.out.println(ctx.getBean("cheetahPrimary"));

        ctx.close();

    }

}
