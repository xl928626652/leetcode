package com.xl.msjd;

import java.util.*;

/**
 * @ClassName : msjd1701
 * @Author : Xulian
 * @Date : 2020/10/22 10:49
 */
public class msjd1713_Trie {
//    public int respace(String[] dictionary, String sentence) {
//        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
//        int[] dp = new int[sentence.length() + 1];
//        for (int i = 1; i < dp.length; i++) {
//            dp[i] = dp[i - 1] + 1;
//            for (int j = 0; j < i; j++) {
//                if (set.contains(sentence.substring(j, i))) {
//                    dp[i] = Math.min(dp[i], dp[j]);
//                }
//            }
//        }
//        return dp[sentence.length()];
//    }
class Solution {
    public int respace(String[] dictionary, String sentence) {
        // 构建字典树
        Trie trie = new Trie();
        for (String word: dictionary) {
            trie.insert(word);
        }
        // 状态转移，dp[i] 表示字符串的前 i 个字符的最少未匹配数
        int n = sentence.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int idx: trie.search(sentence, i - 1)) {
                dp[i] = Math.min(dp[i], dp[idx]);
            }
        }
        return dp[n];
    }
}

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // 将单词倒序插入字典树
        public void insert(String word) {
            TrieNode cur = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                int c = word.charAt(i) - 'a';
                if (cur.children[c] == null) {
                    cur.children[c] = new TrieNode();
                }
                cur = cur.children[c];
            }
            cur.isWord = true;
        }

        // 找到 sentence 中以 endPos 为结尾的单词，返回这些单词的开头下标。
        public List<Integer> search(String sentence, int endPos) {
            List<Integer> indices = new ArrayList<>();
            TrieNode cur = root;
            for (int i = endPos; i >= 0; i--) {
                int c = sentence.charAt(i) - 'a';
                if (cur.children[c] == null) {
                    break;
                }
                cur = cur.children[c];
                if (cur.isWord) {
                    indices.add(i);
                }
            }
            return indices;
        }
    }

    static class TrieNode {
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
        public TrieNode() {}
    }


//    作者：sweetiee
//    链接：https://leetcode-cn.com/problems/re-space-lcci/solution/jian-dan-dp-trieshu-bi-xu-miao-dong-by-sweetiee/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
