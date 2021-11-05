import java.util.Scanner;

public class StringReverse {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    String A=sc.next();
    /* Enter your code here. Print output to STDOUT. */
    int length = A.length();
    for (int i=0; i < length/2; i++) {
      if (A.charAt(i) != A.charAt(length - i -1)) {
        System.out.println("No");
        return;
      }
    }
    System.out.println("Yes");
    return;
  }

}
