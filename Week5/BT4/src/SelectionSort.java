import edu.princeton.cs.algs4.In;

public class SelectionSort {

  public static void SelectionSort(int[] a) {
    for (int i = 0; i < a.length; i++) {
      int index = i;
      for (int j = i; j < a.length; j++) {
          if (a[j] < a[index] ) {
            index = j;
          }
      }
      swap(a,i,index);
    }
  }

  public static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static void main(String[] args) {
    //int[] a = {13, 1, 4, 5, 6, 2, 9, 8, 0, 12, -1, 11};
    In in = new In("D:\\JavaCode\\Algs4\\algs4-data\\8Kints.txt");
    int[] a = in.readAllInts();
    long start = System.currentTimeMillis();
    SelectionSort(a);
    long end = System.currentTimeMillis();
    for (int i = 0; i < a.length; i++) {
      System.out.println(a[i]);
    }
    System.out.println(end - start);
  }
}
