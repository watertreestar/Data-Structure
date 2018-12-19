import java.util.TreeMap;

/**
 * @ClassName Trie
 * @Author ranger
 * @Date 2018/12/19
 **/
public class Trie {
    public class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    /**
     * 获得单词数量
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 循环添加
     *
     * @param word
     */
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }

        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 递归操作添加
     *
     * @param word
     */
    public void addWithRecursive(String word) {
        if (word == null || word.length() == 0) return;
        addWithRecursive(root, word, 0);
    }

    private void addWithRecursive(Node node, String word, int index) {

        if (node.next.get(word.charAt(index)) == null) {
            node.next.put(word.charAt(index), new Node());
        }
        addWithRecursive(node.next.get(word.charAt(index)), word, index + 1);
        if (index == word.length()) {
            node.isWord = true;
            return;
        }
    }

    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }

            cur = cur.next.get(c);
        }
        return true;
    }
}
