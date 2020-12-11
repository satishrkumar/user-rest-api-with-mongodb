package com.ssaa.service;


import java.util.List;

import com.ssaa.model.UserModel;

public interface UserServiceFacade {
    UserModel createUser(UserModel userModel);

    List<UserModel> readAllUser();

    UserModel findUserById(Long id);

    UserModel updateExistingUser(UserModel userModel);

    String deleteUser(Long id);
}
