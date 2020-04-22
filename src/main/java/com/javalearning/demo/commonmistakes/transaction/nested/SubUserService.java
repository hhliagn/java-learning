package com.javalearning.demo.commonmistakes.transaction.nested;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
public class SubUserService {

    @Autowired
    private UserDataMapper userDataMapper;

    //对比使用REQUIRES_NEW 可以正常提交 ，NESTED 会因为主事务的回滚而失败
    @Transactional(propagation = Propagation.NESTED)
    public void createSubUser(String name) {
        userDataMapper.insert(name, "sub");
    }
}
