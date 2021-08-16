package com.xl.msjd;

import java.util.*;

/**
 * @ClassName : msjd1701
 * @Author : Xulian
 * @Date : 2020/10/22 10:49
 */
public class msjd1726 {
    //倒排索引
    public List<String> computeSimilarities(int[][] docs) {
        List<String> ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[][] help = new int[docs.length][docs.length];
        for (int i = 0; i < docs.length; i++) {
            for (int j = 0; j < docs[i].length; j++) {
                List<Integer> list = map.get(docs[i][j]);
                if (list == null) {
                    list = new ArrayList<>();
                    map.put(docs[i][j], list);
                } else {
                    for (Integer k : list) {
                        help[i][k]++;
                    }
                }
                list.add(i);
            }

            for (int k = 0; k < i; k++) {
                if (help[i][k] > 0) {
                    ans.add(k + "," + i + ": " + String.format("%.4f", (double) help[i][k] / (docs[i].length + docs[k].length - help[i][k])));
                }
            }
        }
        return ans;
    }
//    public List<String> computeSimilarities(int[][] docs) {
//        List<String> list = new ArrayList<>();
//        Map<Integer, Set<Integer>> map = new HashMap<>();
//        for (int i = 0; i < docs.length; i++) {
//            Set<Integer> set = new HashSet<>();
//            for (int element : docs[i]){
//                set.add(element);
//            }
//            map.put(i, set);
//        }
//        for (int i = 0; i < docs.length - 1; i++) {
//            for (int j = i + 1; j < docs.length; j++) {
//                Set<Integer> setI = map.get(i);
//                Set<Integer> setJ = map.get(j);
//                int intersection = 0;
//                for (int element : setJ){
//                    if (setI.contains(element)){
//                        intersection++;
//                    }
//                }
//                int union = setI.size() + setJ.size() - intersection;
//                if (intersection != 0 ){
//                    StringBuilder stringBuilder = new StringBuilder();
//                    stringBuilder.append(i);
//                    stringBuilder.append(",");
//                    stringBuilder.append(j);
//                    stringBuilder.append(": ");
//                    double d = (double) intersection / union;
//                    stringBuilder.append(String.format("%.4f", d));
//                    list.add(stringBuilder.toString());
//                }
//            }
//        }
//        return list;
//    }
}
