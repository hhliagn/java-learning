package com.javalearning.demo.bean_copy;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lhh
 * @date 2020/5/20
 */
public class BeanUtils<T> {

    private static ModelMapper modelMapper = new ModelMapper();

    public static void setMatchingStrategy(MatchingStrategy matchingStrategy, boolean matchingRequired) {
        // 参数名全文匹配
        modelMapper.getConfiguration().setMatchingStrategy(matchingStrategy);
        // 参数类型强一致
        modelMapper.getConfiguration().setFullTypeMatchingRequired(matchingRequired);
    }

    public static void resetMatchingStrategy() {
        // 参数名全文匹配
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        // 参数类型强一致
        modelMapper.getConfiguration().setFullTypeMatchingRequired(true);
    }

    // 属性字段是浅拷贝
    // Dog(son=com.javalearning.demo.bean_copy.Son@1e67b872)
    // Wolf(son=com.javalearning.demo.bean_copy.Son@1e67b872)
    public static <T> T copyProperties(Object source, Class<T> targetClass) {
        resetMatchingStrategy();
        if (source == null)
            return null;
        return modelMapper.map(source, targetClass);
    }

    /***
     * 
     * @param <T>
     * @param source
     * @param targetClass
     * @param matchingStrategy
     *            参数名匹配规则
     * @param matchingRequired
     *            参数类型匹配规则
     * @return
     */
    public static <T> T copyProperties(Object source, Class<T> targetClass, MatchingStrategy matchingStrategy,
        boolean matchingRequired) {
        setMatchingStrategy(matchingStrategy, matchingRequired);
        if (source == null)
            return null;
        return modelMapper.map(source, targetClass);
    }

    public static <T> List<T> copyListProperties(List source, Class<T> targetClass) {
        List<T> res = new ArrayList<>();
        if (CollectionUtils.isEmpty(source)) {
            return res;
        }
        source.forEach(o -> res.add(copyProperties(o, targetClass)));
        return res;
    }

    /***
     * 
     * @param <T>
     * @param source
     * @param targetClass
     * @param matchingStrategy
     *            参数名匹配规则
     * @param matchingRequired
     *            参数类型匹配规则
     * @return
     */
    public static <T> List<T> copyListProperties(List source, Class<T> targetClass, MatchingStrategy matchingStrategy,
        boolean matchingRequired) {
        List<T> res = new ArrayList<>();
        if (CollectionUtils.isEmpty(source)) {
            return res;
        }
        source.forEach(o -> res.add(copyProperties(o, targetClass, matchingStrategy, matchingRequired)));
        return res;
    }

    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        wolf.setSon(new Son());

        Dog dog = BeanUtils.copyProperties(wolf, Dog.class);

        System.out.println(dog);
        System.out.println(wolf);
    }
}
