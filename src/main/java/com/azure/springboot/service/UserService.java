package com.azure.springboot.service;

import com.azure.springboot.document.UserDocument;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Flux<UserDocument> findAll();
    Mono<UserDocument> findById(String id);
    Mono<UserDocument> save(UserDocument userDocument);
}
