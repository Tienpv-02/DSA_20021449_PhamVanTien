import edu.princeton.cs.algs4.*;

public class UFClient2 {
    public static void main(String[] args) {
        In in = new In("D:\\JavaCode\\Algs4\\algs4-data\\tinyUF.txt");
        int N = in.readInt();
        UF uf = new UF(N);
        int index = 0;
        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            index++;
            if (uf.find(p) != uf.find(q)) {
                uf.union(p, q);
            }
            if (uf.count() == 1) {
                StdOut.println(index);
                return;
            }
        }
        StdOut.println("FAILED");
    }
}
