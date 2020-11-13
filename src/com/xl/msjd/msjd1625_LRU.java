package com.xl.msjd;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName : msjd1602
 * @Author : Xulian
 * @Date : 2020/10/9 10:44
 */
public class msjd1625_LRU {
    public class LRUCache{
        int capacity;
        Map<Integer, Integer> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new LinkedHashMap<>();
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            // 先删除旧的位置，再放入新位置
            Integer value = map.remove(key);
            map.put(key, value);
            return value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                map.remove(key);
                map.put(key, value);
                return;
            }
            map.put(key, value);
            // 超出capacity，删除最久没用的,利用迭代器删除第一个
            if (map.size() > capacity) {
                map.remove(map.entrySet().iterator().next().getKey());
            }
        }
    }


}
