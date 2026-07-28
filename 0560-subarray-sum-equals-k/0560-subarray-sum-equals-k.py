class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        freq={}
        freq[0]=1
        prefix=0
        count=0
        for x in nums:
            prefix=prefix+x
            target=prefix-k
            if target in freq:
                count=count+freq[target]      
            if prefix in freq:
                freq[prefix]=freq[prefix]+1
            else:
                freq[prefix]=1
        return count  
        