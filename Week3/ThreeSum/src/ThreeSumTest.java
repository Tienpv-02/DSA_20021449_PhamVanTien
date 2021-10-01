import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class ThreeSumTest {
  public static void main(String[] args)  {
    In in = new In(args[0]);
    int[] a = in.readAllInts();
    Stopwatch timer = new Stopwatch();
    int count = ThreeSumFast.count(a);
    StdOut.println("elapsed time = " + timer.elapsedTime());
    StdOut.println(count);
  }
}
