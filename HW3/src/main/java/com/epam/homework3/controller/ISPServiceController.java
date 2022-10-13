package com.epam.homework3.controller;

import com.epam.homework3.dto.ISPServiceDTO;
import com.epam.homework3.service.ISPServiceService;
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
public class ISPServiceController {

    private final ISPServiceService ispServiceService;

    @PostMapping("/service")
    public ISPServiceDTO createISPService(@RequestBody ISPServiceDTO ispService){
        log.info("Creating new ISP service");
        return ispServiceService.addService(ispService);
    }

    @PutMapping("/service/{id}")
    public ISPServiceDTO updateISPService(@PathVariable long id, ISPServiceDTO ispService){
        log.info("Updating ISP service with ID: " + id);
        return ispServiceService.updateService(id, ispService);
    }

    @DeleteMapping("/service/{id}")
    public ResponseEntity<Long> deleteISPService(@PathVariable Long id){
        log.info("Removing ISP service with ID: " + id);
        boolean isRemoved = ispServiceService.deleteService(id);
        if(!isRemoved){
           log.warn("ISP service with ID: " + id + " has not been removed");
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.info("ISP service with ID: " + id + " successfully removed");
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/service/{id}")
    public ISPServiceDTO getISPService(@PathVariable long id){
        log.info("Getting ISP service with ID: " + id);
        return ispServiceService.findServiceById(id);
    }

    @GetMapping("/services")
    public List<ISPServiceDTO> getAllISPServices(){
        log.info("Getting all ISP services");
        return ispServiceService.getAllServices();
    }


}
