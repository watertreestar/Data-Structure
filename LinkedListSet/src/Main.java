import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        System.out.println("pride and prejudice");
        ArrayList<String> words1 = new ArrayList<>();

        FileOperation.readFile("pride-and-prejudice.txt", words1);

        System.out.println("the total words is:"+words1.size());

        LinkedListSet set1 = new LinkedListSet();
        for (String word : words1){
            set1.add(word);
        }

        System.out.println("Total diffrent word:"+set1.getSize());

        System.out.println("a tale of two cities");
        ArrayList<String> words2 = new ArrayList<>();

        FileOperation.readFile("a-tale-of-two-cities.txt", words2);

        System.out.println("the total words is:"+words2.size());

        LinkedListSet set2 = new LinkedListSet();
        for (String word : words2){
            set2.add(word);
        }

        System.out.println("Total diffrent word:"+set2.getSize());


        // 输出结果

        /*pride and prejudice
        the total words is:125901
        Total diffrent word:6530
        a tale of two cities
        the total words is:141489
        Total diffrent word:9944*/

    }
}