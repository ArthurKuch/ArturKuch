package com.epam.homework3.repository;

import com.epam.homework3.entity.Role;
import com.epam.homework3.entity.User;
import com.epam.homework3.exception.EntityNotFoundException;
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
            users.put(id, User.repoNewUsers(id)
                    .firstname("Repo firstname" + i)
                    .lastname("Repo lastname" + i)
                    .email("Repo email" + i)
                    .city("Repo city" + i)
                    .street("Repo street" + i)
                    .home(1)
                    .contractNumber((long)i)
                    .role(Role.USER)
                    .build());
        }
    }

    public User findUserById(long id){
        return users.entrySet().stream()
                .filter(user->user.getKey().equals(id))
                .findAny()
                .orElseThrow(EntityNotFoundException::new).getValue();
    }

    public User addUser(User newUser){
        long id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        newUser.setId(id);
        users.put(id, newUser);
        return newUser;
    }

    public User updateUser(long id, User user){
        boolean userExist = users.entrySet()
                .stream().anyMatch(exist -> exist.getKey().equals(id));
        if(userExist){
            user.setId(id);
            user.setRole(users.get(id).getRole());
            user.setEmail(users.get(id).getEmail());
            user.setContractNumber(users.get(id).getContractNumber());
            users.put(id,user);
            return users.get(id);
        }else {
            throw new EntityNotFoundException();
        }
    }

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
