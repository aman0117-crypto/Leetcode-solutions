class Solution {
    public int maxDepth(String s) {
        int count=0;
        int result=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                count++;
                if(count>result){
                    result=count; 
                }
            }
            else if(s.charAt(i)==')'){
                count--;
            }
            else{
                continue;
            }
        }
        return result;
        
    }
}

//Optimal Approach: TC-O(n), SC-O(1)