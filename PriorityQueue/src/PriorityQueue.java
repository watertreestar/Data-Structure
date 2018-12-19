/**
 * @ClassName Priority
 * @Author ranger
 * @Date 2018/12/19
 * 基于二叉最大堆的优先队列
 **/
public class PriorityQueue<E extends Comparable<E>> implements Queue<E>{
    private MaxHeap<E> heap;


    public PriorityQueue(){
        heap = new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return heap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        heap.add(e);
    }

    @Override
    public E dequeue() {

        return heap.removeMax();
    }

    @Override
    public E getFront() {
        return heap.findMax();
    }
}
