package com.epam.homework3.mapper;

import com.epam.homework3.dto.UserDTO;
import com.epam.homework3.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Artur Kuch
 */
@Mapper(uses = {TariffMapper.class})
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserDTO userDTO);

    UserDTO toUserDTO(User user);

    List<UserDTO> toUserDTO(List<User> allUsers);

}
