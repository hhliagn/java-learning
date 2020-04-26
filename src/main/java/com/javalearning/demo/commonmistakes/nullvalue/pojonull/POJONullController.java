package com.javalearning.demo.commonmistakes.nullvalue.pojonull;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("pojonull")
@RestController
public class POJONullController {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public void test() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Jdk8Module());
        UserDto result = objectMapper.readValue("{\"id\":\"1\", \"age\":30, \"name\":null}", UserDto.class);
        log.info("field name with null value dto:{} name:{}", result, result.getName().orElse("N/A"));
        // field name with null value dto:UserDto(id=1, name=Optional.empty, age=Optional[30]) name:N/A
        log.info("missing field name dto:{}", objectMapper.readValue("{\"id\":\"1\", \"age\":30}", UserDto.class));
        // missing field name dto:UserDto(id=1, name=null, age=Optional[30])
    }

    @PostMapping("wrong")
    public User wrong(@RequestBody User user) {
        user.setNickname(String.format("guest%s", user.getName()));
        return userRepository.save(user);
    }

    @PostMapping("right")
    public UserEntity right(@RequestBody UserDto userDto){
        if (userDto.getId() == null){
            throw new IllegalArgumentException("id 不能为空");
        }

//        UserEntity userEntity = userEntityRepository.findById(userDto.getId())
//                .orElseThrow(() -> new IllegalArgumentException("对象为 null"));

        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDto.getId());

        if (userDto.getName() != null){
            userEntity.setName(userDto.getName().orElse(""));
        }

        userEntity.setNickname("guest" + userEntity.getName());

        if (userDto.getAge() != null){
            userEntity.setAge(userDto.getAge().orElseThrow(()->new IllegalArgumentException("年龄不能为null")));
        }

        return userEntityRepository.save(userEntity);
    }

}