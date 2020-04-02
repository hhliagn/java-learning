//package com.javalearning.demo.complex_pojo.service;
//
//import com.javalearning.demo.complex_pojo.bean.New;
//import com.javalearning.demo.complex_pojo.bean.News;
//import com.javalearning.demo.complex_pojo.bean.NewsPojo;
//import com.javalearning.demo.complex_pojo.helper.SerializeHelper;
//import com.javalearning.demo.complex_pojo.mapper.NewsMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
//@Service
//public class NewsService {
//
//    @Autowired
//    private NewsMapper newsMapper;
//
//    public void insert() throws IOException {
//        News insert = new News();
//        List<New> news = Arrays.asList(new New("AAA", "we have it", new Date()),
//                new New("BBB", "we don't have it", new Date()),
//                new New("CCC", "we may have it", new Date()));
//
//        NewsPojo news1 = new NewsPojo();
//        news1.addAll(news);
//        news1.setPublicDepartment("wsj");
//
//        byte[] serialize = SerializeHelper.serialize(news1);
//        insert.setData(serialize);
//        insert.setId(4);
//        int i = newsMapper.insertSelective(insert);
//        System.out.println(i);
//    }
//
//    public News get(int id) throws IOException {
//        News result = null;
//
////        result = newsMapper.selectByPrimaryKey(id);
////        if (result != null){
////            byte[] data = result.getData();
////            NewsPojo deserialize = SerializeHelper.deserialize(data, NewsPojo.class);
////            System.out.println(deserialize);
////        }
//
//        return result;
//    }
//
//
//}
