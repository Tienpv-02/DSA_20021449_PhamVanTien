import java.util.Scanner;
import java.util.Stack;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int q = sc.nextInt();
    String s = "";
    Stack<String> stack = new Stack<>();
    for (int i = 0; i < q; i++) {
      int t = sc.nextInt();
      switch (t) {
        case 1:
          String w = sc.next();
          s += w;
          stack.push(s);
          break;
        case 2:
          int k = sc.nextInt();
          s = s.substring(0,s.length()-k);
          stack.push(s);
          break;
        case 3:
          int m = sc.nextInt();
          System.out.println(s.charAt(m-1));
          break;
        case 4:
          stack.pop();
          s = stack.peek();
          break;
      }
    }
  }
}