package com.epam.homework3.controller;

import com.epam.homework3.dto.UserDTO;
import com.epam.homework3.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author Artur Kuch
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public UserDTO createUser(@RequestBody UserDTO newUser){
        log.info("Creating new user with ID: " + newUser.getId());
        return userService.addUser(newUser);
    }

    @PutMapping("/user/{id}")
    public UserDTO updateUser(@PathVariable long id, @RequestBody UserDTO user){
        log.info("Updating user with ID: " + id);
        return userService.updateUser(id, user);
    }

    @GetMapping("/user/{id}")
    public UserDTO getUser(@PathVariable long id){
        log.info("Getting user with ID: " + id);
        return userService.findUserById(id);
    }

    @GetMapping("/users")
    public List<UserDTO> getAllUsers(){
        log.info("Getting all users.");
        return userService.getAllUsers();
    }

    @DeleteMapping("/user/{id}")
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
