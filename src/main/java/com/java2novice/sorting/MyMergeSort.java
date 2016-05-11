/**
 * Created by <a href="davidsunjie.sun@gmail.com">jerrysun</a> on 5/9/16.
 */
package com.java2novice.sorting;

public class MyMergeSort {

    private int[] array;
    private int[] tempMergArr;
    private int length;

    public static void main(String a[]){

        int[] inputArr = {45,23,11,89,77,98,4,28,65,489,27,18,7,218};
        MyMergeSort mms = new MyMergeSort();
        mms.sort(inputArr);
        for(int i:inputArr){
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public void sort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }

    private void doMergeSort(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            System.out.print("the midindex is" + middle  + "\n");
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    private void mergeParts(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;

        System.out.print("the j is" + j + "\n");
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k++] = tempMergArr[i++];

            } else {
                array[k++] = tempMergArr[j++];

            }
        }
        System.out.print("the  s i is" + i + "\n");

        while (i <= middle) {
            System.out.print("the tempMergArr[i] is" + tempMergArr[i] + "\n");
            System.out.print("the k is" + k + "\n");
            array[k++] = tempMergArr[i++];

        }

        while (j <= higherIndex) {
            array[k++] = tempMergArr[j++];
        }


    }
}
