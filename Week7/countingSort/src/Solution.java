import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
  public static List<Integer> countingSort(List<Integer> arr) {
    int[] f = new int[100];
    for (Integer a : arr) {
      f[a]++;
    }
    return  Arrays.stream(f).boxed().collect(Collectors.toList());
  }

}

