package com.epam.homework3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author Artur Kuch
 */

@Data
@Builder
@AllArgsConstructor
public class Tariff {

    private long id;
    private String name;
    private String description;
    private double price;
    private List<ISPService> ISPServices;

    public static Tariff.TariffBuilder repoNewTariffs(long id){
        return Tariff.builder()
                .id(id)
                .name("Repo tariff name")
                .description("Repo tariff description")
                .price(0.0)
                .ISPServices(null);  //needs to bind with ISPService
    }

}
