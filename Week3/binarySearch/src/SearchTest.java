import java.util.Arrays;

public class SearchTest {

  public static void main(String[] args) {
    int[] arr = new int[10];
    for (int i = 0; i < arr.length; i++) {
      double temp = Math.random() * 10 + 1;
      arr[i] = (int) temp;
    }
    Arrays.sort(arr);
    for (Integer a : arr) {
      System.out.println(a);
    }
    int number = (int) (Math.random()*10+1);
    System.out.println("Number : " + number);
    System.out.println(Search.binarySearch(arr, number));
  }
}
