import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName IntersectionOfTwoArraysII
 * @Author ranger
 * @Date 2018/12/17
 **/
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new TreeMap<>();
        for(int num : nums1){
            if(!map.containsKey(num)){
                map.put(num, 1);
            }else
                map.put(num, map.get(num)+1);
        }
        List<Integer> list = new ArrayList<>();
        for(int num : nums2){
            if(map.get(num) != null && map.get(num) > 0){
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        int []res = new int[list.size()];
        for (int i = 0;i< list.size();i++){
            res[i] = list.get(i);
        }
        return res;

    }

    public static void main(String []args){
        int []nums1 = {4,9,5};
        int []nums2 = {9,4,9,8,4};
        new IntersectionOfTwoArraysII().intersect(nums1, nums2);
    }
}
