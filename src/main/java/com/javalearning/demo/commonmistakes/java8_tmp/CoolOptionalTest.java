package com.javalearning.demo.commonmistakes.java8_tmp;

import org.junit.Test;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.OptionalDouble;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class CoolOptionalTest {

    @Test
    public void test(){

        assertThat(Optional.of(1).get(), is(1));

        assertThat(Optional.ofNullable(null).orElse("A"), is("A"));

        assertFalse(OptionalDouble.empty().isPresent());

        assertThat(Optional.of(1).map(Math::incrementExact).get(), is(1));

        assertThat(Optional.of(1).filter(integer -> integer % 2 == 0).orElse(null), is(nullValue()));

        Optional.empty().orElseThrow(IllegalArgumentException::new);
    }
}
