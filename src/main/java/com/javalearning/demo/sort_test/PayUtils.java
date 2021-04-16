package com.javalearning.demo.sort_test;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.List;

/**
 * @author lhh
 * @date 2021/4/8
 */
public class PayUtils {

    /**
     * 权重高的排在前面
     * @param rawList
     * @return
     */
    public static List<OrderPayRecord> sortByPayment(List<OrderPayRecord> rawList){
        if (CollectionUtils.isEmpty(rawList)) {
            return Lists.newArrayList();
        }

        List<OrderPayRecord> resList = Lists.newLinkedList(rawList);
        resList.sort(Comparator.comparingInt(v -> {
            PaySort paySort = PaySort.getByName(v.getPayment());
            if (paySort != null) {
                return -(paySort.getWeight());
            }

            return 0;
        }));

        return resList;
    }

    enum PaySort {
        balance(5),
        shopBalance(4),
        wxpay(3),
        alipay(3),
        ;

        static PaySort getByName(String name){
            for (PaySort value : PaySort.values()) {
                if (value.name().equals(name)) {
                    return value;
                }
            }

            return null;
        }

        public Integer getWeight() {
            return weight;
        }

        private Integer weight;
        PaySort(Integer weight) {
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        List<OrderPayRecord> rawList = Lists.newArrayList();
        rawList.add(new OrderPayRecord("wxpay"));
        rawList.add(new OrderPayRecord("balance"));
        rawList.add(new OrderPayRecord("alipay"));
        rawList.add(new OrderPayRecord("shopBalance"));
        List<OrderPayRecord> sortedList = PayUtils.sortByPayment(rawList);
        System.out.println(sortedList);
    }
}
