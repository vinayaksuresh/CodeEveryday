class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        max = 0
        count = 0
        for i in nums:
            count = count + 1 if (i) else 0
            if count > max:
                max = count
        return max
