package Sorting;

import java.util.Scanner;


public class Main_no3 {

    public static void main(String[] args) {
        SortingNumb sn = new SortingNumb();
        int an[] = new int[100];
        for (int i = 0; i < an.length; i++) {
            an[i] = i; 
        }
        sn.selectionSort(an);
        sn.bubbleSort(an);
    }
}
