import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName BST
 * @Author ranger
 * @Date 2018/11/30
 **/
public class BST<E extends Comparable<E>> {
    private class Node{
        private E e;
        private Node left,right;

        public Node(E e){
            this.e = e;
            this.left = null;
            this.right = null;
        }


    }
    private Node root;

    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E e){
        root = add(root,e);
    }

    /**
     * 向以node为根的节点插入元素e，递归
     * 返回插入新节点后的根节点
     * @param node
     * @param e
     * @return
     */
    private Node add(Node node ,E e){
        if(node == null){
            size ++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0){
            node.left = add(node.left,e);
        }else if(e.compareTo(node.e) > 0){
            node.right = add(node.right,e);
        }

        // e == node.e  -> 什么都不做
        return node;
    }


    public boolean contains(E e){
        return contains(root, e);
    }

    /**
     * 检查树中是否包含某个值
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node,E e){
        if(node == null){
            return false;
        }
        if(node.e.equals(e)){
            return true;
        }else if(e.compareTo(node.e) < 0){
            return contains(node.left,e);
        }else{
            return contains(node.right,e);
        }
    }

    /**
     * 前序遍历该树
     */
    public void preOrder(){

        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.e + " ");
        // 遍历左子树
        preOrder(node.left);
        // 遍历右子树
        preOrder(node.right);
    }

    /**
     * 中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if (node == null) {
            return;
        }
        // 遍历左子树
        inOrder(node.left);

        System.out.print(node.e + " ");

        // 遍历右子树
        inOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if (node == null) {
            return;
        }
        // 遍历左子树
        inOrder(node.left);

        // 遍历右子树
        inOrder(node.right);

        System.out.print(node.e + " ");
    }

    /**
     * 非递归前序遍历
     */
    public void preOrderNoRecursive(){
        if(root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node cur = stack.pop();
            System.out.print(cur.e+" ");
            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
        }
    }

    /**
     * 非递归中序遍历
     */
    public void inOrderNoRecursive(){
        if(root == null) return;
        Stack<Node> stack = new Stack<>();


    }

    /**
     * 非递归后序遍历
     */
    public void postOrderNoRecursive(){
        if(root == null) return;



    }

    /**
     * 层序遍历（广度优先遍历）  图中也有广度优先遍历和深度优先遍历
     * @return
     */
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cur != null ) System.out.print(cur.e+" ");
            if(cur.left != null)
                queue.add(cur.left);
            if(cur.right != null)
                queue.add(cur.right);
        }
    }



    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        generateBSTString(root,0,sb);
        return sb.toString();
    }

    /**
     * 生成以node为根节点，深度为depth的描述的二叉字符串
     * @param node
     * @param depth
     * @param sb
     */
    private void generateBSTString(Node node,int depth,StringBuilder sb){
        if (node == null) {
            sb.append(generateDepthString(depth)+"null\n");
            return;
        }
        sb.append(generateDepthString(depth)+node.e+"\n");
        generateBSTString(node.left,depth+1,sb);
        generateBSTString(node.right,depth+1,sb);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

}
