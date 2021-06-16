package com.javalearning.demo.java8.optional;

import com.javalearning.demo.java8.optional.utils.OptionalUtility;
import org.junit.Test;

import java.util.Optional;
import java.util.Properties;

import static junit.framework.TestCase.assertEquals;

/**
 * @author lhh
 * @date 2021/6/16
 */
public class Demo {

    @Test
    public void test() {

        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");

        assertEquals(5, readDurationV2(props, "a"));
        assertEquals(0, readDurationV2(props, "b"));
        assertEquals(0, readDurationV2(props, "c"));
        assertEquals(0, readDurationV2(props, "d"));

    }


    public int readDurationV1(Properties props, String name) {


        String str = props.getProperty(name);

        if (str != null) {


            try {
                int i = Integer.parseInt(str);

                if (i > 0) {
                    return i;
                }
            } catch (NumberFormatException e) {

            }

        }

        return 0;

    }


    public int readDurationV2(Properties props, String name) {

        return Optional.ofNullable(props.getProperty(name))
                .flatMap(OptionalUtility::stringToInt)
                .filter(i -> i > 0)
                .orElse(0);
    }




}
