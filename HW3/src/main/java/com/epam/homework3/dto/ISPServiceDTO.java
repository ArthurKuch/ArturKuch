package com.epam.homework3.dto;

import com.epam.homework3.dto.group.OnCreate;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Artur Kuch
 */

@Data
@Builder
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ISPServiceDTO {

    private Long id;

    @NotBlank(message = "ISP service name shouldn't be empty",
            groups = OnCreate.class)
    private String name;

    @NotBlank(message = "ISP service description shouldn't be empty",
            groups = OnCreate.class)
    private String desc;

}
