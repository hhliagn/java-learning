package com.javalearning.demo.roundrobin;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://blog.csdn.net/claram/article/details/90268868
 * 加权轮询详见上
 */
public class RoundRobin {
    public static class ServerManager {
        public static Map<String, Integer> serverMap = new TreeMap<>();

        static {
            serverMap.put("192.168.1.1", 1);
            serverMap.put("192.168.1.2", 2);
            serverMap.put("192.168.1.3", 3);
            serverMap.put("192.168.1.4", 4);
        }
    }

    //定义索引
    private static AtomicInteger indexAtomic = new AtomicInteger(0);

    public static String getServer() {
        Set<String> serverSet = ServerManager.serverMap.keySet();
        ArrayList<String> serverList = new ArrayList<>(serverSet);

        if (indexAtomic.get() >= serverList.size()) {
            indexAtomic.set(0);
        }
        String server = serverList.get(indexAtomic.getAndIncrement());
        return server;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String server = getServer();
            System.out.println(server);
        }
    }
}


