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

    private String street;

    private String city;

    private List<Tariff> tariffs;

    private Role role;

    public static User.UserBuilder repoNewUsers(long id){
        return User.builder()
                .id(id)
                .contractNumber(1L)
                .home(1)
                .firstname("Repo firstname")
                .lastname("Repo lastname")
                .email("Repo email")
                .street("Repo street")
                .city("Repo city")
                .role(Role.USER);
    }

}
