package com.practise.algroithm.dynamic;

import java.util.Scanner;

/**
 * @Description 计算一个整数组a的最长递增子序列长度的方法描述如下：
 * 假设数组a的长度为n，用数组b的元素b[i] 记录以a[i](0<=i<n) 为结尾元素的最长递增序列的长度，则数组a的最长递增子序列的长度为
 * max{b[i]}(0<=i<n) ; 其中b[i] 满足最有子结构，可递归定义为 b[0]=1,b[i]=max{b[k]}+1(0<=k<=i,a[k]<=a[i])
 * @Author MCC
 * @Date 2020/4/16 11:21
 * @Version 1.0
 **/
public class dynamic1 {

    public static int max(int[] b, int n) {
        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (b[i] > temp) {
                temp = b[i];
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int i, j, len;
        int n = 6;
        int[] a = new int[]{3, 10, 5, 15, 6, 8};
        int[] b = new int[100];
        //todo
        b[0] = 1;

        for (i = 0; i < n; i++) {

            for (j = 0, len = 0; j < i; j++) {
                //todo len < b[j] &&
                if (len < b[j] && a[j] <= a[i]) {
                    len = b[j];
                }
                //todo
                b[j+1] = len + 1;
            }
        }
        System.out.println(max(b, n));
        for (int c = 0;c<b.length;c++){
            System.out.print(b[c]+" ");
        }

    }


}
