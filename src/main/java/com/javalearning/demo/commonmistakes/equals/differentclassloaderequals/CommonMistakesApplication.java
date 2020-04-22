package com.javalearning.demo.commonmistakes.equals.differentclassloaderequals;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class CommonMistakesApplication {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream inputStream = getClass().getResourceAsStream(fileName);
                if (inputStream == null){
                    return super.loadClass(name);
                }
                try {
                    byte[] b = new byte[inputStream.available()];
                    inputStream.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException();
                }
            }
        };

        Object point1 = classLoader.loadClass(Point.class.getName()).newInstance();
        Point point2 = new Point();
        Point point3 = (Point) ClassLoader.getSystemClassLoader().loadClass(Point.class.getName()).newInstance();

        log.info("point1 instanceOf Point ? {}", point1 instanceof Point); //false
        log.info("point1 == point2 ? {}", point1.getClass() == point2.getClass()); //false
        log.info("point1 equals point2 ? {}", point1.equals(point2)); //false


        log.info("point3 instanceOf Point ? {}", point3 instanceof Point); //true
        log.info("point3 == point2 ? {}", point3.getClass() == point2.getClass()); //true
        log.info("point3 equals point2 ? {}", point3.equals(point2)); //true
    }
}

