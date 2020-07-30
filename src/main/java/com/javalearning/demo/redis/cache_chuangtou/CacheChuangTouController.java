package com.javalearning.demo.redis.cache_chuangtou;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 缓存穿透：从缓存中查出了空字符串，认为是缓存中没有数据回源查询，其实相当于每次都回源
 *    1. 对于不存在的数据，同样设置一个特殊的Value到缓存中，
 *       比如当数据库中查出的用户信息为空的时候，设置NODATA这样具有特殊含义的字符串到缓存中。
 *    2. 布隆过滤器
 */
@Slf4j
@RequestMapping("cache_chaungtou")
@RestController
public class CacheChuangTouController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/right")
    public String right(@RequestParam Integer id){
        String data = stringRedisTemplate.opsForValue().get("hot-spot");
        if (StringUtils.isEmpty(data)){
            data = getFromDB(id);
            if (StringUtils.isEmpty(data)){
                stringRedisTemplate.opsForValue().set("hot-spot", "NODATA");
            }else {
                stringRedisTemplate.opsForValue().set("hot-spot", data);
            }
        }
        return data;
    }

    private String getFromDB(Integer id) {
        if (id > 1000){
            return "";
        }
        return "data" + id;
    }
}
