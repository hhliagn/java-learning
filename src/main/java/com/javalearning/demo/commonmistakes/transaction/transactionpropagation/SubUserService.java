package com.javalearning.demo.commonmistakes.transaction.transactionpropagation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
public class SubUserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void createSubUserWithExceptionWrong(UserEntity userEntity) {
        log.info("createSubUserWithExceptionWrong start");
        userRepository.save(userEntity);
        throw new RuntimeException("invalid status");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createSubUserWithExceptionRight(UserEntity userEntity) {
        log.info("createSubUserWithExceptionRight start");
        userRepository.save(userEntity);
        throw new RuntimeException("invalid status");
    }
}
