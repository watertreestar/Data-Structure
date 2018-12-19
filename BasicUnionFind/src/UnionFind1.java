/**
 * @ClassName UnionFind1
 * @Author ranger
 * @Date 2018/12/19
 * 并查集第一版
 **/
public class UnionFind1 implements UF {

    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    /**
     * 元素p和元素q是否属于同一个集合
     * @param p
     * @param q
     * @return
     * time complexity  ->  O(1)
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素p和元素q所属的集合
     * @param p
     * @param q
     * time complexity  ->  O(n)
     */
    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if(pId == qId)  return;

        for(int i = 0;i<id.length;i++){
            if(id[i] == pId){
                id[i] = qId;
            }
        }
    }

    /**
     * 获取元素p所属的集合id
     * @param p
     * @return
     */
    private int find(int p){
        if(p >= id.length || p < 0){
            throw  new IllegalArgumentException("index out of bound");
        }
        return id[p];
    }

    @Override
    public int getSize() {
        return id.length;
    }
}
