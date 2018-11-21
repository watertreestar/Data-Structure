import java.util.Arrays;

/**
 * @ClassName Array
 * @Author ranger
 * @Date 2018/11/4
 **/
public class Array<E> {

    private E[] data;

    // 数组中当前包含的元素个数
    private int size;

    // 有参构造函数，设置数组的容量
    public Array(int capacity){
        data = (E[])new Object[capacity];
        this.size = 0;
    }

    // 无参构造函数，默认初始化容量为10
    public Array(){
        this(10);
    }

    // 获取当前数组中的元素个数
    public int getSize(){
        return this.size;
    }

    // 获取容量
    public int getCapacity(){
        return data.length;
    }

    // 是否为空
    public boolean isEmpty(){
        return size==0;
    }

    // 向末尾插入一个元素
    public void addLast(E e){
       /* if(size == data.length){
            throw new IllegalArgumentException("add failed,array is full");
        }
        data[size] = e;
        size++;*/

        // 如果复用add方法
        add(size,e);
    }

    // 添加元素到第一个位置
    public void addFirst(E e){
        add(0,e);
    }

    // 添加到指定的位置
    public void add(int index,E e){

        if(index <0 || index > size){
            throw new IllegalArgumentException("Add failed,Require index >= 0 and index <=size");

        }
        if(size == data.length){
            resize(2 * data.length);
        }
        for(int i = size -1;i>=index;i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        /*for(int i = 0;i<size;i++){
            newData[i] = data[i];
        }*/

        //System.arraycopy(data, 0, newData, 0, size);
        newData = Arrays.copyOf(data, newCapacity);

        data = newData;



    }

    // 获取index位置元素
    public E get(int index){
        if(index <0 || index >= size){
            throw new IllegalArgumentException("Get failed,Illegal index");
        }
        return data[index];
    }

    // 设置index位置元素
    public void set(int index,E e){
        if(index <0 || index >= size){
            throw new IllegalArgumentException("Set failed,Illegal index");
        }
        data[index] = e;
    }

    // 数组中是否包含元素e
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    // 查找数组中e的位置，如果没有则返回-1
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    // 查找元素所有的位置
    public int[] findAll(int e){
        return null;
    }

    // 从数组中删除Index位置的元素，并返回删除的元素
    public E remove(int index){
        if(index <0 || index >= size){
            throw new IllegalArgumentException("Remove failed,Illegal index");
        }
        E result = data[index];
        for (int i = index+1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        data[size]=null;
        if(size == data.length / 2 && data.length / 2 != 0) {
            resize(data.length / 4);
        }
        return result;
    }

    // 从数组中删除第一个元素，返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 删除最后一个元素，返回删除的元素
    public E removeLast(){
        return remove(size-1);
    }

    // 从数组中删除e，如果重复，只删除一个
    public void removeElement(E e){
        int index  = find(e);
        if(index != -1){
            remove(index);
        }
    }

    // 删除元素，重复则删除所有
    public void removeElementAll(){

    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array : size = %d , capacity = %d\n",size,data.length)).append("[");
        for (int i = 0; i < size ; i++) {

            sb.append(data[i].toString());
            if(i != size-1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}

