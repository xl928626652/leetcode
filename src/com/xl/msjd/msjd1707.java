package com.xl.msjd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : msjd1701
 * @Author : Xulian
 * @Date : 2020/10/22 10:49
 */
public class msjd1707 {
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, String> unionMap = new HashMap<>();
        for (String name : names) {
            int a = name.indexOf('(');
            int b = name.indexOf(')');
            int value = Integer.parseInt(name.substring(a + 1, b));
            String key = name.substring(0, a);
            map.put(key, value);
        }

        for (String pair : synonyms) {
            int idx = pair.indexOf(',');
            String name1 = pair.substring(1, idx);
            String name2 = pair.substring(idx + 1, pair.length() - 1);
            while (unionMap.containsKey(name1)) {   //找name1祖宗
                name1 = unionMap.get(name1);
            }
            while (unionMap.containsKey(name2)) {   //找name2祖宗
                name2 = unionMap.get(name2);
            }
            //这是核心的构造父-子树的代码，每次都把字典序小的作为根，
            if (!name1.equals(name2)) {
                int number = map.getOrDefault(name1, 0) + map.getOrDefault(name2, 0);
                String trulyName = name1.compareTo(name2) < 0 ? name1 : name2;
                String nickName = name1.compareTo(name2) < 0 ? name2 : name1;
                unionMap.put(nickName, trulyName);      //小名作为大名的分支，即大名是小名的祖宗
                map.remove(nickName);       //更新一下数据
                map.put(trulyName, number);
            }
        }
        String[] res = new String[map.size()];
        int index = 0;
        for (String s : map.keySet()){
            StringBuilder stringBuilder = new StringBuilder(s);
            stringBuilder.append('(');
            stringBuilder.append(map.get(s));
            stringBuilder.append(')');
            res[index++]=stringBuilder.toString();
        }
        return res;
    }
}
