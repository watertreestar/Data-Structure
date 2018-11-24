/**
 * @ClassName Main
 * @Author ranger
 * @Date 2018/11/24
 **/
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        for(int i = 0;i<5;i++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(8, 2);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
