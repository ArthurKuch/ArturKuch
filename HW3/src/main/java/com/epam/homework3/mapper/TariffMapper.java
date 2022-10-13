package com.epam.homework3.mapper;

import com.epam.homework3.dto.TariffDTO;
import com.epam.homework3.entity.Tariff;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Artur Kuch
 */
@Mapper
public interface TariffMapper {

    /*
        Also needs to add ISP Service Lists implementation
     */

    TariffMapper INSTANCE = Mappers.getMapper(TariffMapper.class);

    Tariff toTariff(TariffDTO dto);

    TariffDTO toTariffDTO(Tariff tariff);

}
