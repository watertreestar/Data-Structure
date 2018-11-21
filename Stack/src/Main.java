/**
 * @ClassName Main
 * @Author ranger
 * @Date 2018/11/11
 **/
public class Main {

   public static void main(String args[]){
       ArrayStack arrayStack = new ArrayStack<Integer>();
       for (int i = 0; i <5 ; i++) {
           arrayStack.push(i);
           System.out.println(arrayStack);
       }

       arrayStack.pop();
       System.out.println(arrayStack);
   }
}
