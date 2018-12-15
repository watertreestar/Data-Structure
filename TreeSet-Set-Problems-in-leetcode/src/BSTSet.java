/**
 * @ClassName BSTSet
 * @Author ranger
 * @Date 2018/11/30
 * 基于树结构的树，保证了元素的有序性
 **/
public class BSTSet<E extends Comparable<E>> implements Set<E>{

    private BST<E> bst;

    public BSTSet(){
        bst = new BST<>();
    }

    @Override
    public int getSize(){
        return bst.size();
    }

    @Override
    public boolean isEmpty(){
        return bst.isEmpty();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public boolean contains(E e){
        return bst.contains(e);
    }

    @Override
    public void remove(E e){
        bst.remove(e);
    }

    @Override
    public String toString(){
        return bst.toString();
    }
}
