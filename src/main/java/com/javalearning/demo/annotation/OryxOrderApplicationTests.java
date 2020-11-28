package com.javalearning.demo.annotation;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Date;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class OryxOrderApplicationTests {

    @Test
    public void testMyLabel(){
        MyClass myClass = new MyClass();
        myClass.setName("梁恒辉");
        myClass.setBirthday(new Date());

        String format = MySimpleFormatUtil.format(myClass, true);
        System.out.println("User Info:\n" + format);
    }
}
