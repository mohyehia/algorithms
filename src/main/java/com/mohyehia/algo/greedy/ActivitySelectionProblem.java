package com.mohyehia.algo.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by mohammed
 * Date: 7/20/20
 * Time: 10:42 PM
 */
public class ActivitySelectionProblem {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] finish = {2, 4, 6, 7, 9, 9};
        printMaxActivities(start, finish);
    }

    private static void printMaxActivities(int[] start, int[] finish) {
        int n = start.length;
        Activity[] activities = new Activity[n];
        for(int i = 0; i < n; i++)
            activities[i] = new Activity(start[i], finish[i]);
        // sort activities based on the finish time
        Arrays.sort(activities, Comparator.comparingInt(a -> a.finish));
        System.out.println(activities[0].start + ", " + activities[0].finish);
        int index = 0;
        for(int i = 1; i < n; i++){
            if(activities[i].start >= activities[index].finish){
                System.out.println(activities[i].start + ", " + activities[i].finish);
                index = i;
            }
        }
    }

    static class Activity{
        int start, finish;

        Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
}