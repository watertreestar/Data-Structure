/**
 * @ClassName Main
 * @Author ranger
 * @Date 2018/11/4
 **/
public class Main {
    public static void main(String args[]){
        Array<Integer> array = new Array();
        array.addLast(10);
        array.addLast(20);
        array.addLast(30);
        array.addLast(40);
        array.addLast(50);
        array.addLast(60);
        System.out.println(array);
        array.add(1,15 );
        System.out.println(array);
        System.out.println(array.remove(5));
        System.out.println(array);
        for(int i  = 0;i<200;i++){
            array.addLast(i);
        }
        System.out.println(array);

        for (int i = 200; i >100 ; i--) {
            array.remove(i);
        }
        System.out.println(array);

    }
}
