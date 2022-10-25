package com.epam.homework3.controller;

import com.epam.homework3.dto.UserDTO;
import com.epam.homework3.dto.group.OnCreate;
import com.epam.homework3.dto.group.OnUpdate;
import com.epam.homework3.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Artur Kuch
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping()
    @ResponseBody
    public UserDTO createUser(@RequestBody @Validated(OnCreate.class) UserDTO newUser){
        UserDTO created = userService.addUser(newUser);
        log.info("Created new user: " + created);
        return created;
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable long id, @RequestBody @Validated(OnUpdate.class)  UserDTO user){
        log.info("Updating user with ID: " + id);
        return userService.updateUser(id, user);
    }

    @PutMapping("/{userId}/tariff/addTariff/{tariffId}")
    @ResponseBody
    public UserDTO addTariffsToUser(@PathVariable Long userId, @PathVariable Long tariffId){
        System.out.println(tariffId);
        log.info("Setting user tariff with ID: " + userId);
        return userService.setTariffs(tariffId, userId);
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable long id){
        log.info("Getting user with ID: " + id);
        return userService.findUserById(id);
    }

    @GetMapping("/users")
    public List<UserDTO> getAllUsers(){
        log.info("Getting all users.");
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable Long id){
        log.info("Removing user with ID: " + id);
        boolean isRemoved = userService.deleteUser(id);
        if(!isRemoved){
            log.warn("User with ID: " + id + " has not been removed");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.info("User with ID: " + id + " successfully removed");
        return new ResponseEntity<>(id,HttpStatus.OK);
    }

}
