package com.ssaa.controller;

import java.util.List;

import com.ssaa.model.UserModel;
import com.ssaa.service.UserServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserServiceFacade userServiceFacade;

    @PostMapping("/create")
    public UserModel create(@RequestBody UserModel userModel) {
        return userServiceFacade.createUser(userModel);
    }

    @GetMapping("/read")
    public List<UserModel> read() {
        return userServiceFacade.readAllUser();
    }

    @GetMapping("/read/{id}")
    public UserModel read(@PathVariable Long id) {
        return userServiceFacade.findUserById(id);
    }

    @PutMapping("/update")
    public UserModel update(@RequestBody UserModel userModel) {
        return userServiceFacade.updateExistingUser(userModel);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return userServiceFacade.deleteUser(id);
    }

}
