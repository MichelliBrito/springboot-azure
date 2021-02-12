package com.azure.springboot.service;

import com.azure.springboot.document.UserDocument;
import com.azure.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDocument save(UserDocument userDocument){
        return userRepository.save(userDocument);
    }

    public List<UserDocument> findAll(){
        return userRepository.findAll();
    }
}
