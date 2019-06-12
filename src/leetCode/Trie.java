package leetCode;

import java.util.*;

// https://leetcode.com/problems/implement-trie-prefix-tree/
public class Trie {
    public static class TrieNode {
        char ch;
        boolean isLeaf;
        Map<Character, TrieNode> children;

        TrieNode(char ch, boolean isLeaf) {
            this.ch = ch;
            this.isLeaf = isLeaf;
            this.children = new HashMap<>();
        }
    }

    static TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode('*', false);
    }

    /** Inserts a word into the trie. */
    public static void insert(String word) {
        TrieNode parent = root;
        for (int i = 0; i< word.length(); i++) {
            TrieNode current;
            char ch = word.charAt(i);
            if (parent.children.containsKey(ch)){
                current = parent.children.get(ch);
            } else {
                current = new TrieNode(ch, false);
                parent.children.put(ch, current);
            }
            parent = current;
            if (i == word.length() - 1)
                current.isLeaf = true;
        }

    }

    /** Returns if the word is in the trie. */
    public static boolean search(String word) {
        TrieNode result = isPrefix(word);
        return (result != null && result.isLeaf);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public static boolean startsWith(String prefix) {
        TrieNode result = isPrefix(prefix);
        return result != null;
    }

    public static TrieNode isPrefix(String word) {
        TrieNode result = root;
        for (char ch: word.toCharArray()) {
            TrieNode res = result.children.getOrDefault(ch, null);
            if (res == null) return null;
            result = res;
        }
        return result;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
//        trie.insert("app");
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));

//        trie.insert("beer");
//        trie.insert("add");
//        trie.insert("jam");
//        trie.insert("rental");
//
//        System.out.println(trie.search("apps"));
//        System.out.println(trie.search("app"));
//        System.out.println(trie.search("ad"));
    }
}
