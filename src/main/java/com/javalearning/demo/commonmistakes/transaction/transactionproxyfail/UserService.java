package com.javalearning.demo.commonmistakes.transaction.transactionproxyfail;

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
    private UserService self;

    //private 方法事务无法代理
    public int createUserWrong1(String name) {
        try {
            createUserPrivate(new UserEntity(name));
        } catch (Exception e) {
            log.error("create user fail because: {}", e.getMessage());
        }
        return getUserCount(name);
    }

    //this 调用事务无法代理
    public int createUserWrong2(String name) {
        try {
            this.createUserPublic(new UserEntity(name));
        } catch (Exception e) {
            log.error("create user fail because: {}", e.getMessage());
        }
        return getUserCount(name);
    }

    //通过Spring注入的对象（被代理）调用，事务可以被回滚
    public int createUserRight(String name) {
        try {
            self.createUserPublic(new UserEntity(name));
        } catch (Exception e) {
            log.error("create user fail because: {}", e.getMessage());
        }
        return getUserCount(name);
    }

    //异常被捕获，事务不会回滚
    //一个事务方法调用另一个事务方法, 一般只会使用主方法的事务，主方法或子方法任一失败，事务都会回滚
    @Transactional
    public int createUserWrong3(String name) {
        try {
            this.createUserPublic(new UserEntity(name));
        } catch (Exception e) {
            log.error("create user fail because: {}", e.getMessage());
        }
//        throw new RuntimeException("main method error");
        return getUserCount(name);
    }

    @Transactional
    private void createUserPrivate(UserEntity userEntity){
        this.userRepository.save(userEntity);
        if ("test".equals(userEntity.getName())){
            throw new RuntimeException("invalid user");
        }
    }

    @Transactional
    public void createUserPublic(UserEntity userEntity) {
        userRepository.save(userEntity);
        if ("test".equals(userEntity.getName())){
            throw new RuntimeException("invalid user");
        }
    }

    public int getUserCount(String name) {
        return userRepository.findByName(name).size();
    }
}
