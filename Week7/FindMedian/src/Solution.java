import java.util.Collections;
import java.util.List;

public class Solution {

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

  public static int findMedian(List<Integer> arr) {
    // Write your code here
    int lo = 0, hi = arr.size() - 1;
    int k = arr.size()/2;
    while (hi > lo)
    {
      int j = partition(arr, lo, hi);
      if (j < k) lo = j + 1;
      else if (j > k) hi = j - 1;
      else return arr.get(k);
    }
    return arr.get(k);
  }
}
