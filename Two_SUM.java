import java.util.Map;
import java.util.HashMap;
/* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order. */

/* Test Cases
Basic Case:
Input: nums = [2, 7, 11, 15], target = 9
Output: Indices [0, 1]

No Solution Exists:
Input: nums = [1, 2, 3, 4], target = 8
Output: No solution

Multiple Solutions:
Input: nums = [3, 3, 4, 2], target = 6
Output: Indices [0, 1] or [1, 0]

Negative Numbers:
Input: nums = [-1, -2, -3, -4, -5], target = -8
Output: Indices [2, 4]

Duplicate Numbers:
Input: nums = [1, 2, 3, 2, 4], target = 4
Output: Indices [0, 3] or [1, 2]

Minimum Input Size:
Input: nums = [1, 2], target = 3
Output: Indices [0, 1]

Large Numbers:
Input: nums = [1000000, 500000, -1500000], target = -1000000
Output: Indices [1, 2]

Zero Target:
Input: nums = [0, 4, 3, 0], target = 0
Output: Indices [0, 3]

Empty Array:
Input: nums = [], target = 5
Output: No solution

Single Element Array:
Input: nums = [1], target = 1
Output: No solution 

TLE Test Case
Input: nums = [1, 2, 3, 4, ..., 10^6], target = 2 * 10^6 + 1
Output: No solution
*/

// 

class Two_SUM {

    // Naive Approach
    private static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {}; 
    }

    // HashMap Approach
    private static int[] twoSumOpt(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {}; 
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSumOpt(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        
        int[] nums2 = {2, 7, 11, 15};
        int target2 = 9;
        int[] result2 = twoSum(nums2, target2);
        System.out.println("Indices: [" + result2[0] + ", " + result2[1] + "]");
    }
}