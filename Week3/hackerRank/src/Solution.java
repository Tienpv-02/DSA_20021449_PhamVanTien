import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

  /** Sherlock and Array. */
  public static String balancedSums(List<Integer> arr) {
    // Write your code here
    long lSum = 0;
    long rSum = 0;
    for (Integer integer : arr) {
      rSum += integer;
    }
    for (Integer integer : arr) {
      rSum -= integer;
      if (rSum == lSum)
        return "YES";
      lSum += integer;
    }
    return "NO";
  }

  /**Closest Numbers.*/
  public static List<Integer> closestNumbers(List<Integer> arr) {
    // Write your code here
    Collections.sort(arr);
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

  /** Pairs. */
  public static int pairs(int k, List<Integer> arr) {
    Collections.sort(arr);
    int i = 0;
    int j = 1;
    int count = 0;
    while (j < arr.size()) {
      long diff = arr.get(j) - arr.get(i);
      if (diff == k) {
        count++;
        j++;
      } else if (diff > k) {
        i++;
      } else if (diff < k) {
        j++;
      }
    }
    return count;
  }

  /**New year chaos*/
  public static void minimumBribes(List<Integer> q) {
    int count = 0;
    for(int i=q.size()-1; i>=0; i--){
      int bribes = q.get(i) - (i+1);
      if( bribes > 2) {
        System.out.println("Too chaotic");
        return;
      }
      else if (bribes < 0) {
        for (int j = 0; j < i; j++) {
          if (q.get(j) > q.get(i)) {
            count++;
          }
        }
      }
    }
    System.out.println(count);
  }
}
