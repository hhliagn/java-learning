package com.javalearning.demo.commonmistakes.nullvalue.dbnull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery = true, value = "select sum(score) from `user`")
    Long wrong1();

    @Query(nativeQuery = true, value = "select count(score) from `user`")
    Long wrong2();

    @Query(nativeQuery = true, value = "select * from `user` where score = null")
    List<User> wrong3();

    @Query(nativeQuery = true, value = "SELECT IFNULL(SUM(score),0) FROM `user`")
    Long right1();

    @Query(nativeQuery = true, value = "select count(*) from `user`")
    Long right2();

    @Query(nativeQuery = true, value = "select * from `user` where score is null")
    List<User> right3();

}
