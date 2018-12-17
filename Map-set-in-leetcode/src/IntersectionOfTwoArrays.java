import java.util.*;

/**
 * @ClassName IntersectionOfTwoArrays
 * @Author ranger
 * @Date 2018/12/17
 * 给定两个数组，编写一个函数来计算它们的交集。重复元素只算一个
 **/
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2){
        Set<Integer> set = new TreeSet<>();
        for (int num : nums1){
            set.add(num);
        }
      List<Integer> list = new ArrayList<>();
        for(int num : nums2){
            if(set.contains(num)){
                list.add(num);
                set.remove(num);
            }
        }

        int []res = new int[list.size()];
        for(int i = 0;i<res.length;i++){
            res[i] = list.get(i);
        }
        return res;
    }


}
