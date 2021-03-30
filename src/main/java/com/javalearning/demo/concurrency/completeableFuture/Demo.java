package com.javalearning.demo.concurrency.completeableFuture;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author lhh
 * @date 2021/3/30
 */
public class Demo {

    public static void main(String[] args) {
        List<Integer> ids = Lists.newArrayList(1,2,3,4,5,6,7,8);
        List<Men> biz = biz(ids);
        System.out.println(biz);
    }

    public static List<Men> biz(List<Integer> ids){

        if (CollectionUtils.isEmpty(ids)){
            return Lists.newArrayList();
        }

        if (ids.size() < 4){
            return getByIds(ids);
        }

        List<Supplier<List<Men>>> suppliers = new ArrayList<>();

        int start = 0;
        int step = 4;
        int end = start + step;
        while (end <= ids.size()
                && start < end){ // 终止条件
            List<Integer> subIds = ids.subList(start, end);
            suppliers.add(() -> getByIds(subIds));

            start = end;
            end += step;

            // 最后一次差值处理
            if (end > ids.size()){
                end = ids.size();
            }
        }

        return CFUtils.query(suppliers, 3);
    }

    private static List<Men> getByIds(List<Integer> ids) {
        return Lists.newArrayList();
    }
}
