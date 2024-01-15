package Exam_26_June_2021;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OSPlanning {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //first line, you will be given some tasks as integer values, separated by a comma and space ", "
        List<Integer> tasks = Arrays.stream(input.nextLine().split(",\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());
        Collections.reverse(tasks);
        //second line, you will be given some threads as integer values, separated by a single space " "
        List<Integer> threads = Arrays.stream(input.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());
        //third line, you will receive the integer value of a task that you need to kill
        //program stops when receive that task value
        int kill = Integer.parseInt(input.nextLine());
        //first given thread value and the last given task value.
        //If the thread value is greater than or equal to the task value, the task and thread get removed.
        //If the thread value is less than the task value, the thread gets removed, but the task remains.
        boolean killed = false;
        while (!killed) {
            int task = tasks.get(0);
            int thread = threads.get(0);
            if (task == kill) {
                killed = true;
            } else if (thread >= task) {
                tasks.remove(Integer.valueOf(task));
                threads.remove(Integer.valueOf(thread));
            } else {
                threads.remove(Integer.valueOf(thread));
            }
        }
        System.out.printf("Thread with value %d killed task %d%n", threads.get(0), tasks.get(0));
        threads.forEach(e -> System.out.printf("%d ", e));
    }
}
