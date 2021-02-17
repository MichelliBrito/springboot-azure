package com.azure.springboot.service;

import com.azure.springboot.document.UserDocument;
import com.azure.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Flux<UserDocument> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Mono<UserDocument> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Mono<UserDocument> save(UserDocument userDocument) {
        return userRepository.save(userDocument);
    }
}
