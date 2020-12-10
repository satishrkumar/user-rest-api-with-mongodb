package com.ssaa.service;

import java.util.List;
import java.util.Optional;

import com.ssaa.dao.UserDAO;
import com.ssaa.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultServiceFacade implements ServiceFacade {
    @Autowired
    UserDAO userDAO;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @Override
    public UserModel createUser(final UserModel userModel) {
        userModel.setId(sequenceGeneratorService.generateSequence(UserModel.SEQUENCE_NAME));
        return userDAO.save(userModel);
    }

    @Override
    public List<UserModel> readAllUser() {
        return userDAO.findAll();
    }

    @Override
    public UserModel findUserById(final Long id) {
        Optional<UserModel> userModelOptional = userDAO.findById(id);
        if (userModelOptional.isPresent()) {
            return userModelOptional.get();
        } else {
            throw new RuntimeException("User not found with id " + id);
        }
    }

    @Override
    public UserModel updateExistingUser(final UserModel userModel) {
        return userDAO.save(userModel);
    }

    @Override
    public String deleteUser(final Long id) {
        Optional<UserModel> userModelOptional = userDAO.findById(id);
        if (userModelOptional.isPresent()) {
            userDAO.delete(userModelOptional.get());
            return "User deleted with id " + id;
        } else {
            throw new RuntimeException("User not found for id " + id);
        }
    }


}
