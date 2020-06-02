package com.javalearning.demo.commonmistakes.oom.usernameautocomplete;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Service
@Slf4j
public class UsernameAutoCompleteService {

    private ConcurrentHashMap<String, List<UserDTO>> complexInIndex = new ConcurrentHashMap<>();

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void wrong(){ //UserDTO 实例数量有50000个，占用堆大小600M
        List<UserEntity> userEntityList
                = LongStream.rangeClosed(1, 10000).mapToObj(i -> new UserEntity(i, randomName())).collect(Collectors.toList());
        userRepository.saveAll(userEntityList);

        userRepository.findAll().stream().map(UserEntity::getName).forEach(userName -> {
            int length = userName.length();
            for (int i1 = 1; i1 < length; i1++) {
                String key = userName.substring(0, i1);
                complexInIndex.computeIfAbsent(key, s -> new ArrayList<UserDTO>()).add(new UserDTO(userName));
            }
        });

        log.info("key count: {}, value count: {}",
                complexInIndex.size(),
                complexInIndex.entrySet().stream().map(item -> item.getValue().size()).reduce(0 ,Integer::sum));

    }

//    @PostConstruct
    public void right(){ //UserDTO 实例数量只有9950个，占用堆大小不足200M，同一个对象，在内存中可能有多份

        userRepository.saveAll(LongStream.rangeClosed(1, 10000)
                .mapToObj(i -> new UserEntity(i, randomName()))
                .collect(Collectors.toList()));

        HashSet<UserDTO> cache
                = userRepository.findAll()
                .stream()
                .map(item -> new UserDTO(item.getName()))
                .collect(Collectors.toCollection(HashSet::new));

        cache.stream().forEach(userDTO -> {
            String userName = userDTO.getName();
            int length = userName.length();
            for (int i = 0; i < length; i++) {
                String key = userName.substring(0, i);
                complexInIndex.computeIfAbsent(key, s -> new ArrayList<UserDTO>()).add(userDTO);
            }
        });

        log.info("key count: {}, value count: {}",
                complexInIndex.size(),
                complexInIndex.entrySet().stream().map(item -> item.getValue().size()).reduce(0, Integer::sum));
    }

    /**
     * 随机生成长度为6的英文名称，字母包含 abcdefghij
     *
     * @return
     */
    private String randomName() {
        return String.valueOf(Character.toChars(ThreadLocalRandom.current().nextInt(10) + 'a')).toUpperCase() +
                String.valueOf(Character.toChars(ThreadLocalRandom.current().nextInt(10) + 'a')) +
                String.valueOf(Character.toChars(ThreadLocalRandom.current().nextInt(10) + 'a')) +
                String.valueOf(Character.toChars(ThreadLocalRandom.current().nextInt(10) + 'a')) +
                String.valueOf(Character.toChars(ThreadLocalRandom.current().nextInt(10) + 'a')) +
                String.valueOf(Character.toChars(ThreadLocalRandom.current().nextInt(10) + 'a'));
    }

}
