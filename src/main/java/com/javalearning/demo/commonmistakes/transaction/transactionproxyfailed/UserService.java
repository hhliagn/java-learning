package com.javalearning.demo.commonmistakes.transaction.transactionproxyfailed;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService self;

    @PostConstruct
    public void init(){
        log.info("this get Class:{}, self get Class:{}",
                this.getClass().getName(),
                self.getClass().getName());
    }

    @Transactional
    public void createUserWrong(){
        this.createUserPrivate();
    }

    @Transactional
    public void createUserWrong2(){
        this.createUserPublic();
    }

    private void createUserPrivate() {
        userRepository.save(new UserEntity("test"));
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createUserPublic(){
        userRepository.save(new UserEntity("test"));
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
