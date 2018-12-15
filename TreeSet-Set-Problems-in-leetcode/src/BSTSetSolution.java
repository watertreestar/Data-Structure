
/**
 * @ClassName BSTSetSolution
 * @Author ranger
 * @Date 2018/12/15
 **/
public class BSTSetSolution {
    public int uniqueMorseRepresentations(String[] words) {
        String morseCodes[] = {
                ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",
                ".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };
        Set set = new BSTSet();
        for (String word : words){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(morseCodes[word.charAt(i) - 'a']);
            }
            set.add(sb.toString());
        }
        return set.getSize();
    }

    public static void main(String[] args) {
        String []s = {"gin", "zen", "gig", "msg"};
        int size = new Solution().uniqueMorseRepresentations(s);
        System.out.println(size);
    }
}
