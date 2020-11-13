package com.xl.msjd;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : msjd1002
 * @Author : Xulian
 * @Date : 2020/10/4 16:17
 */
public class msjd1002 {
    public List<List<String>> groupAnagrams(String[] strs) {
        String[] newStrs = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            char[] cs = strs[i].toCharArray();
            Arrays.sort(cs);
            newStrs[i] = Arrays.toString(cs) + ":" + i;
        }
        Arrays.sort(newStrs);
        List<List<String>> lists = new LinkedList<>();
        int[] visited = new int[strs.length];
        for (int i = 0; i < newStrs.length; i++) {
            if (visited[i] == 1) continue;
            List<String> list = new LinkedList<>();
            String[] s = newStrs[i].split(":");
            for (int j = i; j < newStrs.length; j++) {
                String[] s1 = newStrs[j].split(":");
                if (s1[0].equals(s[0])) {
                    visited[j] = 1;
                    list.add(strs[Integer.parseInt(s1[1])]);
                } else {
                    i = j - 1;
                    break;
                }
            }

            lists.add(new LinkedList<>(list));
        }
        return lists;
    }
    //这个很好 主要使用的方法：
    //①map.containsKey②list.get(n++)③list.add(new ArrayList<>())
//    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<String, Integer> map = new HashMap<>();
//        List<List<String>> list = new ArrayList<>();
//        int n = 0;
//        for (String s : strs) {
//            char[] c = s.toCharArray();
//            Arrays.sort(c);
//            String str = String.valueOf(c);
//            if (map.containsKey(str)) list.get(map.get(str)).add(s);
//            else {
//                list.add(new ArrayList<>());
//                list.get(n++).add(s);
//                map.put(str, n-1);
//            }
//        }
//        return list;
//    }
//
//    作者：hua-yang
//    链接：https://leetcode-cn.com/problems/group-anagrams-lcci/solution/javayong-shi-bai-fen-bai-by-hua-yang/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static void main(String[] args) {
        new msjd1002().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
