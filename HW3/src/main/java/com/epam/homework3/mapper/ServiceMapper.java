package com.epam.homework3.mapper;

import com.epam.homework3.dto.ServiceDTO;
import com.epam.homework3.entity.Service;
import org.mapstruct.Mapper;

/**
 * @author Artur Kuch
 */

@Mapper(componentModel = "spring")
public interface ServiceMapper {

    Service toService(ServiceDTO dto);

    ServiceDTO toServiceDTO(Service service);

}
