/**
 * @ClassName Queue
 * @Author ranger
 * @Date 2018/12/17
 **/
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
