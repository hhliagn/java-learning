package com.javalearning.demo.commonmistakes.equals.equalitymethod;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@RestController
@Slf4j
@RequestMapping("equalitymethod")
public class EqualityMethodController {

    @GetMapping("/wrong")
    public void wrong(){
        Point a = new Point(1, 2, "a");
        Point b = new Point(1, 2, "b");
        Point c = new Point(1, 2, "a");
        log.info("a equals b {}", a.equals(b));
        log.info("a equals c {}", a.equals(c));
    }

    @GetMapping("/wrong2")
    public void wrong2(){
        PointWrong a = new PointWrong(1,2,"a");
        PointWrong b = new PointWrong(1,2,"a");

        log.info("a equals b {}", a.equals(b));

        Set<PointWrong> set = new HashSet<>();
        set.add(a);

        log.info("set contains a {}", set.contains(b));
    }

    @GetMapping("/right")
    public void right(){
        PointRight a = new PointRight(1,2,"a");
        PointRight b = new PointRight(1,2,"a");

        log.info("a equals b {}", a.equals(b));

        Set<PointRight> set = new HashSet<>();
        set.add(a);

        log.info("set contains a {}", set.contains(b));
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
            PointWrong o = (PointWrong) obj;
            return o.x == x && o.y == y;
        }
    }

    @AllArgsConstructor
    class PointRight{
        int x;
        int y;
        String desc;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PointRight that = (PointRight) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
