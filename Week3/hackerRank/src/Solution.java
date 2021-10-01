import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

  /** Sherlock and Array. */
  public static String balancedSums(List<Integer> arr) {
    // Write your code here
    long lSum = 0;
    long rSum = 0;
    for (int i = 0; i < arr.size(); i++) {
      rSum += arr.get(i);
    }
    for (int i = 0; i < arr.size(); i++) {
      rSum -= arr.get(i);
      if (rSum == lSum) return "YES";
      lSum += arr.get(i);
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

  /**New year chaos*/
    public static void minimumBribes(List<Integer> q) {
      List<Integer> deviationOfIndex = new ArrayList<>();
      for (int i = 0; i < q.size(); i++) {
        int deviation = i + 1 - q.get(i);
        if (deviation > 2 || deviation < -2) {
          System.out.println("Too chaotic");
          return;
        }
        deviationOfIndex.add(deviation);
      }
      int count  = 0;
      for (int i = 0; i < deviationOfIndex.size(); i++) {
        if (deviationOfIndex.get(i) > 0) {
          count += deviationOfIndex.get(i);
        }
      }
      System.out.println(count);
    }

}
