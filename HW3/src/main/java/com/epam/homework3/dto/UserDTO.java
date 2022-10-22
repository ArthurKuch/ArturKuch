package com.epam.homework3.dto;

import com.epam.homework3.controller.validation.NameConstraint;
import com.epam.homework3.dto.group.OnCreate;
import com.epam.homework3.dto.group.OnUpdate;
import com.epam.homework3.entity.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
public class UserDTO {

    @Null(message = "Contract number should be empty",
            groups = OnUpdate.class)
    private Long id;

    @Null(message = "Contract number should be empty",
        groups = OnUpdate.class)
    private Long contractNumber;

    private int home;

    @NameConstraint
    @NotBlank(message = "Firstname shouldn't be empty",
            groups = OnCreate.class)
    private String firstname;

    @NameConstraint
    @NotBlank(message = "Lastname shouldn't be empty",
            groups = OnCreate.class)
    private String lastname;

    @Email
    @NotBlank(message = "Email shouldn't be empty",
            groups = OnCreate.class)
    @Null(message = "Email should be empty",
            groups = OnUpdate.class)
    private String email;

    @NotBlank(message = "Street shouldn't be empty",
            groups = OnCreate.class)
    private String street;

    @NotBlank(message = "City shouldn't be empty",
            groups = OnCreate.class)
    private String city;

    @Null(message = "Tariffs should be empty",
            groups = OnCreate.class)
    private List<TariffDTO> tariffs;

    private Role role;

}
