/**
 * @ClassName LinkedListQueue
 * @Author ranger
 * @Date 2018/11/24
 * @Description 基于链表的循环队列
 **/
public class LinkedListQueue<E> implements Queue<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head,tail;
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public void enqueue(E e){

        if(tail == null){   // 队列为空
            tail = new Node(e);
            head = tail;
        }else{
            Node node = new Node(e);
            tail.next = node;
            tail = node;

        }
        size++;
    }

    @Override
    public E dequeue(){
        if(isEmpty()){
            throw new IllegalArgumentException("queue is empty,dequeue failed");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if(head == null){    // 队列为空的时候，tail节点和头节点指向同一个节点
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront(){
        if(isEmpty()){
            throw new IllegalArgumentException("queue is empty,get  failed");
        }
        return tail.e;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node cur = head;
        while(cur != null){
            sb.append(cur+"->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();


    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedListQueue<>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

}
