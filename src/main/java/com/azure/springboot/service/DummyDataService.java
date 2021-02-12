package com.azure.springboot.service;

import com.azure.springboot.document.UserDocument;
import com.azure.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class DummyDataService {

    @Autowired
    UserRepository userRepository;

    @PostConstruct
    public void createUsers(){
        ArrayList<UserDocument> list = new ArrayList<>();
        UserDocument user1 = new UserDocument();
        user1.setName("Michelli Brito");
        list.add(user1);

        UserDocument user2 = new UserDocument();
        user2.setName("Claudio Maia");
        list.add(user2);

        UserDocument user3 = new UserDocument();
        user3.setName("João Silva");
        list.add(user3);

        List<UserDocument> usersSaved = userRepository.saveAll(list);
        usersSaved.forEach(System.out::println);

    }
}
