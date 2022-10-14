package com.epam.homework3.service.impl;

import com.epam.homework3.dto.UserDTO;
import com.epam.homework3.entity.User;
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
        log.info("User Service creating a new User with ID: " + newUser.getId() );
        User user = UserMapper.INSTANCE.toUser(newUser);
        return UserMapper.INSTANCE.toUserDTO(userRepo.addUser(user));
    }

    @Override
    public UserDTO updateUser(long id, UserDTO user) {
        log.info("User Service updating user with ID: " + id);
        User existingUser = userRepo.findUserById(id);
        if(existingUser == null){
            log.warn("User service: No such user exist");
            return null;
        }
        return UserMapper.INSTANCE.toUserDTO(userRepo.updateUser(id, existingUser));
    }

    @Override
    public UserDTO findUserById(long id) {
        log.info("User Service getting user with ID: " + id);
        UserDTO userDto =  UserMapper.INSTANCE.toUserDTO(userRepo.findUserById(id));
        if(userDto == null){
            log.warn("User service: No such user exist");
            return null;
        }
        return userDto;
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
