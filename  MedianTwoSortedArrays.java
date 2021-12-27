// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
// Example 1:

// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.
// Example 2:

// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

// Constraints:

// nums1.length == m
// nums2.length == n
// 0 <= m <= 1000
// 0 <= n <= 1000
// 1 <= m + n <= 2000
// -106 <= nums1[i], nums2[i] <= 106

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> combineSortedLists(int[] nums1, int[] nums2) {
        int nums1Size = nums1.length;
        int nums2Size = nums2.length;
        List<Integer> nums = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1Size || j < nums2Size) {
            if (j >= nums2Size) {
                for (int k = i; k < nums1Size; k++) {
                    nums.add(nums1[k]);
                }
                break;
            }
            if (i >= nums1Size) {
                for (int k = j; k < nums2Size; k++) {
                    nums.add(nums2[k]);
                }
                break;
            }
            if (nums1[i] < nums2[j]) {
                nums.add(nums1[i]);
                i = i + 1;
            } else if (nums1[i] >= nums2[j]) {
                nums.add(nums2[j]);
                j = j + 1;
            }
        }
        return nums;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> nums = combineSortedLists(nums1, nums2);
        int size = nums.size();
        return (size % 2 != 0)
                ? nums.get(size / 2)
                : ((nums.get(size / 2) + nums.get((size / 2) - 1)) / 2.0);
    }
}