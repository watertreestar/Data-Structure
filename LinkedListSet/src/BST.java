/**
 * @ClassName BST
 * @Author ranger
 * @Date 2018/11/30
 * 二分搜索树
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


    // 向二分搜索树中添加新的元素e
    public void add(E e){
        root = add(root, e);
    }

    // 向以node为根的二分搜索树中插入元素e，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, E e){

        if(node == null){
            size ++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if(e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }


    public boolean contains(E e){
        return contains(root, e);
    }


    // 看以node为根的二分搜索树中是否包含元素e, 递归算法
    private boolean contains(Node node, E e){

        if(node == null)
            return false;

        if(e.compareTo(node.e) == 0)
            return true;
        else if(e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else // e.compareTo(node.e) > 0
            return contains(node.right, e);
    }

    /**
     * 删除树中的节点
     * @param e
     */
    public void remove(E e){
        root = remove(root,e);
    }


    private Node remove(Node node ,E e){
        if(node == null) return null;

        if(e.compareTo(node.e) > 0){
            node.right = remove(node.right,e);
            return node;
        }else if(e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
            return node;
        }else{ // e == node.e
            // 待删除节点左子树为空
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            // 待删除节点右节点为空
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }


    }

    /**
     * 返回二叉搜索树的最小值(递归调用，一直向左找，直到左孩子为空)
     * @return
     */
    public E minimum(){
        if(isEmpty()){
            throw new IllegalArgumentException("BST is empty");
        }
        return minimum(root).e;
    }

    private Node minimum(Node node){
        if(node.left == null)  return node;

        return minimum(node.left);
    }

    /**
     * 删除二叉搜索树的最小节点
     */
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除以node为根节点的最小节点
     * 返回删除后节点后的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMin(Node node){

        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
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
