import java.util.Collections;
import java.util.List;

class Solution {

  /*
   * Complete the 'quickSort' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static int partition(List<Integer> arr, int lo, int  hi) {
    if (lo >= hi) {
      return lo;
    }
    int p = arr.get(lo);
    int i = hi;
    for(int j = hi; j > lo; j--) {
      if (arr.get(j) >= p) {
        Collections.swap(arr, i, j);
        i--;
      }
    }
    Collections.swap(arr, i, lo);
    return i;
  }
  public static void quickSort(List<Integer> arr, int lo, int hi) {
    if (lo < hi) {
      int p = partition(arr, lo, hi);
      quickSort(arr, lo, p - 1);
      quickSort(arr, p + 1, hi);
    }
  }

  public static List<Integer> quickSort(List<Integer> arr) {
    // Write your code here
    quickSort(arr, 0,arr.size()-1);
    return arr;
  }

}
