import java.util.Random;

/**
 * @ClassName Main
 * @Author ranger
 * @Date 2018/12/18
 **/
public class Main {
    public static void main(String[] args){
        int n  = 1000000000;
        MaxHeap<Integer> heap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0;i<n;i++){
            heap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = heap.removeMax();
        }

        for(int i = 0;i<array.length - 1;i++){
            if (array[i] < array[i+1]){
                throw new RuntimeException("array have errors");
            }

        }

        System.out.println("Test completed,array is sorted");

    }
}
