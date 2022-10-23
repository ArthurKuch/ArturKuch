package com.epam.homework3.utils.actuatorInfo;

import com.epam.homework3.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Artur Kuch
 */
@Component
@RequiredArgsConstructor
public class TotalUsersInfoContributor implements InfoContributor {

    private UserRepo userRepo;

    @Override
    public void contribute(Info.Builder builder) { /// need to provide implementation
        Map<String, Long> userDetails = new HashMap<>();

    }
}
