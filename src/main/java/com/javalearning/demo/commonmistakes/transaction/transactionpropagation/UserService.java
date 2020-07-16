package com.javalearning.demo.commonmistakes.transaction.transactionpropagation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubUserService subUserService;

    @Transactional
    public void createUserWrong(){
        createMainUser();
        try {
            subUserService.createSubUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createMainUser() {
        userRepository.save(new UserEntity("main user"));
    }
}
