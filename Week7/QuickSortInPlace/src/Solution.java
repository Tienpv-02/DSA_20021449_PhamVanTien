
import java.util.*;

public class Solution {

  public static void printArr(int[] arr) {
    for(int x: arr) {
      System.out.print(x + " ");
    }
    System.out.println();
  }

  public static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  protected static int partition(int[] arr, int lo, int  hi) {
    if (lo >= hi) {
      return lo;
    }
    int p = arr[hi];
    int i = lo;
    for(int j = lo; j <= hi - 1; j++) {
      if (arr[j] <= p) {
        swap(arr, i, j);
        i++;
      }
    }
    swap(arr, i, hi);
    printArr(arr);
    return i;
  }

  public static void quickSort(int[] arr, int lo, int hi) {
    if (lo < hi) {
      int p = partition(arr, lo, hi);
      quickSort(arr, lo, p - 1);
      quickSort(arr, p + 1, hi);
    }

  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }
    quickSort(arr, 0, n - 1);
  }
}
