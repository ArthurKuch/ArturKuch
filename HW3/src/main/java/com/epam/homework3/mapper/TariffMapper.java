package com.epam.homework3.mapper;

import com.epam.homework3.dto.TariffDTO;
import com.epam.homework3.entity.Tariff;
import org.mapstruct.Mapper;

/**
 * @author Artur Kuch
 */
@Mapper(componentModel = "spring",
        uses = ServiceListMapper.class)
public interface TariffMapper {

    Tariff toTariff(TariffDTO dto);

    TariffDTO toTariffDTO(Tariff tariff);

}
