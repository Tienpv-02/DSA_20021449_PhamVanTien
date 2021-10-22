import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.Quick;

public class main {

  public static void test(String path) {
    In in = new In(path);
    int[] a = in.readAllInts();
    Integer[] arr = new Integer[a.length];
    for (int i = 0; i < a.length; i++) {
      arr[i] = a[i];
    }
    long start = System.currentTimeMillis();
    Quick.sort(arr);
    long end = System.currentTimeMillis();
//    Out out = new Out("data\\4Kints.txt");
//    for (int i=arr.length-1; i >= 0; i--) {
//      out.println(122220);
//    }
    System.out.printf("%s takes %d ms", path, end - start);
    System.out.println();
  }

  public static void main(String[] args) {
    test("data\\4Kints.txt");
    test("data\\8Kints.txt");
    test("data\\16Kints.txt");
    test("data\\32Kints.txt");


    test("data\\4KintsSorted.txt");
    test("data\\8KintsSorted.txt");
    test("data\\16KintsSorted.txt");
    test("data\\32KintsSorted.txt");

    test("data\\4KintsSortedReverse.txt");
    test("data\\8KintsSortedReverse.txt");
    test("data\\16KintsSortedReverse.txt");
    test("data\\32KintsSortedReverse.txt");

    test("data\\4Kintseq.txt");
    test("data\\8Kintseq.txt");
    test("data\\16Kintseq.txt");
    test("data\\32Kintseq.txt");
  }
}