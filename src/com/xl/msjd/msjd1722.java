package com.xl.msjd;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName : msjd1701
 * @Author : Xulian
 * @Date : 2020/10/22 10:49
 */
public class msjd1722 {
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> ans = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return ans;
        }
        Set<String> used = new HashSet<>();
        ans.add(beginWord);
        boolean b = backTrack(beginWord, endWord, wordList, ans, used);
        return b ? ans : new ArrayList<>();
    }

    private boolean backTrack(String beginWord, String endWord, List<String> wordList, List<String> ans, Set<String> used) {
        if (beginWord.equals(endWord)) {
            return true;
        }
        for (String word : wordList) {
            if (oneCharDiff(beginWord, word) && !used.contains(word)) {
                ans.add(word);
                used.add(word);
                if (backTrack(word, endWord, wordList, ans, used)) {
                    return true;
                } else {
                    //如果本次递归没能得到结果,那么word也不应该再用了
                    //used.remove(word);
                    ans.remove(ans.size() - 1);
                }
            }
        }
        return false;
    }

    private boolean oneCharDiff(String word1, String word2) {
        int count = 0;
        if (word1.length() != word2.length()) {
            return false;
        }
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
                if (count >= 2) {
                    return false;
                }
            }
        }
        return count == 1;
    }

// 作者：momentumxx
// 链接：https://leetcode-cn.com/problems/word-transformer-lcci/solution/zui-rong-yi-li-jie-de-hui-su-dai-ma-by-momentumxx/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
