package com.xl.lc;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName : lc146
 * @Author : Xulian
 * @Date : 2021/2/27 9:38
 */
public class lc146 {
    static class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

    public static void main(String[] args) {
//        LRUCache lruCache = new LRUCache(10);
//        lruCache.put(1, 1);
//        System.out.println("begin");
//        iterator(lruCache);
//        System.out.println("end");
//        System.out.println();
//        lruCache.put(2, 1);
//        System.out.println("begin");
//        iterator(lruCache);
//        System.out.println("end");
//        System.out.println();
//        lruCache.get(1);
//        System.out.println("begin");
//        iterator(lruCache);
//        System.out.println("end");
//        System.out.println();

//        testPlusPlus();

        String s = "asdfasdfsadfas";
        String[] strings = s.split("t");
        System.out.println(Arrays.toString(strings));
    }

    private static void testPlusPlus() {
        int c = 0;
//        for (int i = 0; i < 100; i++) {
//            c = c++;
//        }
        c = ++c;
        System.out.println(c);
    }

    private static void iterator(LRUCache lruCache) {
        for (Map.Entry<Integer, Integer> entry : lruCache.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

}
