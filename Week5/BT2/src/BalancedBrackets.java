import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

  public static String isBalanced(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i =0; i < s.length(); i++) {
      char t = s.charAt(i);
      if (t == '{' || t == '(' || t == '[') {
        stack.push(t);
      }
      if (t == '}') {
          if (stack.isEmpty() || stack.peek() != '{') {
            return "INVALID";
          }
          stack.pop();
      }
      if (t == ')') {
        if (stack.isEmpty() || stack.peek() != '(') {
          return "INVALID";
        }
        stack.pop();
      }
      if (t == ']') {
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
