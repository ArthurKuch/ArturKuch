package com.epam.homework3.service.impl;

import com.epam.homework3.dto.TariffDTO;
import com.epam.homework3.entity.Tariff;
import com.epam.homework3.mapper.TariffMapper;
import com.epam.homework3.repository.ISPServiceRepo;
import com.epam.homework3.repository.TariffRepo;
import com.epam.homework3.service.TariffService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Artur Kuch
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class TariffServiceImpl implements TariffService {

    private final TariffRepo tariffRepo;

    @Override
    public TariffDTO addTariff(TariffDTO newTariff) {
        log.info("Tariff Service creating a new Tariff ");
        Tariff tariff = TariffMapper.INSTANCE.toTariff(newTariff);
        return TariffMapper.INSTANCE.toTariffDTO(tariffRepo.addTariff(tariff, newTariff.getServiceIds()));
    }

    @Override
    public TariffDTO updateTariff(long id, TariffDTO tariff) {
        log.info("Tariff Service updating tariff with ID: " + id);
        Tariff existingTariff = tariffRepo.findTariffById(id);
        if(existingTariff == null){
            log.warn("Tariff service: No such tariff exist");
            return null;
        }
        return TariffMapper.INSTANCE.toTariffDTO(tariffRepo.updateTariff(id, existingTariff));
    }

    @Override
    public TariffDTO findTariffById(long id) {
        log.info("Tariff Service getting tariff with ID: " + id);
        TariffDTO tariffDTO = TariffMapper.INSTANCE.toTariffDTO(tariffRepo.findTariffById(id));
        if(tariffDTO == null){
            log.warn("Tariff service: No such tariff exist");
            return null;
        }
        return tariffDTO;
    }

    @Override
    public boolean deleteTariff(long id) {
        log.info("Tariff service deleting tariff with ID: " + id);
        return tariffRepo.deleteTariff(id);
    }

    @Override
    public List<TariffDTO> getAllTariffs() {
        return TariffMapper.INSTANCE.toTariffDTO(tariffRepo.getAllTariffs());
    }

}
