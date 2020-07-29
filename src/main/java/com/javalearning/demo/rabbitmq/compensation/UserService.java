package com.javalearning.demo.rabbitmq.compensation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public void register(User user){
        users.add(user);
    }

    public List<User> getUserWithLimit(Integer offset, Integer limit){
        return users.stream()
                .filter(user -> user.getId() > offset)
                .limit(limit)
                .collect(Collectors.toList());
    }
}
