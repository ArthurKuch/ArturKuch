package com.epam.homework3.service.impl;

import com.epam.homework3.dto.ISPServiceDTO;
import com.epam.homework3.entity.ISPService;
import com.epam.homework3.mapper.ISPServiceMapper;
import com.epam.homework3.repository.ISPServiceRepo;
import com.epam.homework3.service.ISPServiceService;
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
public class ISPServiceServiceImpl  implements ISPServiceService {

    private final ISPServiceRepo ispServiceRepo;

    @Override
    public ISPServiceDTO addService(ISPServiceDTO ispServiceDTO) {
        log.info("ISPService Service creating a new service " );
        ISPService ispService = ISPServiceMapper.INSTANCE.toService(ispServiceDTO);
        return ISPServiceMapper.INSTANCE.toServiceDTO(ispServiceRepo.addISPService(ispService));
    }

    @Override
    public ISPServiceDTO updateService(long id, ISPServiceDTO ispServiceDTO) {
        log.info("ISPService Service updating service with ID: " + id);
        ISPService existingService = ispServiceRepo.findServiceById(id);

        if(existingService == null){
            log.warn("ISPService service: No such service exist");
            return null;
        }
        return ISPServiceMapper.INSTANCE.toServiceDTO(ispServiceRepo.updateISPService(id, existingService));
    }

    @Override
    public ISPServiceDTO findServiceById(long id) {
        log.info("ISPService Service getting service with ID: " + id);
        ISPServiceDTO ispServiceDTO = ISPServiceMapper.INSTANCE.toServiceDTO(ispServiceRepo.findServiceById(id));
        if(ispServiceDTO == null){
            log.warn("ISPService service: No such service exist");
            return null;
        }
        return ispServiceDTO;
    }

    @Override
    public boolean deleteService(long id) {
        log.info("ISPService service deleting service with ID: " + id);
        return ispServiceRepo.deleteTariff(id);
    }

    @Override
    public List<ISPServiceDTO> getAllServices() {
        return ISPServiceMapper.INSTANCE.toServiceDTO(ispServiceRepo.getAllISPServices());
    }

}
