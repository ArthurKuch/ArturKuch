package com.epam.homework3.entity;

import lombok.*;

import java.util.List;

/**
 * @author Artur Kuch
 */

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
public class User {

    private Long id;

    private Long contractNumber;

    private int home;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    private String street;

    private String city;

    private List<Tariff> tariffs;

    private Role role;


}
