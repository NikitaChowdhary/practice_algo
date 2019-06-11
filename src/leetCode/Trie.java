package leetCode;

import java.util.*;

// https://leetcode.com/problems/implement-trie-prefix-tree/
public class Trie {

    public class TrieNode {
        char ch;
        boolean isLeaf;
        Map<Character, TrieNode> children;

        TrieNode(char ch, boolean isLeaf) {
            this.ch = ch;
            this.isLeaf = isLeaf;
            this.children = new HashMap<>();
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode('*', false);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode parent = root;
        for (int i = 0; i< word.length(); i++) {

            char ch = word.charAt(i);
            if (root.children.containsKey(ch)){
                parent = root.children.get(ch);
            } else {
                boolean isLeaf = false;
                if (i == word.length() - 1)
                    isLeaf = true;
                TrieNode current = new TrieNode(ch, isLeaf);
                parent.children.put(ch, current);
                parent = current;
            }
        }

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode result = isPrefix(word);
        return (result != null && result.isLeaf);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode result = isPrefix(prefix);
        return (result != null && !result.isLeaf);
    }

    public TrieNode isPrefix(String word) {
        TrieNode result = root;
        for (char ch: word.toCharArray()) {
            TrieNode res = result.children.getOrDefault(ch, null);
            if (res == null) return null;
            result = res;
        }
        return result;
    }
}
