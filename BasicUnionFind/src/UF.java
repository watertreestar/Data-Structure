/**
 * @ClassName UF
 * @Author ranger
 * @Date 2018/12/19
 **/
public interface UF {
    boolean isConnected(int p,int q);
    void unionElements(int p,int q);
    int getSize();
}
