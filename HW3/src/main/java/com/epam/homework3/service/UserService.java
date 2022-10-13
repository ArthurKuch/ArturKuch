package com.epam.homework3.service;

import com.epam.homework3.dto.UserDTO;

import java.util.List;

/**
 * @author Artur Kuch
 */
public interface UserService {

    UserDTO addUser(UserDTO newUser);

    UserDTO updateUser(long id,UserDTO user);

    UserDTO findUserById(long id );

    boolean deleteUser(long id);

    List<UserDTO> getAllUsers();



}
