package com.epam.homework3.service;

import com.epam.homework3.dto.TariffDTO;


import java.util.List;

/**
 * @author Artur Kuch
 */
public interface TariffService {

    TariffDTO addTariff(TariffDTO newTariff);

    TariffDTO updateTariff(long id, TariffDTO tariff);

    TariffDTO findTariffById(long id);

    boolean deleteTariff(long id);

    List<TariffDTO> getAllTariffs();

}
