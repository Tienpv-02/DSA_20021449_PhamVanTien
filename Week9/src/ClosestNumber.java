import edu.princeton.cs.algs4.Merge;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestNumber {

  public static void mergeSort(List<Integer> a) {
    if (a.size() < 2) {
      return;
    }
    int mid = a.size() / 2;
    List<Integer>l = new ArrayList<>();
    List<Integer>r = new ArrayList<>();

    for (int i = 0; i < mid; i++) {
      l.add(a.get(i));
    }
    for (int i = mid; i < a.size(); i++) {
      r.add(a.get(i));
    }
    mergeSort(l);
    mergeSort(r);

    merge(a, l, r);
  }

  public static void merge(List<Integer> a, List<Integer> l, List<Integer> r) {

    int i = 0, j = 0, k = 0;
    int sizeL = l.size();
    int sizeR = r.size();
    while (i < sizeL && j < sizeR) {
      if (l.get(i) <= r.get(j)) {
        a.set(k++,l.get(i++));
      } else {
        a.set(k++,r.get(j++));
      }
    }
    while (i < sizeL) {
      a.set(k++,l.get(i++));
    }
    while (j < sizeR) {
      a.set(k++,r.get(j++));
    }

  }
  public static List<Integer> closestNumbers(List<Integer> arr) {

    // Write your code here
    mergeSort(arr);
    List<Integer> sb = new ArrayList<>();
    for (int i = 0; i < arr.size()-1; i++) {
      sb.add(arr.get(i+1) - arr.get(i));
    }
    List<Integer> res = new ArrayList<>();
    int minOfArray = sb.get(0);
    res.add(arr.get(0));
    res.add(arr.get(1));
    for (int i = 1; i < sb.size(); i++) {
      if (sb.get(i) < minOfArray) {
        minOfArray = sb.get(i);
        res.clear();
        res.add(arr.get(i));
        res.add(arr.get(i + 1));
      } else if (sb.get(i) == minOfArray) {
        res.add(arr.get(i));
        res.add(arr.get(i + 1));
      }
    }
    return res;
  }

}
