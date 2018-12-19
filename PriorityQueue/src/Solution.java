import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

/**
 * @ClassName Solution
 * @Author ranger
 * @Date 2018/12/19
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 **/
public class Solution {

    class Frenquecy implements Comparable<Frenquecy> {

        int e;
        int freq;

        public Frenquecy(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Frenquecy o) {
            if (this.freq < o.freq) return 1;
            else if (this.freq > o.freq) return -1;
            else return 0;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        PriorityQueue<Frenquecy> pq = new PriorityQueue<>();
        for (int key : map.keySet()) {
            if (pq.getSize() < k) {
                pq.enqueue(new Frenquecy(key, map.get(key)));

            }else if(map.get(key) > pq.getFront().freq ){
                pq.dequeue();
                pq.enqueue(new Frenquecy(key, map.get(key)));
            }
        }

        List<Integer> res = new LinkedList<>();
        while(!pq.isEmpty()){
            res.add(pq.dequeue().e);
        }
        return res;

    }

    public static void main(String[] args) {

        int []nums = {1,1,1,2,2,3};
        List<Integer> result = new Solution().topKFrequent(nums, 2);
        for(int i : result){
            System.out.print(i+" ");
        }
    }
}
