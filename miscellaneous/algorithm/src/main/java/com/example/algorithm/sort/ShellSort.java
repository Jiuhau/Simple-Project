package com.example.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int arr[] = new int[]{2, 3, 5, 9, 6, 4, 1, 7};
        System.out.println("原顺序:" + JSON.toJSONString(arr));
        shell(arr);
        System.out.println("排序后:" + JSON.toJSONString(arr));
    }

    public static void shell(int[] arr) {
        //gap为步长 每次减为原来的一半
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            //对每一组都执行插入排序
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < arr.length; j = j + gap) {
                    if (arr[j - gap] > arr[j]) {
                        int k;
                        int temp = arr[j];
                        for (k = j - gap; k >= 0 && arr[k] > temp; k = k - gap) {
                            arr[k + gap] = arr[k];
                        }
                        arr[k + gap] = temp;
                    }
                }
            }
        }
    }
}
