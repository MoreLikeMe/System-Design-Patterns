package com.sorting;

import java.util.Random;

public class Quicksort {
    public void sort(int[] arr){
        int left = 0, right = arr.length-1;
        quickSort(arr, left, right);
    }

    private void quickSort(int[] arr, int left, int right) {
        if(left<right){
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex-1);
            quickSort(arr, partitionIndex+1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        //choice of pivot
        //int pivot = right; //right most as pivot
        //int pivot = median(arr, left, right); //median of left right or mid as pivot
        int pivot = rand(left, right); //random as pivot

        swap(arr, pivot, right);
        pivot = right;

        int lowerBoundary = left-1;
        for(int index = left; index<right; index++){
            if(arr[index]<arr[pivot]){
                lowerBoundary++;
                swap(arr, lowerBoundary, index);
            }
        }
        swap(arr, lowerBoundary+1, pivot);
        return lowerBoundary+1;
    }

    private void swap(int[] arr, int ind1, int ind2) {
        int temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
    }

    private int median(int[] arr, int left, int right) {
        int mid = left + (right-left)/2;
        if((arr[left]<=arr[right] && arr[mid]<=arr[left])
            || (arr[left]<=arr[mid] && arr[right]<=arr[left])){
            return left;
        }
        else if((arr[mid]<=arr[right] && arr[left]<=arr[mid])
            || (arr[mid]<=arr[left] && arr[right]<=arr[mid])){
            return mid;
        }
        else if((arr[right]<=arr[left] && arr[mid]<=arr[right])
            || (arr[right]<=arr[mid] && arr[left]<=arr[right])){
            return right;
        }
        return -1;
    }

    private int rand(int left, int right) {
        Random rand = new Random();
        int r = rand.nextInt(right-left);
        return r+left;
    }
}
