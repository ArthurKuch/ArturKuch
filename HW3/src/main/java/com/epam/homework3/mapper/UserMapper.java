package com.epam.homework3.mapper;

import com.epam.homework3.dto.UserDTO;
import com.epam.homework3.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Artur Kuch
 */

@Mapper
public interface UserMapper {

    /*
        Also needs to add Tariff Lists implementation
     */

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserDTO userDTO);

    UserDTO toUserDTO(User user);
}
