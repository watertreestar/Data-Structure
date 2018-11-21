/**
 * @ClassName ArrayQueue
 * @Author ranger
 * @Date 2018/11/21
 **/
public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    public ArrayQueue(int capacity){
        array = new Array<E>(capacity);
    }

    public ArrayQueue(){
        array = new Array<E>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst() ;
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue : ")).append("Front[");
        for (int i = 0; i < getSize() ; i++) {
            sb.append(array.get(i));
            if(i != getSize()-1){
                sb.append(",");
            }
        }
        sb.append("]Tail");
        return sb.toString();
    }

    public static void main(String args[]){
        ArrayQueue queue = new ArrayQueue<Integer>();

        for (int i = 0; i < 100000; i++) {
            queue.enqueue(i);
        }

        long startTime = System.currentTimeMillis();
        queue.dequeue();
        long endTime = System.currentTimeMillis();

        System.out.println("cost time is :"+(endTime-startTime));
    }


    /**
     * 改进前时间复杂度:
     * void enqueue(E e)    O(1)   均摊
     *
     * E dequeue()     O(n)    数组需要移动   ->  优化:记录front指向  ->  循环队列
     *
     * E front()    O(1)
     *
     * int getSize()  O(1)
     *
     * boolean isEmpty()   O(1)
     */
}
