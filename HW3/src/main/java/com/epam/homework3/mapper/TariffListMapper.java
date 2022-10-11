package com.epam.homework3.mapper;

import com.epam.homework3.dto.TariffDTO;
import com.epam.homework3.entity.Tariff;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Artur Kuch
 */
@Mapper(componentModel = "spring",
        uses = {TariffMapper.class, ServiceListMapper.class})
public interface TariffListMapper {

    List<Tariff> toTariffList(List<TariffDTO> tariffDTOS);

    List<TariffDTO> toTariffDTOList(List<Tariff> tariffs);

}
