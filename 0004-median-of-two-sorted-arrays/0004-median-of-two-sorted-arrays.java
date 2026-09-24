//Brute Force 
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int totalNums = m+n; 
        int [] arr=new int[totalNums];
        for(int i=0;i<m;i++){
            arr[i]=nums1[i];
        }
        for(int i=0;i<n;i++){
            arr[m]=nums2[i];
            m++;
        }
        Arrays.sort(arr);
        if(arr.length%2==0){
            int index=arr.length/2;
            return ((double)(arr[index]+arr[index-1])/2);
        }
        return arr[arr.length/2];
    }
}