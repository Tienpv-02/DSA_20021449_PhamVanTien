import java.util.HashSet;
import java.util.List;

public class Pairs {
  /*
   * Complete the 'pairs' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER k
   *  2. INTEGER_ARRAY arr
   */

  public static int pairs(int k, List<Integer> arr) {
    // Write your code here
    int count = 0;
    HashSet<Integer> hashSet = new HashSet<>(arr);
    for (int i = 0; i < arr.size(); i++) {
      if (hashSet.contains(arr.get(i) + k)) {
        count++;
      }
    }
    return count;
  }
}
