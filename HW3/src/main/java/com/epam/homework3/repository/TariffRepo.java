package com.epam.homework3.repository;

import com.epam.homework3.entity.Tariff;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author Artur Kuch
 */
@Component
public class TariffRepo {

    private final Map<Long,Tariff> tariffMap = new HashMap<>();



    @PostConstruct
    public void initTariffs(){
        long id;
        for(int i = 0; i < 10; i++) {
            id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
            tariffMap.put(id, Tariff.repoNewTariffs(id)
                    .name("Repo name" + i)
                    .description("Repo description" + i)
                    .build());
        }
    }

    public Tariff findTariffById(long id){
        return tariffMap.get(id);
    }

    public Tariff addTariff(Tariff newTariff){
        long id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        newTariff.setId(id);
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
