import java.util.Scanner;

public class ThreeSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int m1 = Math.max(a,b);
        int m2 = (a+b) - m1;
        if (c <= m1) {
            m2 = Math.max(c,m2);
        } else {
            m2 = m1;
            m1 = c;
        }
        int m3 = a+b+c-m1-m2;
        System.out.println(m1+" "+m2+" "+m3);
    }
}
