package com.javalearning.demo.commonmistakes.equals.equalitymethod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Objects;

@RestController
@Slf4j
@RequestMapping("equalitymethod")
public class EqualityMethodController {

    @GetMapping("wrong")
    public void wrong(){
        Point a = new Point(1, 2, "a");
        Point b = new Point(1, 2, "b");
        Point c = new Point(1, 2, "a");
        log.info("a equals b ? {}", a.equals(b));
        log.info("a equals c ? {}", a.equals(c));
    }


    @GetMapping("wrong2")
    public void wrong2(){
        PointWrong a = new PointWrong(1,2,"a");
        try {
            log.info("a equals null, {}", a.equals(null));
        } catch (Exception e) {
            log.error(e.toString());
        }

        Object o = new Object();
        try {
            log.info("a equals an object, {}", a.equals(o));
        } catch (Exception e) {
            log.error(e.toString());
        }

        PointWrong b = new PointWrong(1,2,"b");
        log.info("a equals b, {}", a.equals(b));


        HashSet<PointWrong> pointWrongs = new HashSet<>();
        pointWrongs.add(a);
        log.info("pointWrongs contains b? {}", pointWrongs.contains(b));

    }

    @GetMapping("right")
    public void right(){
        PointRight a = new PointRight(1,2,"a");
        try {
            log.info("a equals null, {}", a.equals(null));
        } catch (Exception e) {
            log.error(e.toString());
        }

        Object o = new Object();
        try {
            log.info("a equals an object, {}", a.equals(o));
        } catch (Exception e) {
            log.error(e.toString());
        }

        PointRight b = new PointRight(1,2,"b");
        log.info("a equals b, {}", a.equals(b));


        HashSet<PointRight> pointWrongs = new HashSet<>();
        pointWrongs.add(a);
        log.info("pointWrongs contains b? {}", pointWrongs.contains(b));

    }


    @AllArgsConstructor
    class Point{
        int x;
        int y;
        String desc;
    }

    @AllArgsConstructor
    class PointWrong{
        int x;
        int y;
        String desc;

        @Override
        public boolean equals(Object obj) {
            PointWrong that = (PointWrong) obj;
            return x == that.x && y == that.y;
        }
    }

    @AllArgsConstructor
    class PointRight{
        int x;
        int y;
        String desc;

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (obj.getClass() != this.getClass()) return false;
            PointRight that = (PointRight) obj;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x,y);
        }
    }
}
