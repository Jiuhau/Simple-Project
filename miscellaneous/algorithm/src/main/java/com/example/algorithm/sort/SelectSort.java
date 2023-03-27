package com.example.algorithm.sort;

import com.alibaba.fastjson.JSON;

public class SelectSort {
    public static void main(String[] args) {
        int arr[] = new int[]{2, 3, 5, 9, 6, 4, 1, 7};
        System.out.println("原顺序:" + JSON.toJSONString(arr));
        select(arr);
        System.out.println("排序后:" + JSON.toJSONString(arr));
    }

    public static void select(int[] arr) {
        //遍历所有元素
        for (int i = 0; i < arr.length; i++) {
            //倒序 找出最大的下标
            int maxIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            //maxIndex和当前下标不一致 则交换
            if (maxIndex != i) {
                int temp = arr[maxIndex];
                arr[maxIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
