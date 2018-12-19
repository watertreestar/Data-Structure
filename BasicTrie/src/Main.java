/**
 * @ClassName Main
 * @Author ranger
 * @Date 2018/12/19
 **/
public class Main {
    public static void main(String[] args) {
        String word = "hello";
        Trie trie = new Trie();
        trie.add(word);
        trie.add("hand");
    }
}
