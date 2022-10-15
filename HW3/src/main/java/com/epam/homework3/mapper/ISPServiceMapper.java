package com.epam.homework3.mapper;

import com.epam.homework3.dto.ISPServiceDTO;
import com.epam.homework3.entity.ISPService;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Artur Kuch
 */

@Mapper
public interface ISPServiceMapper {

    ISPServiceMapper INSTANCE = Mappers.getMapper(ISPServiceMapper.class);

    ISPService toService(ISPServiceDTO dto);

    ISPServiceDTO toServiceDTO(ISPService ISPService);

    List<ISPServiceDTO> toServiceDTO(List<ISPService> allISPServices);

}
