class Solution {
    public int[] sortedSquares(int[] nums) {
        //Two pointers 
        int [] res=new int[nums.length];
        int left=0;
        int right=nums.length-1;
        int index=nums.length-1;
        while(left<=right){
            int leftsq=nums[left]*nums[left];
            int rightsq=nums[right]*nums[right];
            if(leftsq>rightsq){
                res[index]=leftsq;
                left++;
            }
            else{
                res[index]=rightsq;
                right--;
            }
            index--;
        }
        return res;
    }
}