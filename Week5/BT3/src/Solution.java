import java.util.*;

public class Solution {

  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scanner = new Scanner(System.in);
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    int q = scanner.nextInt();

    for (int i = 0; i < q; i++) {
      int type = scanner.nextInt();
      if (type == 1) {
        int x = scanner.nextInt();
        s1.push(x);
      } else {
        if (s2.isEmpty()) {
          while (!s1.isEmpty()) {
            s2.push(s1.pop());
          }
        }
        if (!s2.isEmpty()) {
          if (type == 2) s2.pop();
          if (type == 3) System.out.println(s2.peek());
        }
      }

    }
  }
}