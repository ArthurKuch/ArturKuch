package com.epam.homework3.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author Artur Kuch
 */

@Data
@Builder
public class Tariff {

    private long id;
    private String name;
    private String description;
    private double price;
    private List<Service> services;

}
