import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SolutionTest {

  public static void main(String[] args) {
    //List<Integer> arr = new ArrayList<>(Arrays.asList(-20, -3916237, -357920, -3620601, 7374819, -7330761
    //    ,30, 6246457, -6461594, 266854 ));
    //System.out.println(Solution.balancedSums(arr));
    //printArray(Solution.closestNumbers(arr));
    List<Integer> q = new ArrayList<>(Arrays.asList(1, 2, 5, 3, 7, 8, 6, 4));
    Solution.minimumBribes(q);
  }
  public static void printArray(List<Integer> arr) {
    for (Integer integer : arr) {
      System.out.print(integer + " ");
    }
  }
}
