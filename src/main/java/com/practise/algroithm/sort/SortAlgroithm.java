package com.practise.algroithm.sort;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * @Description
 * @Author MCC
 * @Date 2020/5/9 9:48
 * @Version 1.0
 **/
public class SortAlgroithm {

    public static Integer[] roundIntArr() {
        List<Integer> temp = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            int a = (int) (Math.random() * 100);
            temp.add(a);
        }
        Integer[] a = new Integer[temp.size()];
        a = temp.toArray(a);
        a = new Integer[]{99, 89, 90, 78, 28, 28, 79, 72, 36, 65};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();
        return a;
    }

    @Test
    public void 直接插入排序InsertSort() {
        Integer[] a = roundIntArr();
        System.out.println("——直接插入排序算法———");
        int i, j;
        for (i = 1; i < a.length; i++) {
            int temp = a[i];
            for (j = i - 1; j >= 0 && a[j] > temp; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = temp;
            printResult(a);
        }
        printResult(a);
    }


    @Test
    public void 希尔排序ShellSort() {
        Integer[] a = roundIntArr();
        System.out.println("——希尔排序算法———");
        int j = 0;
//        int temp = 0;
        for (int increment = a.length / 2; increment > 0; increment /= 2) {
            System.out.println("increment:" + increment);
            for (int i = increment; i < a.length; i++) {
//                 System.out.println("i:" + i);
                int temp = a[i];
                for (j = i - increment; j >= 0; j -= increment) {
//                     System.out.println("j:" + j);
//                     System.out.println("temp:" + temp);
//                     System.out.println("data[" + j + "]:" + a[j]);
                    if (temp < a[j]) {
                        a[j + increment] = a[j];
                    } else {
                        break;
                    }
                }
                a[j + increment] = temp;
                printResult(a);
            }
//           printResult(a);
        }
        printResult(a);
    }













    private void printResult(Integer[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();
    }

}
