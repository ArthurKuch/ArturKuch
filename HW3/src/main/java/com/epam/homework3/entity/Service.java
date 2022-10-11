package com.epam.homework3.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author Artur Kuch
 */

@Data
@Builder
public class Service {

    private String name;
    private String desc;

}
