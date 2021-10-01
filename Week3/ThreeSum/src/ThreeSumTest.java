import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class ThreeSumTest {
  /**
   * Reads in a sequence of integers from a file, specified as a command-line argument;
   * counts the number of triples sum to exactly zero; prints out the time to perform
   * the computation.
   *
   * @param args the command-line arguments
   */
  public static void main(String[] args)  {
    In in = new In(args[0]);
    int[] a = in.readAllInts();

    Stopwatch timer = new Stopwatch();
    int count = ThreeSumFast.count(a);
    StdOut.println("elapsed time = " + timer.elapsedTime());
    StdOut.println(count);
  }
}
