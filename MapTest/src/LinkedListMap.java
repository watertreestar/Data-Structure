/**
 * @ClassName LinkedListMap
 * @Author ranger
 * @Date 2018/12/15
 **/
public class LinkedListMap<K,V> implements Map<K,V> {
    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key,V value,Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key){
            this(key,null,null);
        }

        public Node(){
            this(null,null,null);
        }


        @Override
        public String toString(){
            return key.toString() + ":" + value.toString();
        }


    }

    // 虚拟头节点
    private Node dummyNode;
    private int size;

    public LinkedListMap(){
        dummyNode = new Node();
        this.size = 0;
    }


    private Node getNode(K key){
        Node cur = dummyNode.next;
        while (cur != null){
            if(cur.key.equals(key))
                return cur;
            cur = cur.next;
        }
        return null;
    }
    @Override
    public void add(K key, V value) {
        if(getNode(key) == null){
            // key is not existing,add current key to map
            dummyNode.next = new Node(key, value, dummyNode.next);
            size ++;
        }else{
            // throws a exception or update current key
            set(key, value);
        }
    }

    @Override
    public V remove(K key) {
       Node prev = dummyNode;
       while(prev.next != null){
           if(prev.next.key.equals(key)){
               break;
           }
           prev = prev.next;
       }

       if(prev.next != null){
           Node delNode = prev.next;
           prev.next = delNode.next;
           delNode.next = null;
           size--;
           return delNode.value;

       }
       return null;
    }

    @Override
    public boolean contains(K key) {
        if(getNode(key) == null) return false;
        return true;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node == null){
            throw new IllegalArgumentException(key+"doesn't exist ");
        }
        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
