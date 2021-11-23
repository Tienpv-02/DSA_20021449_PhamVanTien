import java.util.Scanner;
import java.util.Stack;

public class bt1 {
  public static String isBalanced(String s) {
    int vuong = 0;
    int nhon = 0;
    int tron = 0;

    Stack<Character> stack = new Stack<>();
    for (int i =0; i < s.length(); i++) {
      char t = s.charAt(i);

      if (t == '{') {
        if (tron > 0 || vuong > 0) return "INVALID";
        nhon++;
        stack.push(t);
      }
      if (t == '[') {
        if (tron > 0) return "INVALID";
        vuong++;
        stack.push(t);
      }
      if (t == '(') {
        tron++;
        stack.push(t);
      }

      if (t == '}') {
        nhon--;
        if (stack.isEmpty() || stack.peek() != '{') {
          return "INVALID";
        }
        stack.pop();
      }
      if (t == ')') {
        tron--;
        if (stack.isEmpty() || stack.peek() != '(') {
          return "INVALID";
        }
        stack.pop();
      }
      if (t == ']') {
        vuong--;
        if (stack.isEmpty() || stack.peek() != '[') {
          return "INVALID";
        }
        stack.pop();
      }
    }
    return stack.isEmpty() ? "VALID" : "INVALID";
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    System.out.println(isBalanced(str));
  }
}
