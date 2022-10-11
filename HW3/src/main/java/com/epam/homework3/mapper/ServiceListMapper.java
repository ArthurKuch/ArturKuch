package com.epam.homework3.mapper;

import com.epam.homework3.dto.ServiceDTO;
import com.epam.homework3.entity.Service;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Artur Kuch
 */
@Mapper(componentModel = "spring",
        uses = ServiceMapper.class)
public interface ServiceListMapper {

    List<Service> toServiceList(List<ServiceDTO> serviceDTOS);

    List<ServiceDTO> toServiceDTOList(List<Service> services);

}
