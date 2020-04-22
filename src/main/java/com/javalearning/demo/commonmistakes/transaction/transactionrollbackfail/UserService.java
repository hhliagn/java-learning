package com.javalearning.demo.commonmistakes.transaction.transactionrollbackfail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //异常被捕获，事务不回滚
    @Transactional
    public void createUserWrong1(String name) {
        try {
            userRepository.save(new UserEntity(name));
            throw new RuntimeException("error");
        } catch (RuntimeException e) {
            log.error("create user fail because: {}", e.getMessage());
        }
    }

    //异常不是RuntimeException 或 Error，事务不回滚
    @Transactional
    public void createUserWrong2(String name) throws IOException {
        userRepository.save(new UserEntity(name));
        othertask();
    }

    private void othertask() throws IOException {
        Files.readAllLines(Paths.get("files-that-not-exist"));
    }

    @Transactional
    public void createUserRight1(String name) {
        try {
            userRepository.save(new UserEntity(name));
            throw new RuntimeException("error");
        } catch (Exception ex) {
            log.error("create user failed", ex);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        log.info("result: {}", getUserCount(name));
    }

    @Transactional(rollbackFor = Exception.class)
    public void createUserRight2(String name) throws IOException {
        userRepository.save(new UserEntity(name));
        othertask();
    }

    public int getUserCount(String name) {
        return userRepository.findByName(name).size();
    }
}
