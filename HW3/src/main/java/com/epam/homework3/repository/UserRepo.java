package com.epam.homework3.repository;

import com.epam.homework3.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author Artur Kuch
 */
@Component
public class UserRepo {

    private final Map<Long, User> users = new HashMap<>();

    @PostConstruct
    private void initUsers(){
        long id;

        for(int i = 0; i < 10; i++){
            id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
            users.put(id, User.repoNewUsers(id).build());
        }
    }

    public User findUserById(long id){return users.get(id);}

    public User addUser(User newUser){
        long id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        newUser.setId(id);
        users.put(id, newUser);
        return newUser;
    }

    public User updateUser(long id, User user){return users.put(id, user);}

    public boolean deleteUser(long id){
        users.remove(id);
        return !users.containsKey(id);
    }

    public List<User> getAllUsers(){
        List<User> userList = new ArrayList<>();
        for (Map.Entry<Long, User> entry : users.entrySet()) {
            userList.add(entry.getValue());
        }
        return userList;
    }


}
