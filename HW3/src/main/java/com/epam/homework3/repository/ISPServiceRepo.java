package com.epam.homework3.repository;

import com.epam.homework3.entity.ISPService;
import com.epam.homework3.entity.Tariff;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author Artur Kuch
 */
@Component
public class ISPServiceRepo {

    private final Map<Long, ISPService> ispServiceMap = new HashMap<>();

    @PostConstruct
    public void initTariffs(){
        long id;
        for(int i = 0; i < 10; i++) {
            id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
            ispServiceMap.put(id, ISPService.repoNewServices(id)
                     .name("Repo name " + i)
                     .desc("Repo description")
                    .build());
        }
    }

    public ISPService findServiceById(long id){
        return ispServiceMap.get(id);
    }

    public ISPService addISPService(ISPService newISPservice){
        long id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        newISPservice.setId(id);
        ispServiceMap.put(id, newISPservice);
        return newISPservice;
    }

    public ISPService updateISPService(long id, ISPService ispService){return ispServiceMap.put(id, ispService);}

    public boolean deleteTariff(long id){
        ispServiceMap.remove(id);
        return !ispServiceMap.containsKey(id);
    }

    public List<ISPService> getAllISPServices(){
        List<ISPService> services = new ArrayList<>();
        for(Map.Entry<Long, ISPService> entry : ispServiceMap.entrySet()){
            services.add(entry.getValue());
        }
        return services;
    }

}
