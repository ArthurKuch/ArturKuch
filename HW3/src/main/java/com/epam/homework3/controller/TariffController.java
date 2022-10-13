package com.epam.homework3.controller;

import com.epam.homework3.dto.TariffDTO;
import com.epam.homework3.service.TariffService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Artur Kuch
 */
@RestController
@Slf4j
@AllArgsConstructor
public class TariffController {

    private final TariffService tariffService;


    @PostMapping("/tariff")
    public TariffDTO createTariff(@RequestBody TariffDTO newTariff){
        log.info("Creating tariff");
        return tariffService.addTariff(newTariff);
    }

    @PutMapping("/tariff/{id}")
    public TariffDTO updateTariff(@PathVariable long id, @RequestBody TariffDTO tariff){
        log.info("Updating tariff with ID: " + id);
        return tariffService.updateTariff(id, tariff);
    }

    @DeleteMapping("/tariff/{id}")
    public ResponseEntity<Long> deleteTariff(@PathVariable Long id){
        log.info("Removing tariff with ID: " + id);
        boolean isRemoved = tariffService.deleteTariff(id);
        if(!isRemoved){
            log.warn("Tariff with ID: " + id + " has not been removed");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.warn("Tariff with ID: " + id + " successfully removed");
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/tariffs")
    public List<TariffDTO> getAllTariffs(){
        log.info("Getting all tariffs.");
        return tariffService.getAllTariffs();
    }

    @GetMapping("/tariff/{id}")
    public TariffDTO getTariff(@PathVariable long id){
        log.info("Getting tariff with ID: " + id);
        return tariffService.findTariffById(id);
    }

}
