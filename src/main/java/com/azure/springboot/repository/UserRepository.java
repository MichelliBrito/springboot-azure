package com.azure.springboot.repository;

import com.azure.springboot.document.UserDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository  extends ReactiveMongoRepository<UserDocument, String> {
}
