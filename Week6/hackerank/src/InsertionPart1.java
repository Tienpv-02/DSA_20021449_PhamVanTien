import java.util.List;

public class InsertionPart1 {
  private static void printArray(List<Integer> arr) {
    for (Integer integer : arr) {
      System.out.print(integer + " ");
    }
    System.out.println();
  }

  public static void insertionSort1(int n, List<Integer> arr) {
    // Write your code here
    int tmp = arr.get(n-1);
    for (int i = n-2; i >= 0; i--) {
      if (tmp >= arr.get(i)) {
        arr.set(i+1,tmp);
        printArray(arr);
        break;
      }
      arr.set(i+1, arr.get(i));
      printArray(arr);
    }
    if (tmp < arr.get(0)) {
      arr.set(0,tmp);
      printArray(arr);
    }
  }

}
