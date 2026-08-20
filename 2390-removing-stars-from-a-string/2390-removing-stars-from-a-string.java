class Solution {
    public String removeStars(String s) {
        Stack<Character>st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='*'){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        StringBuilder result=new StringBuilder();
        while(!st.empty()){
            result.append(st.pop());
        }
        return result.reverse().toString();
    }
}