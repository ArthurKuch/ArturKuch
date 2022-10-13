package com.epam.homework3.dto;

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
public class TariffDTO {

    private long id;
    private String name;
    private String description;
    private double price;
    private List<ISPServiceDTO> services;

}
