import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
  public static List<Integer> countingSort(List<Integer> arr) {
    // Write your code here
    int[] f = new int[100];
    for (Integer a : arr) {
      f[a]++;
    }
    return  Arrays.stream(f).boxed().collect(Collectors.toList());
  }

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>(Arrays.asList(3, 4,5, 7));
    countingSort(list);
  }
}
