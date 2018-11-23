/**
 * @ClassName LoopQueue
 * @Author ranger
 * @Date 2018/11/23
 **/
public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    // tail 表示下一个元素放入的位置，tail的位置总是空着的，因为要实现满足  front == tail 为空
    private int front,tail;
    private int size;

    public LoopQueue(int capacity){
        data = (E[])new Object[capacity+1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    /**
     * 循环队列中当前包含的元素个数
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 循环队列的容量
     * @return
     */
    public int getCapacity(){
        return data.length-1;
    }

    /**
     * 队列是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 入队操作
     * @param e
     */
    @Override
    public void enqueue(E e) {
        // 如果队列满，则进行扩容操作
        if((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = ( tail+1 )%data.length;
        size++;
    }

    /**
     * 出队操作
     * @return
     */
    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("can not dequeue from empty queue");
        }
        E e = data[front];
        data[front] = null;
        front = (front + 1 )%data.length;
        size--;
        // 是否进行缩容操作
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0 ){
            // 当前元素个数为容量的1/4,则缩容为当前的一半
            resize(getCapacity() / 2);
        }
        return e;
    }

    /**
     * 获取队首
     * @return
     */
    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("queue is empty");
        }
        return data[front];
    }

    /**
     * 对循环队列进行扩容操作或者缩容操作
     * @param newCapacity
     */
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity+1];
        // 元素复制
        for(int i = 0;i < size;i++){
            newData[i] = data[(i+front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    /**
     * 输出循环队列的元素
     * @return
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size = %d,capacity = %d \n",size,getCapacity()));
        sb.append("front[");
        for (int i = front; i != tail; i = (i+1)%data.length) {
            sb.append(data[i]);
            if((i+1)%data.length != tail){
                sb.append(',');
            }
        }
        sb.append("]tail");
        return sb.toString();
    }

    public static void main(String[] args) {

        /**
         * 测试循环队列的入队和出队操作
         */
        Queue<Integer> queue = new LoopQueue();

        for (int i = 0; i < 1000; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}


/**
 * 循环队列的复杂度：
 *
 * enqueue   O(1)   均摊   扩招
 *
 * dequeue   O(1)   均摊   缩容
 *
 * E front()    O(1)
 *
 * int getSize()  O(1)
 *
 * boolean isEmpty()   O(1)
 */
