class Solution(object):
    def findDuplicate(self, A):
        """
        :type nums: List[int]
        :rtype: int
        """
        n=len(A)
        for i in range(n):
            temp=abs(A[i])
            if A[temp]<0:
                res=temp
                break
            else:
                A[temp]*=-1
        for i in range(n):
            if A[i]<0:
                A[i]*=-1
        return (res)

        