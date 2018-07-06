package com.nz.springbootlearning.leetcode;

import java.util.HashMap;

/**
 * @ Author     ：nz.
 * @ Date       ：Created in 下午 4:47 18/7/5
 * @ Description：给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。  你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 给定 nums = [2, 7, 11, 15], target = 9  因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
 * @ Modified By：
 * @Version: $
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length;j++){
                sum =  nums[i] + nums[j];
                if (sum == target){
                    return  new int[]{nums[i], nums[j]};
                }
            }
           /* if (nums[i] > target) {
                continue;
            }
            if (2 * nums[i] == target) {

                return new int[]{nums[i]};
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > target) {
                    continue;
                }
                sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[]{nums[i], nums[j]};
                }
            }*/
        }

        return  null;
    }

    public int[] twoSum2(int[] nums, int target){
        HashMap<Integer, Integer> HashMap = new HashMap<>();
        for (int i =0;i<nums.length;i++){
           int j = target - nums[i];
           if (HashMap.containsKey(j)){
               return new int[]{HashMap.get(j),i};
           }
           HashMap.put(nums[i], i);
        }
        throw new IllegalArgumentException();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] ints = solution.twoSum(new int[]{-2, -3, -1, 11,23,4}, 22);
//        if (ints == null){
//            System.out.println("不存在");
//        }
//        for (int a : ints){
//            System.out.println(a);
//        }
        int[] ints = solution.twoSum2(new int[]{4,2,13,123}, 17);
        for (int a : ints){
            System.out.println(a);
        }
    }
}
