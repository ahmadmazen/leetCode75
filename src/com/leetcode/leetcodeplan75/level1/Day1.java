package com.leetcode.leetcodeplan75.level1;

public class Day1 {
    /*
    Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
    Return the running sum of nums.
     */
    public int[] runningSum(int[] nums) {
        int arrayLength = nums.length;
        int[] result = new int[arrayLength];

        if(nums == null || arrayLength == 0 ){
            return null;
        }
        int pointer = 0;
        int previousSum = 0;
        while(pointer < arrayLength){
            result[pointer] = nums[pointer] + previousSum;
            previousSum = nums[pointer] + previousSum;
            pointer++;
        }
      return result;
    }

    public static void main(String[] args) {

    }
}
