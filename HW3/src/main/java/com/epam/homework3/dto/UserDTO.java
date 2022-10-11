package com.epam.homework3.dto;

import com.epam.homework3.entity.Role;
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
public class UserDTO {

    private long id;
    private long contractNumber;
    private int home;
    private String firstname;
    private String lastname;
    private String email;
    private String street;
    private String city;
    private List<TariffDTO> tariffs;
    private Role role;

}
