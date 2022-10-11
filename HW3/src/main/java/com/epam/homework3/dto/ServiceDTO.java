package com.epam.homework3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Artur Kuch
 */

@Data
@Builder
@AllArgsConstructor
public class ServiceDTO {

    private String name;
    private String desc;

}
