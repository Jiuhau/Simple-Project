package com.example.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int arr[] = new int[]{2, 3, 5, 9, 6, 4, 1, 7};
        System.out.println("原顺序:" + JSON.toJSONString(arr));
        insert(arr);
        System.out.println("排序后:" + JSON.toJSONString(arr));
    }

    public static void insert(int[] arr) {
        //遍历右侧全部
        for (int i = 1; i < arr.length; i++) {
            //降序 当前元素和前一个对比
            if (arr[i - 1] > arr[i]) {
                int j;
                int temp = arr[i];
                for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                    System.out.println(">>i:" + i + ",j:" + j + ",temp:" + temp);
                    //前一个赋值给后一个
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = temp;
                System.out.println("排序中>>" + JSON.toJSONString(arr));
            }
        }

    }
}
