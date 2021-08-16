package com.xl.msjd;

import java.util.HashMap;
import java.util.Map;

public class msjd0104 {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int odd = 0;
        for (Character c : map.keySet()) {
            if (map.get(c) % 2 != 0)
                odd++;
        }
        if (s.length() % 2 == 0) {
            return odd == 0;
        } else {
            return odd == 1;
        }
    }
}
