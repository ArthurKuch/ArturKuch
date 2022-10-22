package com.epam.homework3.service.impl;

import com.epam.homework3.dto.TariffDTO;
import com.epam.homework3.dto.UserDTO;
import com.epam.homework3.entity.Role;
import com.epam.homework3.entity.Tariff;
import com.epam.homework3.entity.User;
import com.epam.homework3.mapper.TariffMapper;
import com.epam.homework3.mapper.UserMapper;
import com.epam.homework3.repository.UserRepo;
import com.epam.homework3.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Artur Kuch
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public UserDTO addUser(UserDTO newUser) {
        log.info("User Service creating a new User " );
        newUser.setRole(Role.USER);
        User user = UserMapper.INSTANCE.toUser(newUser);
        return UserMapper.INSTANCE.toUserDTO(userRepo.addUser(user));
    }

    @Override
    public UserDTO updateUser(long id, UserDTO user) {
        log.info("User Service updating user with ID: " + id);
        User updated = UserMapper.INSTANCE.toUser(user);
        return UserMapper.INSTANCE.toUserDTO(userRepo.updateUser(id, updated));
    }

    @Override
    public UserDTO findUserById(long id) {
        log.info("User Service getting user with ID: " + id);
        return  UserMapper.INSTANCE.toUserDTO(userRepo.findUserById(id));
    }

    @Override
    public UserDTO setTariffs(long tariffId, long userId) {  //need to add Tariff implementation and validation
        log.info("User Service setting tariffs to user with ID: " + userId);
        return UserMapper.INSTANCE.toUserDTO(userRepo.setTariffs(tariffId,userId));
    }

    @Override
    public boolean deleteUser(long id) {
        log.info("User service deleting user with ID: " + id);
        return userRepo.deleteUser(id);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return UserMapper.INSTANCE.toUserDTO(userRepo.getAllUsers());
    }

}
