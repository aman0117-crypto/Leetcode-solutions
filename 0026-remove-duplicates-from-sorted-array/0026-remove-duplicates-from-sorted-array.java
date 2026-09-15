class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        int j=i+1;
        while(j<nums.length){
            if(nums[j]==nums[i]){
                j++;
            }
            else{
                i++;
                nums[i]=nums[j];
                j++;
            }
        }
        return i+1;
    }
}