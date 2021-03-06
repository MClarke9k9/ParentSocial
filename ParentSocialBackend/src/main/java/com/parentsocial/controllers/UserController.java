package com.parentsocial.controllers;

import com.parentsocial.models.User;
import com.parentsocial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class UserController {
    @Autowired

    private UserRepository userRepo;


    @PostMapping("/user")
    @ResponseStatus(value = HttpStatus.CREATED)
    public User createUser(@RequestBody @Valid User user) {
        userRepo.save(user);
        return user;

    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id) {
        Optional<User> user = userRepo.findById(id);

        if (!user.isPresent()) {
            return null;
        }
        return user.get();
    }


    @PutMapping("/user/{id}")
    public void updateUser(@RequestBody User user, @PathVariable int id) {
        if(user.getId() == null)  {
            user.setId(id);
        }
        if(user.getId() != id) {
            throw new IllegalArgumentException("User ID must match your parameter given");
        }
        userRepo.save(user);
    }


    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepo.deleteById(id);
    }
}
