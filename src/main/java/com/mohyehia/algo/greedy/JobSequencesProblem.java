package com.mohyehia.algo.greedy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by mohammed
 * Date: 8/2/20
 * Time: 4:27 PM
 */
public class JobSequencesProblem {
    public static void main(String[] args) {
        Job[] jobs = {
                new Job(1, 9, 15), new Job(2, 2, 2),
                new Job(3, 5, 18), new Job(4, 7, 1),
                new Job(5, 4, 25), new Job(6, 2, 20),
                new Job(7, 5, 8), new Job(8, 7, 10),
                new Job(9, 4, 12), new Job(10, 3, 5)
        };
        int max = 15;
        System.out.println("Total profit is =>" + scheduleJobs(jobs, max));
    }
    /*
    Time complexity => O(N^2)
     */
    static int scheduleJobs(Job[] jobs, int max){
        // sort jobs in decreasing order of their profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        int profit = 0;
        // array to store the used & unused slots info
        int[] slot = new int[max];
        Arrays.fill(slot, -1);
        for(Job job : jobs){
            // search for the next free slot & map the job to that slot
            for(int i = job.deadline - 1; i >= 0; i--){
                if(i < max && slot[i] == -1){
                    slot[i] = job.id;
                    profit += job.profit;
                    break;
                }
            }
        }
        System.out.println("The scheduled jobs are => ");
        System.out.println(Arrays.stream(slot).filter(val -> val != -1).boxed().collect(Collectors.toList()));
        return profit;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Job{
        int id, deadline, profit;
    }
}
