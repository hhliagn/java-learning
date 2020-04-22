package com.javalearning.demo.commonmistakes.transaction.nested;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
public class UserService {

    @Autowired
    private UserDataMapper userDataMapper;
    @Autowired
    private SubUserService subUserService;

    @Transactional
    public void createUser(String name) {
        createMainUser(name);
        subUserService.createSubUser(name);
        throw new RuntimeException("create main user error");
    }

    private void createMainUser(String name) {
        userDataMapper.insert(name, "main");
    }

    public int getUserCount(String name) {
        return userDataMapper.count(name);
    }
}
