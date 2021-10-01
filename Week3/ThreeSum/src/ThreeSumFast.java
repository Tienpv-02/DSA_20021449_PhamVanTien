import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class ThreeSumFast {

  public static void printAll(int[] a) {
    Arrays.sort(a);
    for (int i = 0; i < a.length; i++) {
      for (int j = i+1; j < a.length; j++) {
        int k = Arrays.binarySearch(a, -(a[i] + a[j]));
        if (k > j) StdOut.println(a[i] + " " + a[j] + " " + a[k]);
      }
    }
  }

  public static int count(int[] a) {
    Arrays.sort(a);
    int count = 0;
    for (int i = 0; i < a.length; i++) {
      for (int j = i+1; j < a.length; j++) {
        int k = Arrays.binarySearch(a, -(a[i] + a[j]));
        if (k > j) count++;
      }
    }
    return count;
  }
}