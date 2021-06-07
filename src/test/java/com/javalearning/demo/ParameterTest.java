package com.javalearning.demo;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.data.util.Pair;

import java.util.List;

/**
 * @author lhh
 * @date 2021/5/13
 */
@RunWith(Parameterized.class)
public class ParameterTest {

    private Pair<String, String> pair;

    @Parameterized.Parameters
    public static List<Pair<String, String>> construct() {
        Pair<String, String> pair1 = Pair.of("Mike", "Chan");
        Pair<String, String> pair2 = Pair.of("Joe", "Liang");
        return Lists.newArrayList(pair1, pair2);
    }

    public ParameterTest(Pair<String, String> pair) {
        this.pair = pair;
    }

    @Test
    public void test() {
        System.out.println(pair);
    }
}
