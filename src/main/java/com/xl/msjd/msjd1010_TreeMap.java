package com.xl.msjd;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName : msjd1005
 * @Author : Xulian
 * @Date : 2020/10/4 18:43
 */
public class msjd1010_TreeMap {
    //TreeMap
    public class StreamRank {

        private TreeMap<Integer, Integer> data;

        public StreamRank() {
            data = new TreeMap<>();
        }

        public void track(int x) {
            data.compute(x, (k, v) -> v == null ? 1 : v + 1);
        }

        public int getRankOfNumber(int x) {
            if (data.isEmpty() || data.firstKey() > x) {
                return 0;
            }

            int sum = 0;
            // 严小于等于x的个数之和
            for (Map.Entry<Integer, Integer> entry : data.headMap(x, true).entrySet()) {
                sum += entry.getValue();
            }
            return sum;
        }
    }

//    class StreamRank {
//        List<Integer> list;
//        public StreamRank() {
//            list = new LinkedList<>();
//        }
//
//        public void track(int x) {
//            if(list.size() == 0){
//                list.add(x);
//                return;
//            }
//            for (int i = 0; i < list.size(); i++) {
//                if(list.get(i) >= x){
//                    list.add(i,x);
//                    return;
//                }
//            }
//            list.add(x);
//        }
//
//        public int getRankOfNumber(int x) {
//            int res = 0;
//            for (int i = 0; i < list.size(); i++) {
//                if(list.get(i) <= x){
//                    res++;
//                }else{
//                    break;
//                }
//            }
//            return res;
//        }
//    }
}
