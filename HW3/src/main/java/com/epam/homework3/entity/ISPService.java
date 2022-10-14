package com.epam.homework3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Artur Kuch
 */

@Data
@Builder
@AllArgsConstructor
public class ISPService {

    private long id;
    private String name;
    private String desc;

    public static ISPService.ISPServiceBuilder repoNewServices(long id){
        return ISPService.builder()
                .id(id)
                .name("Repo ISP service name")
                .desc("Repo ISP service desc");
    }

}
