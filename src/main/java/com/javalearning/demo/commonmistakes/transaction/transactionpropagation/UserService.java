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

    //子事务抛出RuntimeException，事务失败，回滚
    @Transactional
    public void createUserWrong(UserEntity userEntity) {
        createMainUser(userEntity);
        subUserService.createSubUserWithExceptionWrong(userEntity);
    }

    //默认：Participating transaction failed - marking existing transaction as rollback-only
    //参与的事务失败，标记所有存在的事务状态为rollback-only
    //所以事务还是会回滚
    @Transactional
    public void createUserWrong2(UserEntity userEntity) {
        createMainUser(userEntity);
        try {
            subUserService.createSubUserWithExceptionWrong(userEntity);
        } catch (Exception e) {
            log.info("create sub user fail because: {}", e.getMessage());
        }
    }

    //子事务新启一个事务，两个事务独立运作，互不影响
    //子事务回滚，主事务正常提交
    @Transactional
    public void createUserRight(UserEntity userEntity) {
        createMainUser(userEntity);
        try {
            subUserService.createSubUserWithExceptionRight(userEntity);
        } catch (Exception e) {
            log.info("create sub user fail because: {}", e.getMessage());
        }
    }

    private void createMainUser(UserEntity userEntity) {
        userRepository.save(userEntity);
        log.info("createMainUser finished");
    }

    public int getUserCount(String name) {
        return userRepository.findByName(name).size();
    }
}
