package com.javalearning.demo.test.util;


import com.javalearning.demo.test.containers.MapEntry;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SimpleHashMap<K,V> {

    private static final int SIZE = 997;
    @SuppressWarnings(value = "unchecked")
    private LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    public V put(K key, V val){
        V oldVal = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        boolean flag = false;
        if (buckets[index] != null){
            LinkedList<MapEntry<K, V>> bucket = buckets[index];
            for (MapEntry<K, V> kvMapEntry : bucket) {
                if (key.equals(kvMapEntry.getKey())){
                    flag = true;
                    oldVal = kvMapEntry.setValue(val);
                    break;
                }
            }
        }
        if (flag){
            LinkedList<MapEntry<K, V>> mapEntries = new LinkedList<>();
            mapEntries.add(new MapEntry<>(key, val));
            buckets[index] = mapEntries;
        }
        return oldVal;
    }

    public V get(K key){
        int index = Math.abs(key.hashCode());
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        for (MapEntry<K, V> kvMapEntry : bucket) {
            if (kvMapEntry.getKey().equals(key)){
                return kvMapEntry.getValue();
            }
        }
        return null;
    }

    public Set<MapEntry<K,V>> entrySet(){
        Set<MapEntry<K,V>> resultSet = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) continue;
            for (MapEntry<K, V> entry : bucket) {
                resultSet.add(entry);
            }
        }
        return resultSet;
    }
}
