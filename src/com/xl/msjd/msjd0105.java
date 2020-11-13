package com.xl.msjd;

import java.util.HashMap;
import java.util.Map;

public class msjd0105 {
    public boolean oneEditAway(String first, String second) {
        int lenDiff = first.length() - second.length();
        if (Math.abs(lenDiff) > 1) return false;

        if (lenDiff == 0) {
            int count = 1;
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) count--;
            }
            return count >= 0;
        }
        if (Math.abs(lenDiff) == 1) {
            int count = 1;
            int a = 0, b = 0;
            while (a < first.length() && b < second.length()) {
                if (first.charAt(a) != second.charAt(b)) {
                    if (first.length() > second.length()) {
                        a++;
                        count--;
                    } else {
                        b++;
                        count--;
                    }
                }else{
                    a++;
                    b++;
                }
            }
            return count >= 0;
        }
        return true;
    }
}
