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
public class SortAlgorithmTest {

    private static int ARR_LENGTH = 10;
    private static Integer [] arr = new Integer[]{15,27,46,40,64,85};
//    private static Integer[] arr = new Integer[]{90, 80, 45, 38, 30, 25};

    @Test
    @Ignore
    public void 直接插入排序InsertSort() {
        Integer[] a = roundIntArr();
        int count = 0;
        System.out.println("——直接插入排序算法———");
        int i, j;
        for (i = 1; i < a.length; i++) {
            int temp = a[i];
            for (j = i - 1; j >= 0 && a[j] > temp; j--) {
                count++;
                a[j + 1] = a[j];
            }
            a[j + 1] = temp;
            System.out.print("第" + i + "次:");
            printResult(a);
        }
        System.out.print("结果：");
        printResult(a);
        System.out.println("count：" + count);

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
    @Ignore
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
            System.out.print("第" + i + "次:");
            printResult(a);
        }
        System.out.print("结果：");
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


    @Test
    public void 冒泡排序BubbleSort() {
        Integer[] a = roundIntArr();
        System.out.println("——冒泡排序BubbleSort———");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        printResult(a);
    }


    @Test
    public void 快速排序QuickSort() {
        Integer[] a = roundIntArr();
        System.out.println("——快速排序QuickSort———");
        sort(a, 0, a.length - 1);
        System.out.println("——结果———");
        printResult(a);
    }

    /**
     * 快排核心算法，递归实现
     *
     * @param array
     * @param left
     * @param right
     */
    public void sort(Integer[] array, int left, int right) {
        if (left > right) {
            return;
        }
        // base中存放基准数
        int base = array[left];
        int i = left, j = right;
        while (i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while (array[j] >= base && i < j) {
                j--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while (array[i] <= base && i < j) {
                i++;
            }

            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if (i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        sort(array, left, i - 1);
        System.out.println("——左过程———");
        printResult(array);
        sort(array, i + 1, right);
        System.out.println("——右过程———");
        printResult(array);
    }

    @Test
    public void 归并排序MergeSort() {
        Integer[] a = roundIntArr();
        System.out.println("——归并排序MergeSort———");
        MergeSort1(a, 0, a.length - 1);
        System.out.println("——结果———");
        printResult(a);
    }

    private void MergeSort1(Integer[] a, int left, int right) {
        int mid = (left + right) / 2;
        if (left < right) {
            MergeSort1(a, left, mid);
            System.out.println("——左过程———");
            printResult(a);

            MergeSort1(a, mid + 1, right);
            System.out.println("——右过程———");
            printResult(a);

            //左右归并
            MergeSort(a, left, mid, right);
            System.out.println("——左右归并———");
            printResult(a);
        }
    }


    public void MergeSort(Integer[] a, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= right) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= right) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int x = 0; x < temp.length; x++) {
            a[x + left] = temp[x];
        }
    }


    @Test
    public void 基数排序RadixSort() {
        Integer[] a = roundIntArr();
        System.out.println("——基数排序RadixSort———");
        radixSort(a);
        System.out.println("——结果———");
        printResult(a);

    }

    /*
     * 基数排序
     *
     * 参数说明：
     *     a -- 数组
     */
    public static void radixSort(Integer[] a) {
        int exp;    // 指数。当对数组按各位进行排序时，exp=1；按十位进行排序时，exp=10；...
        int max = getMax(a);    // 数组a中的最大值
        // 从个位开始，对数组a按"指数"进行排序
        for (exp = 1; max / exp > 0; exp *= 10) {
            countSort(a, exp);
        }
    }

    private static int getMax(Integer[] a) {
        int max;
        max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    /*
     * 对数组按照"某个位数"进行排序(桶排序)
     *
     * 参数说明：
     *     a -- 数组
     *     exp -- 指数。对数组a按照该指数进行排序。
     *
     * 例如，对于数组a={50, 3, 542, 745, 2014, 154, 63, 616}；
     *    (01) 当exp=1表示按照"个位"对数组a进行排序
     *    (02) 当exp=10表示按照"十位"对数组a进行排序
     *    (03) 当exp=100表示按照"百位"对数组a进行排序
     *    ...
     */
    private static void countSort(Integer[] a, int exp) {
        //int output[a.length];    // 存储"被排序数据"的临时数组
        int[] output = new int[a.length];    // 存储"被排序数据"的临时数组
        int[] buckets = new int[10];
        // 将数据出现的次数存储在buckets[]中
        for (int i = 0; i < a.length; i++) {
            buckets[(a[i] / exp) % 10]++;
        }
        // 更改buckets[i]。目的是让更改后的buckets[i]的值，是该数据在output[]中的位置。
        for (int i = 1; i < 10; i++) {
            buckets[i] += buckets[i - 1];
        }

        // 将数据存储到临时数组output[]中
        for (int i = a.length - 1; i >= 0; i--) {
            output[buckets[(a[i] / exp) % 10] - 1] = a[i];
            buckets[(a[i] / exp) % 10]--;
        }
        // 将排序好的数据赋值给a[]
        for (int i = 0; i < a.length; i++) {
            a[i] = output[i];
        }
        output = null;
        buckets = null;
    }


    private void printResult(Integer[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();
    }


    @Test
    public void 位移操作() {
        System.out.println(2 << 1);
        System.out.println(2 << 2);
        System.out.println(8 << 1);
        System.out.println(8 << 2);


    }

    public static Integer[] roundIntArr() {
        List<Integer> temp = Lists.newArrayList();

        if (arr.length > 0) {
            return arr;
        }
        for (int i = 0; i < ARR_LENGTH; i++) {
            int a = (int) (Math.random() * 100);
            temp.add(a);
        }
        Integer[] a = new Integer[temp.size()];
        a = temp.toArray(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();
        return a;
    }


}
