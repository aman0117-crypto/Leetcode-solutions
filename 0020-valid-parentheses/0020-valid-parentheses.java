class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        if(s.length()%2==1){
            return false;
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(s.charAt(i));
            }
            if(s.charAt(i)=='['){
                st.push(s.charAt(i));
            }
            if(s.charAt(i)=='{'){
                st.push(s.charAt(i));
            }
            if(s.charAt(i)==')'){
                if(st.empty()){
                    return false;
                }
                else if(st.peek()=='('){
                    st.pop();
                }
                else{
                    return false;
                }
            }
            if(s.charAt(i)==']'){
                if(st.empty()){
                    return false;
                }
                else if(st.peek()=='['){
                    st.pop();
                }
                else{
                    return false;
                }
            }
            if(s.charAt(i)=='}'){
                if(st.empty()){
                    return false;
                }
                else if(st.peek()=='{'){
                    st.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(st.empty()){
            return true;
        }
        return false;
    }
} 