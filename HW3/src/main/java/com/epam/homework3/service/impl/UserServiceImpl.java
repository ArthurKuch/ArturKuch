package com.epam.homework3.service.impl;

import com.epam.homework3.dto.UserDTO;
import com.epam.homework3.entity.User;
import com.epam.homework3.mapper.UserMapper;
import com.epam.homework3.repository.UserRepo;
import com.epam.homework3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Artur Kuch
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public UserDTO addUser(UserDTO newUser) {
        User user = UserMapper.INSTANCE.toUser(newUser);
        return UserMapper.INSTANCE.toUserDTO(userRepo.addUser(user));
    }

    @Override
    public UserDTO updateUser(long id, UserDTO user) {
        return null;
    }

    @Override
    public UserDTO findUserById(long id) {
        return null;
    }

    @Override
    public boolean deleteUser(long id) {
        return false;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return null;
    }
}
