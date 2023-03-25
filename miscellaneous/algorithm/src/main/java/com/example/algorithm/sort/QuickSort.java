package com.example.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int arr[] = new int[]{2, 3, 5, 9, 6, 4, 1, 7};
        System.out.println("原顺序:" + JSON.toJSONString(arr));
        quick(arr, 0, arr.length - 1);
        System.out.println("排序后:" + JSON.toJSONString(arr));
    }

    public static void quick(int[] arr, int start, int end) {
        if (start < end) {
            int base = arr[start];
            int left = start;
            int right = end;
            System.out.println("base:" + base + ",left:" + left + ",right:" + right);
            /*降序*/
            //循环找到比基数大的数和小的数
            while (left < right) {
                //先处理右边 比基数大的交换
                while (left < right && arr[right] <= base) {
                    right--;
                }
                arr[left] = arr[right];
                //再处理左边 比基数小的交换
                while (left < right && arr[left] >= base) {
                    left++;
                }
                arr[right] = arr[left];
            }
            arr[left] = base; //或arr[right] = base;
            //System.out.println("left与right应当一致>>" + "left:" + arr[left] + ",right:" + arr[right]);
            System.out.println("排序中>>" + JSON.toJSONString(arr));
            //排序左边
            quick(arr, start, left);
            //排序右边
            quick(arr, left + 1, end);
        }
    }
}
