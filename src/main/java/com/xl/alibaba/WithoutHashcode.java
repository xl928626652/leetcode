package com.xl.alibaba;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName : WithoutHashcode
 * @Author : Xulian
 * @Date : 2021/3/31 16:03
 */
class Key {
    private Integer id;

    public Key(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return Objects.equals(id, key.id);
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return "Key{" +
                "id=" + id +
                '}';
    }
}

public class WithoutHashcode {
    public static void main(String[] args) {
        Key key1 = new Key(1);
        Key key2 = new Key(1);
        Map<Key, Integer> map = new HashMap<>();
        map.put(key1, 1);
        map.put(key2, 2);
        System.out.println(map);
    }
}
