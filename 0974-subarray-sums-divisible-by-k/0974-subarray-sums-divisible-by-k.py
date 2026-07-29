class Solution(object):
    def subarraysDivByK(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        freq={ }
        freq[0]=1
        prefix=0
        count=0
        for x in nums:
            prefix=prefix+x
            rem=prefix%k
            if rem in freq:
                count=count+freq[rem]
            if rem in freq:
                freq[rem]=freq[rem]+1
            else:
                freq[rem]=1
        return count
        