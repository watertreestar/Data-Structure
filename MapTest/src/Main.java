import java.util.ArrayList;

/**
 * @ClassName Main
 * @Author ranger
 * @Date 2018/12/16
 **/
public class Main {

    private static double test(Map<String,Integer> map,String fileName){
        ArrayList<String> words = new ArrayList();
        FileOperation.readFile(fileName, words);

        long start = System.nanoTime();
        for (String word : words){
            if(map.get(word) == null){
                map.add(word, 1);
            }else{
                map.set(word, map.get(word) + 1);
            }
        }

        System.out.println("Total different words:"+map.getSize());
        System.out.println("Frequency of PRIDE:"+map.get("pride"));
        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }

    public static void main(String[] args) {
        System.out.printf("pride and prejudice");
        System.out.println("test of LinkedMap:"+test(new LinkedListMap<>(),"pride-and-prejudice.txt"));  // 17s
        System.out.println("test of BSTMap:"+test(new BSTMap<>(),"pride-and-prejudice.txt"));  // 0.09s

        System.out.println("a tale of two cities");
        System.out.println("test of LinkedMap:"+test(new LinkedListMap<>(),"a-tale-of-two-cities.txt")); // 33s
        System.out.println("test of BSTMap:"+test(new BSTMap<>(),"a-tale-of-two-cities.txt"));  // 0.07s




    }
}
