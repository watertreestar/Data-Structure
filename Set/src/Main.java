import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * @ClassName Main
 * @Author ranger
 * @Date 2018/12/14
 **/
public class Main {
    public static void main(String[] args) {
//        Set s = new BSTSet();
//        s.add(1);
//        s.add(2);
//        s.add(3);
//        s.add(4);
//        s.add(5);
//        s.add(2);
//
//        System.out.printf(s.toString());

        // 测试

        /*System.out.println(System.getProperty("user.dir"));

        File file = new File("test.txt");
        if(file.exists()){
            System.out.println("file exist");
        }*/

        System.out.println("pride and prejudice");
        ArrayList<String> words1 = new ArrayList<>();

        FileOperation.readFile("pride-and-prejudice.txt", words1);

        System.out.println("the total words is:"+words1.size());

        BSTSet set1 = new BSTSet();
        for (String word : words1){
            set1.add(word);
        }

        System.out.println("Total diffrent word:"+set1.getSize());

        System.out.println("a tale of two cities");
        ArrayList<String> words2 = new ArrayList<>();

        FileOperation.readFile("a-tale-of-two-cities.txt", words2);

        System.out.println("the total words is:"+words2.size());

        BSTSet set2 = new BSTSet();
        for (String word : words2){
            set2.add(word);
        }

        System.out.println("Total diffrent word:"+set2.getSize());


    }
}
