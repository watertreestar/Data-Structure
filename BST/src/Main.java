import java.util.ArrayList;
import java.util.Random;

/**
 * @ClassName Main
 * @Author ranger
 * @Date 2018/11/30
 * 二叉搜索树测试（BST）
 **/
public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();


        /*int nums[] = {5,3,6,8,4,2};
        for (int i = 0; i < nums.length; i++) {
            bst.add(nums[i]);
        }
        // 前序遍历
        bst.preOrder();
        System.out.println();
        // 前序遍历非递归
        bst.preOrderNoRecursive();
        System.out.println();
        // 中序遍历：遍历结果有序
        bst.inOrder();
        System.out.println();
        // 后序遍历
        bst.postOrder();

        System.out.println();
        // 层序遍历
        bst.levelOrder();*/

        // 测试removeMax,removeMin

        int count = 1000;
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> list = new ArrayList<>();
        while(!bst.isEmpty()){
            list.add(bst.removeMin());
        }

        for (int i = 1; i < list.size(); i++) {
            if(list.get(i-1) > list.get(i)) throw new IllegalArgumentException("Error");
        }
        System.out.println(list);
        System.out.println("removeMin completed");


        // 测试removeMax
        for (int i = 0; i < 10; i++) {
            Integer num = random.nextInt(10000);
            System.out.print(num+" ");
            bst.add(num);
       }
       System.out.println();



        list = new ArrayList<>();
        while(!bst.isEmpty()){
            list.add(bst.removeMax());
        }
        System.out.println(list);
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i-1) < list.get(i)) throw new IllegalArgumentException("Error");
        }

        System.out.println("removeMax completed");





    }
}
