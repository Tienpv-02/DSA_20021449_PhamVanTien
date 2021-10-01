import edu.princeton.cs.algs4.*;

public class Sum3 {
    public static void main(String[] args) {
        In in = new In("D:\\JavaCode\\Algs4\\algs4-data\\1Kints.txt");
        int[] arr = in.readAllInts();
        for (int i=0; i < arr.length-2; i++) {
            for (int j=i+1; j < arr.length-1; j++) {
                for (int z=j+1; z < arr.length; z++) {
                    if (arr[i]+arr[j]+arr[z] == 0) {
                        System.out.println(arr[i]+" "+arr[j]+" "+arr[z]);
                    }
                }
            }
        }
    }
}
