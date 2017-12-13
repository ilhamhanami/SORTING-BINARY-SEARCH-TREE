package Sorting;


public class SortingNumb {

    public static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    public static void bubbleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
        show(a);
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void selectionSort(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        int n = a.length;

        for (int i = n - 1; i > 0; i--) {
            int k = i;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[k]) {
                    k = j;
                }
            }
            swap(a, k, i);
        }
        show(a);
    }

    public static void insertionSort(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        int n = a.length;

        for (int i = 1; i < n; i++) {
            int target = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > target) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = target;
        }
        show(a);
    }

    public static void shellSort(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        int n = a.length;

        int d = n / 2;
        while (d >= 1) {
            shellSort(a, d);
            d /= 2;
        }
    }

    public static void shellSort(int[] a, int d) {
        if (a == null || a.length < 2) {
            return;
        }
        int n = a.length;

        for (int i = d; i < a.length; i++) {
            int target = a[i];
            int j = i - d;
            while (j >= 0 && target < a[j]) {
                a[j + d] = a[j];
                j = j - d;
            }
            if (j != i - d) {
                a[j + d] = target;
            }

        }
    }

    public static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length - 1);
        show(a);
    }

    public static void mergeSort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;

        mergeSort(a, low, mid);
        mergeSort(a, mid + 1, high);
        merge(a, low, mid, high);

    }

    public static void merge(int[] a, int low, int mid, int high) {
        int[] b = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                b[k++] = a[i++];
            } else {//a[j]>=a[i]
                b[k++] = a[j++];
            }
        }
        while (i <= mid) {
            b[k++] = a[i++];
        }
        while (j <= high) {
            b[k++] = a[j++];
        }
        for (int p = 0; p < b.length; p++) {
            a[low + p] = b[p];
        }

    }

    public static void quickSort(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        quickSort(a, 0, a.length - 1);
        show(a);
    }

    public static void quickSort(int[] a, int i, int j) {
        if (i >= j) {
            return;
        }
        int pivotPos = partition(a, i, j);
        quickSort(a, i, pivotPos - 1);
        quickSort(a, pivotPos + 1, j);
    }

    public static int partition(int[] a, int i, int j) {
        int pivot = a[i];
        while (i < j) {
            while (i < j && a[j] >= pivot) {
                j--;
            }
            a[i] = a[j];
            while (i < j && a[i] <= pivot) {
                i++;
            }
            a[j] = a[i];
        }
        a[i] = pivot;
        return i;
    }

    public static void heapAdjust(int[] a, int start, int end) {
        int temp = a[start];
        for (int i = 2 * start + 1; i <= end; i *= 2) {
            if (i < end && a[i] < a[i + 1]) {
                i++;
            }
            if (temp >= a[i]) {
                break;
            }
            a[start] = a[i];
            start = i;
        }
        a[start] = temp;
    }

    

}
