package com.epam.homework3.mapper;

import com.epam.homework3.dto.ISPServiceDTO;
import com.epam.homework3.entity.ISPService;
import org.mapstruct.Mapper;

/**
 * @author Artur Kuch
 */

@Mapper(componentModel = "spring")
public interface ServiceMapper {

    ISPService toService(ISPServiceDTO dto);

    ISPServiceDTO toServiceDTO(ISPService ISPService);

}
