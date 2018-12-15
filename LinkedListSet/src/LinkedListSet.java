/**
 * @ClassName LinkedListSet
 * @Author ranger
 * @Date 2018/12/15
 **/
public class LinkedListSet implements Set{
    private LinkedList list;

    public LinkedListSet(){
        list = new LinkedList();
    }
    @Override
    public void add(Object o) {
        if(!list.contains(o)){
            list.addFirst(o);
        }
    }

    @Override
    public void remove(Object o) {
        list.removeElement(o);
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
