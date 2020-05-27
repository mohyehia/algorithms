package com.mohyehia.algo.slidingwindow;

public class SubArrays {
    public static void main(String[] args) {
//        int[] a = {4, 2, 1, 7, 8, 1, 2, 8, 1, 0};
        int[] a = {4, 2, 2, 7, 8, 1, 2, 8, 1, 0};
        System.out.println(smallestSubArraySum(a, 11));
    }
    /*
    Find the maximum contiguous subArray with fixed size k
    ex => [4, 2, 1, 7, 8, 1, 2, 8, 1, 0]
    ans => 16
     */
    static int maxFixedSizeSubArray(int[] a, int k){
        int curr = 0;
        for(int i = 0; i < k; i++) curr += a[i];
        int max = curr;
        for(int i = k; i < a.length; i++){
            curr += a[i];
            curr -= a[i - k];
            max = Math.max(max, curr);
        }
        return max;
//        int curr = 0, max = Integer.MIN_VALUE;
//        for(int i = 0; i < a.length; i++){
//            curr += a[i];
//            if(i >= k){
//                curr -= a[i - k];
//                max = Math.max(max, curr);
//            }
//        }
//        return max;
    }
    /*
    [4, 2, 2, 7, 8, 1, 2, 8, 1, 0], target = 8
     */
    static int smallestSubArraySum(int[] a, int target){
        int ans = a.length;
        int sum = a[0], l = 1;
        for(int i = 1; i < a.length; i++){
            if(sum >= target){
                ans = Math.min(ans, l);
                if(ans == 1) return ans;
                sum -= a[i - l];
                l--;
            }else {
                sum += a[i];
                l++;
            }
        }
        return ans;
    }

    /*
    Given an array consisting of n integers, find the contiguous subarray of given length k
     that has the maximum average value. And you need to output the maximum average value.
     */
    static double findMaxAverage(int[] a, int k){
        int sum = 0;
        for(int i = 0; i < k; i++) sum += a[i];
        int max = sum;
        for(int i = k; i < a.length; i++){
            sum -= a[i - k];
            sum += a[i];
            max = Math.max(max, sum);
        }
        return max * 1.0 / k;
    }
}
