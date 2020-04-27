package com.mohyehia.algo.db;

/**
 * Created by Mohamed.Yehia
 * Date: 4/19/2020
 * Time: 8:02 AM
 */
public class MaximumSubArray {
    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArr(a));
        System.out.println(maximumSubArray(a));
        System.out.println(maxSubArray(a));
    }

    /*
    Kadane's Algorithm => O(N)
     */
    static int maxSubArr(int[] a){
        /*
          We default to say the the best maximum seen so far is the first
          element.
          We also default to say the the best max ending at the first element
          is...the first element.
        */
        int len = a.length, maxEndingHere = a[0], maxSoFar = a[0];
        /*
          We will investigate the rest of the items in the array from index
          1 onward.
        */
        for(int i = 1; i < len; i++){
            /*
            We are inspecting the item at index i.
            We want to answer the question:
            "What is the Max Contiguous Subarray Sum we can achieve ending at index i?"
            We have 2 choices:
            maxEndingHere + nums[i] (extend the previous subarray best whatever it was)
              1.) Let the item we are sitting at contribute to this best max we achieved
              ending at index i - 1.
            nums[i] (start and end at this index)
              2.) Just take the item we are sitting at's value.
            The max of these 2 choices will be the best answer to the Max Contiguous
            Subarray Sum we can achieve for subarrays ending at index i.
            Example:
            index     0  1   2  3   4  5  6   7  8
            Input: [ -2, 1, -3, 4, -1, 2, 1, -5, 4 ]
                     -2, 1, -2, 4,  3, 5, 6,  1, 5    'maxEndingHere' at each point

            The best subarrays we would take if we took them:
              ending at index 0: [ -2 ]           (snippet from index 0 to index 0)
              ending at index 1: [ 1 ]            (snippet from index 1 to index 1) [we just took the item at index 1]
              ending at index 2: [ 1, -3 ]        (snippet from index 1 to index 2)
              ending at index 3: [ 4 ]            (snippet from index 3 to index 3) [we just took the item at index 3]
              ending at index 4: [ 4, -1 ]        (snippet from index 3 to index 4)
              ending at index 5: [ 4, -1, 2 ]     (snippet from index 3 to index 5)
              ending at index 6: [ 4, -1, 2, 1 ]  (snippet from index 3 to index 6)
              ending at index 7: [ 4, -1, 2, 1, -5 ]    (snippet from index 3 to index 7)
              ending at index 8: [ 4, -1, 2, 1, -5, 4 ] (snippet from index 3 to index 8)
            Notice how we are changing the end bound by 1 everytime.
          */
            maxEndingHere = Math.max(a[i], maxEndingHere + a[i]);
            // Did we beat the 'maxSoFar' with the 'maxEndingHere'?
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
    /*
    Quadratic time => O(N^2)
     */
    static int maximumSubArray(int[] a){
        int len = a.length, max = Integer.MIN_VALUE, tempSum;
        for(int i = 0; i < len; i++){
            tempSum = 0;
            for(int j = i; j < len; j++){
                tempSum += a[j];
                max = Math.max(max, tempSum);
            }
        }
        return max;
    }

    /*
    Cubic time => O(N^3)
     */
    static int maxSubArray(int[] nums){
        int len = nums.length, max = Integer.MIN_VALUE;

        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                int tempSum = 0;
                for(int k = i; k <= j; k++)
                    tempSum += nums[k];
                max = Math.max(max, tempSum);
            }
        }
        return max;
    }
}
