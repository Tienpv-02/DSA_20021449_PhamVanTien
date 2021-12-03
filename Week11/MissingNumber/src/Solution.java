import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.logging.Handler;

public class Solution {
  /*public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
    // Write your code here
    Hashtable<Integer, Integer> f = new Hashtable<>();
    for (Integer b : brr) {
      if (f.containsKey(b)) {
        f.put(b, f.get(b) + 1);
      } else {
        f.put(b, 1);
      }
    }
    for (Integer a : arr) {
      if (f.containsKey(a)) {
        f.put(a, f.get(a) - 1);
      } else {
        throw new NoSuchElementException();
      }
    }
    List<Integer> result = new LinkedList<>();
    for (Map.Entry<Integer, Integer> e : f.entrySet()) {
      if (e.getValue() > 0) {
        result.add(e.getKey());
      }
    }
    Collections.sort(result);
    return result;
  }*/

  public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {

  }
}
