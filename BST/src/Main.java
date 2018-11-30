/**
 * @ClassName Main
 * @Author ranger
 * @Date 2018/11/30
 * 二叉搜索树测试（BST）
 **/
public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();


        int nums[] = {5,3,6,8,4,2};
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
        bst.levelOrder();



        //System.out.println(bst);
    }
}
