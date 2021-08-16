package com.xl.base;

import com.xl.msjd.msjd1713_Trie;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Trie
 * @Author : Xulian
 * @Date : 2020/10/29 15:42
 */
//倒序版本，甜姨的代码
public class Trie {
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
    class TrieNode {
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
        public TrieNode() {}
    }
}
