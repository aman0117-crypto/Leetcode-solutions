class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack=new Stack<>();
        int result=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(s.charAt(i));
                if(stack.size()>result){
                    result=stack.size(); 
                }
            }
            else if(s.charAt(i)==')'){
                stack.pop();
            }
            else{
                continue;
            }
        }
        return result;
    }
}

//Brute force: TC-O(n), SC-O(n)