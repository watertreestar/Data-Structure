import java.util.Random;

/**
 * @ClassName Main
 * @Description 循环队列和数组队列时间消耗简单测试
 * @Author ranger
 * @Date 2018/11/23
 *
 * 可以多次运行，取平均值
 **/
public class Main {
    public static void main(String[] args) {
        int opCount = 100000;
        // 测试数组队列
        Queue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue,opCount);
        System.out.println("ArrayQueue,time:"+time1+"s");   //6.03s

        // 测试循环队列
        Queue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue,opCount);
        System.out.println("LoopQueue,time:"+time2+"s");  // 0.021s

        // 测试基于链表的队列
        Queue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(linkedListQueue,opCount);
        System.out.println("LinkedListQueue,time:"+time3+"s");  //0.019


    }

    private static double testQueue(Queue<Integer> queue,int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}
