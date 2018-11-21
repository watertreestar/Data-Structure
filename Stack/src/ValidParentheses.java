/**
 * @ClassName ValidParentheses
 * @Author ranger
 * @Date 2018/11/11
 **/


import java.util.Stack;
/**
 * 验证括号是否匹配
 */
public class ValidParentheses {
    public boolean isValid(String str){
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }

                char topChar = stack.pop();
                if(c==')' && topChar != '('){
                    return false;
                }
                if(c=='}' && topChar != '{'){
                    return false;
                }
                if(c==']' && topChar != '['){
                    return false;
                }

            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}
