package com.epam.homework3.mapper;

import com.epam.homework3.dto.UserDTO;
import com.epam.homework3.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Artur Kuch
 */
@Mapper(uses = {TariffMapper.class})
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "password", ignore = false)
    User toUser(UserDTO userDTO);

    @Mapping(target = "password", ignore = false)
    UserDTO toUserDTO(User user);

    List<UserDTO> toUserDTO(List<User> allUsers);

}
