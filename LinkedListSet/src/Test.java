import java.util.ArrayList;
import java.util.BitSet;

/**
 * @ClassName Test
 * @Author ranger
 * @Date 2018/12/15
 * 测试基于链表和二分搜索树的集合时间复杂度
 **/
public class Test {
    public static double testBST(){

        long start = System.nanoTime();
        System.out.println("pride and prejudice");
        ArrayList<String> words1 = new ArrayList<>();

        FileOperation.readFile("pride-and-prejudice.txt", words1);

        System.out.println("the total words is:"+words1.size());

        BSTSet set1 = new BSTSet();
        for (String word : words1){
            set1.add(word);
        }
        System.out.println("Total different word:"+set1.getSize());

        System.out.println("a tale of two cities");
        ArrayList<String> words2 = new ArrayList<>();

        FileOperation.readFile("a-tale-of-two-cities.txt", words2);

        System.out.println("the total words is:"+words2.size());

        BSTSet set2 = new BSTSet();
        for (String word : words2){
            set2.add(word);
        }

        System.out.println("Total different word:"+set2.getSize());
        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }

    public static double testLinkedList(){

        long start = System.nanoTime();
        System.out.println("pride and prejudice");
        ArrayList<String> words1 = new ArrayList<>();

        FileOperation.readFile("pride-and-prejudice.txt", words1);

        System.out.println("the total words is:"+words1.size());

        LinkedListSet set1 = new LinkedListSet();
        for (String word : words1){
            set1.add(word);
        }

        System.out.println("Total different word:"+set1.getSize());

        System.out.println("a tale of two cities");
        ArrayList<String> words2 = new ArrayList<>();

        FileOperation.readFile("a-tale-of-two-cities.txt", words2);

        System.out.println("the total word s is:"+words2.size());

        LinkedListSet set2 = new LinkedListSet();
        for (String word : words2){
            set2.add(word);
        }

        System.out.println("Total different word:"+set2.getSize());
        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }
    public static void main(String[] args) {
        System.out.println("cost time of BST");
        double time1 = testBST();
        System.out.println(time1);     // 0.599607553

        System.out.println("cost time of LinkedList");
        double time2 = testLinkedList();
        System.out.println(time2);   // 12.568190375

        // 链表集合时间复杂度
        // 增 删  查  -> O(n)

        // 基于二分搜索树集合的时间复杂度 -> O(logn)
    }
}
