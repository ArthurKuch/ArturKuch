package com.epam.homework3.service;

import com.epam.homework3.dto.ISPServiceDTO;

import java.util.List;

/**
 * @author Artur Kuch
 */
public interface ISPServiceService {

    ISPServiceDTO addService(ISPServiceDTO ispServiceDTO);

    ISPServiceDTO updateService(long id, ISPServiceDTO ispServiceDTO);

    ISPServiceDTO findServiceById(long id);

    boolean deleteService(long id);

    List<ISPServiceDTO> getAllServices();

}
