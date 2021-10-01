import edu.princeton.cs.algs4.*;

public class Sum2 {
    public static void main(String[] args) {
        In in = new In("D:\\JavaCode\\Algs4\\algs4-data\\8Kints.txt");
        int[] arr = in.readAllInts();
        for (int i=0; i < arr.length-1; i++) {
            for (int j=i+1; j < arr.length; j++) {
                if (arr[i]+arr[j] == 0) {
                    System.out.println(arr[i] + " " + arr[j]);
                }
            }
        }
    }
}
