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

    private long id;
    private long contractNumber;
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
                .contractNumber(1)
                .home(1)
                .firstname("Repo firstname")
                .lastname("Repo lastname")
                .email("Repo email")
                .street("Repo street")
                .city("Repo city")
                .tariffs(null) //needs to bind with Tariff
                .role(Role.USER);
    }

}
