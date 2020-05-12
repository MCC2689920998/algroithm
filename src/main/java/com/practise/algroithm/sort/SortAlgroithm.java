package com.practise.algroithm.sort;

import com.google.common.collect.Lists;
import org.junit.Ignore;
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


    @Test
    @Ignore
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
    @Ignore
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


    @Test
    public void 直接选择排序StraightSelectSort() {
        Integer[] a = roundIntArr();
        System.out.println("——直接选择排序———");
        for (int i = 1; i < a.length; i++) {
            int temp = a[i - 1];
            for (int j = i; j < a.length; j++) {
                if (temp > a[j]) {
                    a[i - 1] = a[j];
                    a[j] = temp;
                    temp = a[i - 1];
                }
            }
            printResult(a);
        }
        printResult(a);
    }


    /**
     * 构建堆 o(n)
     * 有问题
     */
    @Test
    public void 堆排序HeapSort() {
        Integer[] a = roundIntArr();
        System.out.println("——堆排序HeapSort———");
        a = buildMaxHeap(a);
        System.out.println("——构建大顶堆———");
        printResult(a);
        System.out.println("——顶堆排序———");
        for (int i = a.length - 1; i > 0; i--) {
            //将堆顶元素和堆低元素交换，即得到当前最大元素正确的排序位置
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
//            System.out.println("——第"+i+"次———");
            //整理，将剩余的元素整理成堆
            for (int j = i / 2; j >= 0; j--) {
                adjustDownToUp(a, j, i);
//            printResult(array);
            }
//            System.out.println("——第"+i+"次顶堆排序———");
            printResult(a);

        }
        printResult(a);
    }

    /**
     * 构建大根堆：将array看成完全二叉树的顺序存储结构
     */
    private Integer[] buildMaxHeap(Integer[] array) {
        //从最后一个节点array.length-1的父节点（array.length-1-1）/2开始，直到根节点0，反复调整堆
        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            adjustDownToUp(array, i, array.length);
//            printResult(array);
        }
        return array;
    }

    /**
     * 将元素array[k]自下往上逐步调整树形结构
     *
     * @param array
     * @param k
     * @param length
     */
    private void adjustDownToUp(Integer[] array, int k, int length) {
        int temp = array[k];
        //i为初始化为节点k的左孩子，沿节点较大的子节点向下调整
        for (int i = 2 * k; i < length - 1; i = 2 * i + 1) {
            //取节点较大的子节点的下标
            if (i < length && array[i] < array[i + 1]) {
                //如果节点的右孩子>左孩子，则取右孩子节点的下标
                i++;
            }
            //根节点 >=左右子女中关键字较大者，调整结束
            if (temp >= array[i]) {
                break;
            } else {//根节点 <左右子女中关键字较大者
                //将左右子结点中较大值array[i]调整到双亲节点上
                array[k] = array[i];
                //【关键】修改k值，以便继续向下调整
                k = i;
            }
        }
        //被调整的结点的值放人最终位置
        array[k] = temp;
    }


    private void printResult(Integer[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();
    }


    public static Integer[] roundIntArr() {
        List<Integer> temp = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            int a = (int) (Math.random() * 100);
            temp.add(a);
        }
        Integer[] a = new Integer[temp.size()];
        a = temp.toArray(a);
        a = new Integer[]{56,11,19,83,60,77,22,11,90,63};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();
        return a;
    }


    @Test
    public void 位移操作() {
        System.out.println(2 << 1);
        System.out.println(2 << 2);
        System.out.println(8 << 1);
        System.out.println(8 << 2);


    }


}
