package com.xl.msjd;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : msjd1701
 * @Author : Xulian
 * @Date : 2020/10/22 10:49
 */
public class msjd1711 {
    public int findClosest(String[] words, String word1, String word2) {
        List<Integer> listOfWord1 = new ArrayList<>();
        List<Integer> listOfWord2 = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                listOfWord1.add(i);
            }
            if (words[i].equals(word2)) {
                listOfWord2.add(i);
            }
        }
        int indexOfList1 = 0, indexOfList2 = 0;
        int min = words.length - 2;
        while (indexOfList1 < listOfWord1.size() && indexOfList2 < listOfWord2.size()) {
            int index1 = listOfWord1.get(indexOfList1), index2 = listOfWord2.get(indexOfList2);
            if (index1 < index2) {
                min = Math.min(min, index2 - index1);
                indexOfList1++;
            } else {
                min = Math.min(min, index1 - index2);
                indexOfList2++;
            }

        }
        return min;
    }
}
