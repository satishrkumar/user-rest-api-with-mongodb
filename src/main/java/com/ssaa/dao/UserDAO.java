package com.ssaa.dao;

import com.ssaa.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends MongoRepository<UserModel, Long> {

}
