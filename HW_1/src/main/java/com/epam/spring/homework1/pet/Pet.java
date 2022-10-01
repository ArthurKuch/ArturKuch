package com.epam.spring.homework1.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * @author Artur Kuch
 */
@Component
public class Pet {
    private final List<Animal> animalList;

    @Autowired
    public Pet(List<Animal> animalList) {
        this.animalList = animalList;
    }

    public void printPets(){
        animalList.stream().map(animal -> animal.getClass().getSimpleName()).forEach(System.out::println);
    }
}
