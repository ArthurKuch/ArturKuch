package com.epam.homework3.repository;

import com.epam.homework3.entity.ISPService;
import com.epam.homework3.entity.Tariff;
import javax.annotation.PostConstruct;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @author Artur Kuch
 */
@RequiredArgsConstructor
@Repository
public class TariffRepo {

    private final Map<Long,Tariff> tariffMap = new HashMap<>();
    private final ISPServiceRepo serviceRepo;


    @PostConstruct
    public void initTariffs(){
        long id;
        List<ISPService> ispServices = new ArrayList<>();
        ispServices.add(new ISPService(0,"Repo", " repo"));
        for(int i = 0; i < 10; i++) {
            id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
            tariffMap.put(id, Tariff.builder()
                    .id(id)
                    .name("Repo name" + i)
                    .description("Repo description" + i)
                    .services(ispServices)
                    .build());
        }
    }

    public Tariff findTariffById(long id){
        return tariffMap.get(id);
    }

    public Tariff addTariff(Tariff newTariff, List<Long> ispServiceId){
        List<ISPService> ispServices = new ArrayList<>();
        for(Long i : ispServiceId){
            if(serviceRepo.findServiceById(i) != null){
                ispServices.add(serviceRepo.findServiceById(i));
            }
        }
        long id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        newTariff.setId(id);
        newTariff.setServices(ispServices);
        tariffMap.put(id, newTariff);
        return newTariff;
    }

    public Tariff updateTariff(long id, Tariff tariff){return tariffMap.put(id, tariff);}

    public boolean deleteTariff(long id){
        tariffMap.remove(id);
        return !tariffMap.containsKey(id);
    }

    public List<Tariff> getAllTariffs(){
        List<Tariff> tariffs = new ArrayList<>();
        for(Map.Entry<Long, Tariff> entry : tariffMap.entrySet()){
            tariffs.add(entry.getValue());
        }
        return tariffs;
    }

}
