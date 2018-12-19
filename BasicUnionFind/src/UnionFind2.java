/**
 * @ClassName UnionFind2
 * @Author ranger
 * @Date 2018/12/19
 * 第二个版本并查集
 **/
public class UnionFind2 implements UF {

    private int []parent;

    public UnionFind2(int size){
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    private int find(int p){
        if(p >= parent.length || p < 0){
            throw  new IllegalArgumentException("index out of bound");
        }
        while(p != parent[p]){
            p = parent[p];
        }
        return p;
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if(qRoot == qRoot) return;
        parent[pRoot] = qRoot;
    }

    @Override
    public int getSize() {
        return parent.length;
    }
}
