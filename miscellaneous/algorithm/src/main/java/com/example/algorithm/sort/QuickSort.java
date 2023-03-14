package com.example.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 3, 5, 7, 6, 4, 2, 9};
        System.out.println("原顺序:" + JSON.toJSONString(arr));
        quick(arr, 0, arr.length);
        System.out.println("排序后:" + JSON.toJSONString(arr));
    }

    public static void quick(int[] arr, int start, int end) {
        if (start < end) {
            int base = arr[start];
            int left = start;
            int right = end;
            /*降序*/
            //左边
            while (start < end) {
                while (start < end && base < arr[start]) {

                }
            }
            arr[start] = base;

        }
    }
}
