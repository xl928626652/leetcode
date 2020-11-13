package com.xl.msjd;

/**
 * @ClassName : msjd1602
 * @Author : Xulian
 * @Date : 2020/10/9 10:44
 */
public class msjd1618_Mark {
    public boolean patternMatching(String pattern, String value) {
        if (pattern == null || pattern.length() == 0) {
            return value.length() == 0;
        }
        String first = "", second = "";
        for (int i = 0; i <= value.length(); i++) {
            first = value.substring(0, i);
            second = findSecond(value, pattern, first);
            if (first.equals(second)) {
                continue;
            }
            if (value.equals(construct(pattern, first, second))) {
                return true;
            }
        }
        return false;
    }

    private String construct(String pattern, String first, String second) {
        String ans = "";
        for (char c : pattern.toCharArray()) {
            if (c == pattern.charAt(0)) {
                ans += first;
            } else {
                ans += second == null ? "" : second;
            }
        }
        return ans;
    }

    private String findSecond(String value, String pattern, String first) {
        int fn = 0, sn = 0;
        for (char c : pattern.toCharArray()) {
            if (pattern.charAt(0) == c) {
                fn++;
            } else {
                sn++;
            }
        }
        if (sn == 0 || value.length() < (fn * first.length())) {
            return null;
        }
        int len = (value.length() - (fn * first.length())) / sn;
        for (int i = 1; i < pattern.length(); i++) {
            if (pattern.charAt(i) != pattern.charAt(0)) {
                int offset = i * first.length();
                return value.substring(offset, offset + len);
            }
        }
        return null;
    }

//    作者：meifans
//    链接：https://leetcode-cn.com/problems/pattern-matching-lcci/solution/java-fei-hui-su-jian-ji-by-meifans/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
