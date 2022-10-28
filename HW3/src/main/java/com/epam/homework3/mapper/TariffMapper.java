package com.epam.homework3.mapper;

import com.epam.homework3.dto.TariffDTO;
import com.epam.homework3.entity.Tariff;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Artur Kuch
 */
@Mapper(uses = {ISPServiceMapper.class})
public interface TariffMapper {

    TariffMapper INSTANCE = Mappers.getMapper(TariffMapper.class);
    @Mapping(target = "services", ignore = false)
    Tariff toTariff(TariffDTO dto);
    @Mapping(target = "services", ignore = false)
    TariffDTO toTariffDTO(Tariff tariff);

    List<TariffDTO> toTariffDTO(List<Tariff> allTariffs);




}
