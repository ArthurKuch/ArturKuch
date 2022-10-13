package com.epam.homework3.mapper;

import com.epam.homework3.dto.ISPServiceDTO;
import com.epam.homework3.entity.ISPService;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Artur Kuch
 */
@Mapper(componentModel = "spring",
        uses = ServiceMapper.class)
public interface ServiceListMapper {

    List<ISPService> toServiceList(List<ISPServiceDTO> ISPServiceDTOS);

    List<ISPServiceDTO> toServiceDTOList(List<ISPService> ISPServices);

}
