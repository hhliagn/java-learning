package com.javalearning.demo.id_generate;

import com.baidu.fsg.uid.service.UidGenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description
 * @date 2020/5/11
 */
@Service
public class IdGenerateService {
    @Autowired
    private UidGenService uidGenService;
    public String id(){
        return String.valueOf(uidGenService.getUid());
    }
}
