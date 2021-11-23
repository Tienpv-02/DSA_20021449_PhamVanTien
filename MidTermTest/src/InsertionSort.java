import java.util.Scanner;

public class InsertionSort {
  private static void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }

  public static void insertionSort(int[] a) {
    int N = a.length;
    for (int i = 1; i < N-1; i++) {
      for (int j = i; j > 1; j--) {
        if (a[j] < a[j - 1]) {
          swap(a, j, j-1);
        } else {
          break;
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    insertionSort(a);
    for (int i = 0; i < n; i++) {
      System.out.print(a[i] + " ");
    }
  }
}