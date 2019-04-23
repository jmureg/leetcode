package stacks;

import java.util.Stack;

public class ValidParentheses {
    ValidParentheses(){
    }

    public boolean isValid(String s) {
        Stack<Character> cache = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            switch (c) {
                case '(':
                    cache.add(c);
                    break;
                case ')':
                    if(!cache.empty() && cache.peek()=='(') {
                        cache.pop();
                    } else {
                        return false;
                    }
                    break;
                case '[':
                    cache.add(c);
                    break;
                case ']':
                    if(!cache.empty() && cache.peek()=='[') {
                        cache.pop();
                    } else {
                        return false;
                    }
                    break;
                case '{':
                    cache.add(c);
                    break;
                case '}':
                    if(!cache.empty() && cache.peek()=='{') {
                        cache.pop();
                    } else {
                        return false;
                    }
                    break;
                 default:
                    return false;
            }
        }
        return cache.size()==0?true:false;
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        String input = null;

        input = "[";
        System.out.println(input + "-" + vp.isValid(input));

        input = "";
        System.out.println(input + "-" + vp.isValid(input));

        input = "{[(})]";
        System.out.println(input + "-" + vp.isValid(input));

        input = "[({})]";
        System.out.println(input + "-" + vp.isValid(input));

        input = "[()]";
        System.out.println(input + "-" + vp.isValid(input));

        input = "([)]";
        System.out.println(input + "-" + vp.isValid(input));

        input = "()";
        System.out.println(input + "-" + vp.isValid(input));

        input = "())";
        System.out.println(input + "-" + vp.isValid(input));
    }
}
