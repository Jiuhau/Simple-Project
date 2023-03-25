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
        int gap = 1; //gap为1时插入排序 不为1时稍作修改则为希尔排序
        //遍历右侧全部
        for (int i = 0 + gap; i < arr.length; i = i + gap) {
            //降序 当前元素和前一个对比
            if (arr[i - gap] > arr[i]) {
                int j;
                int temp = arr[i];
                for (j = i - gap; j >= 0 && arr[j] > temp; j = j - gap) {
                    //System.out.println(">>i:" + i + ",j:" + j + ",temp:" + temp);
                    //前一个赋值给后一个
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = temp;
                System.out.println("排序中>>" + JSON.toJSONString(arr));
            }
        }

    }
}
