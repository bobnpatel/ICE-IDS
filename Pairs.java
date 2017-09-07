package com.ice.ids;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by PooChin on 9/6/2017.
 */
public class Pairs {

    public static void printDistinctPairs(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;

        // first sort the numbers array
        Arrays.sort(numbers);

        // two pointers, one moving left to right and second moving right to left
        // check if the sum of the numbers is equal to target, if yes that is out pair
        while (i <= j) {
            if (numbers[i] + numbers[j] == target) {
                System.out.println(numbers[i]+","+numbers[j]);
                i++;j--;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else { // numbers[i] + numbers[j] > target.
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] A = new int[] {1, 2, 3, 4, 5, 6};
        int target = 7;
        printDistinctPairs(A, target);
    }
}
