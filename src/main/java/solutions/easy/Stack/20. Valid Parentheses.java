class Solution {
    public boolean isValid(String s) {
        //you get a parenthesis you add the opposite to the stack
        //and keep popping when you find its pair
        Stack<Character> stack = new Stack();
        for(char c : s.toCharArray()){
            if(c == '(') stack.push(')');
            else if(c == '{') stack.push('}');
            else if(c == '[') stack.push(']');
            else{
                //also before popping it is important to check if stack is empty
                if(stack.isEmpty() || stack.pop() != c){ //either no opening bracket or mismatch
                    return false;
                }
            }

        }
        return stack.isEmpty(); //this will handle single open bracket test cases because in valid cases stack is empty
    }
}


