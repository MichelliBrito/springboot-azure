package com.azure.springboot.controller;

import com.azure.springboot.document.UserDocument;
import com.azure.springboot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

    @Autowired
    UserServiceImpl service;

    @GetMapping(value="/users")
    public Flux<UserDocument> getUsers(){
        return service.findAll();
    }


    @GetMapping(value="/users/{id}")
    public Mono<UserDocument> getUserId(@PathVariable String id){
        return service.findById(id);
    }

    @PostMapping(value="/users")
    public Mono<UserDocument> save(@RequestBody UserDocument userDocument){
        return service.save(userDocument);
    }

    @GetMapping(value="/users/webflux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, UserDocument>> getUserByWebflux(){

        System.out.println("---Start get Users by WEBFLUX--- " + LocalDateTime.now());
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        Flux<UserDocument> userFlux = service.findAll();

        return Flux.zip(interval, userFlux);

    }

    @GetMapping(value="/users/mvc")
    public List<String> getUserByMvc() throws InterruptedException {

        System.out.println("---Start get Users by MVC--- " + LocalDateTime.now());


        List<String> userList = new ArrayList<>();
        userList.add("Michelli");
        userList.add("Maria");
        userList.add("Roberto");
        userList.add("Carlos");
        userList.add("Ana Clara");
        TimeUnit.SECONDS.sleep(15);

        return userList;

    }
}
