package com.example.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 3, 5, 7, 6, 4, 2, 9};
        System.out.println("原顺序:" + JSON.toJSONString(arr));
        bubble(arr);
        System.out.println("排序后:" + JSON.toJSONString(arr));

    }

    public static void bubble(int arr[]) {
        /**
         * 时间复杂度
         * n + n-1 + n-2 + n-3 + …… + 2 + 1 等差数列
         * 公差d=-1 通项公式an=a1+(n-1)d 前n项和公式Sn=a1*n+n(n-1)d/2=n(a1+an)/2
         * a1=n an=n-(n-1)=1 Sn=n(n+1)/2
         * On=n²
         * 是否稳定：是
         */
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //降序
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }
}
