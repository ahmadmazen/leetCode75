package com.leetcode.leetcodeplan75.level1;

public class Day1 {
    /*
    Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
    Return the running sum of nums.
     */
    public int[] runningSum(int[] nums) {
        int arrayLength = nums.length;
        int[] result = new int[arrayLength];

        if (nums == null || arrayLength == 0) {
            return null;
        }
        int pointer = 0;
        int previousSum = 0;
        while (pointer < arrayLength) {
            result[pointer] = nums[pointer] + previousSum;
            previousSum = nums[pointer] + previousSum;
            pointer++;
        }
        return result;
    }

    /*
    https://leetcode.com/problems/find-pivot-index/
    Input: nums = [1,7,3,6,5,6]
      Output: 3

      this is the brute force solution since its complexity is high we need to scan the whole array - i (i is the index of the element)
      for each iteration which makes us very clost to O(n*2) time complexity
     */
    public static int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int leftSum = 0;
        for(int i = 0; i < nums.length; i++){
            int pointer = i + 1;
            int rightSum = 0;
            while(pointer < nums.length ){
                 rightSum += nums[pointer];
                 pointer++;
            }
            if(rightSum == leftSum){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
    /*
     this solution is better in complexity, we need to scan the array only once with O(n) time complexity
     and constant space complexity no need to auxiliary space no matter how bigger the input array O(1)
     */
   public static int  pivoIndex_betterSolution(int[] nums){
       if (nums == null || nums.length == 0) {
           return -1;
       }
       int sum = 0;
       for(int val : nums){
           sum+= val;
       }
       int leftSum = 0;
       for(int i = 0; i < nums.length; i++){
           int rightSum = sum - nums[i] - leftSum;
           if(rightSum == leftSum){
               return i;
           }
           leftSum += nums[i];
       }
       return -1;
   }
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
        System.out.println(pivotIndex(new int[]{2,1,-1}));
        System.out.println(pivoIndex_betterSolution(new int[]{1,7,3,6,5,6}));
        System.out.println(pivoIndex_betterSolution(new int[]{2,1,-1}));
    }
}
