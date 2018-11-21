/**
 * @ClassName Stack
 * @Author ranger
 * @Date 2018/11/11
 **/
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
