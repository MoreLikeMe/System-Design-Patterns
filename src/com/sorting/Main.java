package com.sorting;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{7,4,9,12,5,4};
        Quicksort quicksort = new Quicksort();
        quicksort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}