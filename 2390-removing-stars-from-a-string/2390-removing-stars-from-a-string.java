class Solution {
    public String removeStars(String s) {
        StringBuilder result=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch=='*'){
                result.deleteCharAt(result.length()-1);
            }
            else{
                result.append(ch);
            }
        }
        return result.toString();
    }
}