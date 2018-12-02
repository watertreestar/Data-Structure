/**
 * @ClassName Set
 * @Author ranger
 * @Date 2018/11/30
 **/
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}
