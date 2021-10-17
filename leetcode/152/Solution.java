// Maximum Product Subarray
class Solution {
    public int maxProduct(int[] nums) {
        int maxResult = nums[0];
        for(int i = 0; i < nums.length; i++) {
            int currProduct = 1;
            for(int j = 0; i + j < nums.length; j++) {
                currProduct *= nums[i+j];
                if(currProduct > maxResult) {
                    maxResult = currProduct;
                }
                if(currProduct == 0) {
                    break;
                }
            }
        }
        return maxResult;
    }
}
/**
Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
It is guaranteed that the answer will fit in a 32-bit integer.
A subarray is a contiguous subsequence of the array.

Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

Constraints:
1 <= nums.length <= 2 * 10^4
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
*/
