import java.sql.SQLOutput;
import java.util.ArrayList;

/**
 * @ClassName Main
 * @Author ranger
 * @Date 2018/12/15
 **/
public class Main {
    public static void main(String[] args) {
        System.out.printf("Pride and Prejudice");
        ArrayList<String> words = new ArrayList();
        FileOperation.readFile("pride-and-prejudice.txt", words);

        Map<String,Integer> map = new LinkedListMap();
        for (String word : words){
            if(map.get(word) == null){
                map.add(word, 1);
            }else{
                map.set(word, map.get(word) + 1);
            }
        }

        System.out.println("Total different words:"+map.getSize());
        System.out.println("Frequency of PRIDE:"+map.get("pride"));

        // Pride and PrejudiceTotal different words:6530
        // Frequency of PRIDE:53

    }
}
