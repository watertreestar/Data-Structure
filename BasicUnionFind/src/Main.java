
import java.util.Random;

/**
 * @ClassName Main
 * @Author ranger
 * @Date 2018/12/19
 * 测试两个版本的并查集
 *
 * 还可以继续优化  union操作的时候  树的节点总数小的根节点指向树的节点总数多的根节点   基于size
 *              union操作的时候  树的高度的根节点指向树的高度多的根节点   基于rank
 **/
public class Main {

    private static double testUF(UF uf,int m){
        int size = uf.getSize();
        Random random = new Random();

        long start = System.nanoTime();
        // union operation
        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        // find operation
        for (int i = 0;i<m;i++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }


        long end = System.nanoTime();

        return (end-start)/1000000000.0;
    }
    public static void main(String[] args) {
        //-------version1----------------------

        int n = 100000;
        int size = 1000000;
        UF uf1 = new UnionFind1(size);
        System.out.println("version1 UnionFind:"+testUF(uf1, n)+"s");

        //-------version2-----------------------
        UF uf2 = new UnionFind2(size);
        System.out.println("version2 UnionFind:"+testUF(uf2, n)+"s");




    }
}
