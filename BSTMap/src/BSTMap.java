/**
 * @ClassName BSTMap
 * @Author ranger
 * @Date 2018/12/15
 *
 **/
public class BSTMap<K extends Comparable<K>,V> implements Map<K,V>{


    /**
     * 根据kie
     * @param key
     * @return
     */
    private Node getNode(K key){
        return getNode(root, key);
    }
    private Node getNode(Node node,K key){
        if(node == null) return null;

        if(node.key.equals(key)) return node;
        else if(key.compareTo(node.key) > 0){
            return getNode(node.right,key);
        }else {
            return getNode(node.left, key);
        }
    }

    @Override
    public void add(K key, V value) {
        root = add(root,key,value);
    }

    private Node add(Node node ,K key,V value){
        if(node == null){
            size ++;
            return new Node(key,value);
        }

        if(key.compareTo(node.key) < 0){
            node.left = add(node.left,key,value);
        }else if(key.compareTo(node.key) > 0){
            node.right = add(node.right,key,value);
        }else{
            node.value = value;
        }

        // e == node.e  -> 什么都不做
        return node;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        if(node != null) return node.value;
        return null;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if(node != null){
            node.value = value;
        }else{
            throw new IllegalArgumentException("key doesn't exist");
        }
    }

    @Override
    public V remove(K key) {
        Node node = getNode(key);
        if(node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }


    private Node remove(Node node ,K key){
        if(node == null) return null;

        if(key.compareTo(node.key) > 0){
            node.right = remove(node.right,key);
            return node;
        }else if(key.compareTo(node.key) < 0){
            node.left = remove(node.left, key);
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

    // get the minimum key
    public K minimum(){
        if(isEmpty()){
            throw new IllegalArgumentException("BST is empty");
        }
        return minimum(root).key;
    }

    // get the minimum key by parent node;
    private Node minimum(Node node){
        if(node.left == null)  return node;

        return minimum(node.left);
    }

    // remove the minimum node from BST
    public K removeMin(){
        K ret = minimum();
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
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private class Node{
        Node left,right;
        K key;
        V value;

        public Node(K key,V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }

    }

    private Node root;
    private int size;




}
