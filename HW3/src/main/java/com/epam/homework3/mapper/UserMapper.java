package com.epam.homework3.mapper;

import com.epam.homework3.dto.UserDTO;
import com.epam.homework3.entity.User;
import org.mapstruct.Mapper;

/**
 * @author Artur Kuch
 */

@Mapper(componentModel = "spring",
        uses = TariffListMapper.class)
public interface UserMapper {

    User toUser(UserDTO userDTO);

    UserDTO toUserDTO(User user);

}
