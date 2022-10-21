package com.epam.homework3.dto;

import com.epam.homework3.dto.group.OnCreate;
import com.epam.homework3.dto.group.OnUpdate;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
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
@JsonInclude(Include.NON_NULL)
public class TariffDTO {

    private Long id;

    @NotBlank(message = "Name shouldn't be empty",
            groups = OnCreate.class)
    private String name;

    @NotBlank(message = "Name shouldn't be empty",
            groups = OnCreate.class)
    private String description;

    @NotBlank(message = "Name shouldn't be empty",
            groups = OnCreate.class)
    private double price;

    
    private List<ISPServiceDTO> services;

}
