package com.epam.homework3.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur Kuch
 */

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
public class Tariff {

    private long id;

    private String name;

    private String description;

    private double price;

    private List<ISPService> services;


}
