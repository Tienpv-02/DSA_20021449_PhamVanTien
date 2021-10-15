import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Result {

  public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
    // Write your code here
    Stack<Integer> s1 = new Stack<>();
    int sum1 = 0;
    for (int i = h1.size() - 1; i >= 0; i--) {
      s1.push(h1.get(i));
      sum1 += h1.get(i);
    }
    Stack<Integer> s2 = new Stack<>();
    int sum2 = 0;
    for (int i = h2.size() - 1; i >= 0; i--) {
      s2.push(h2.get(i));
      sum2 += h2.get(i);
    }
    Stack<Integer> s3 = new Stack<>();
    int sum3 = 0;
    for (int i = h3.size() - 1; i >= 0; i--) {
      s3.push(h3.get(i));
      sum3 += h3.get(i);
    }

    while (true) {
      int min = Math.min(Math.min(sum1, sum2), sum3);
      if (sum1 > min) {
        sum1 -= s1.pop();
      }
      if (sum2 > min) {
        sum2 -= s2.pop();
      }
      if (sum3 > min) {
        sum3 -= s3.pop();
      }
      if (sum1 == sum2 && sum2 == sum3) {
        return sum1;
      }
      if (min == 0)
        return 0;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n1 =  in.nextInt();
    int n2 = in.nextInt();
    int n3 = in.nextInt();
    List<Integer> h1 = new ArrayList<>();
    for (int i = 0; i < n1; i++) {
      h1.add(in.nextInt());
    }
    List<Integer> h2 = new ArrayList<>();
    for (int i = 0; i < n2; i++) {
      h2.add(in.nextInt());
    }
    List<Integer> h3 = new ArrayList<>();
    for (int i = 0; i < n3; i++) {
      h3.add(in.nextInt());
    }

    System.out.println(equalStacks(h1, h2, h3));
  }
}
