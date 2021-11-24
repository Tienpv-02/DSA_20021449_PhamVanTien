import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Permutation {

  public static void main(String[] args) {
    int k = Integer.parseInt(args[0]);
    int n = 0;
    RandomizedQueue<String> rq = new RandomizedQueue<>();
    while (!StdIn.isEmpty()) {
      String str = StdIn.readString();
      n++;
      if (rq.size() < k) {
        rq.enqueue(str);
      }
      else {
        if (StdRandom.uniform() < (double) k / n) {
          rq.dequeue();
          rq.enqueue(str);
        }
      }
    }
    for (String element : rq) {
      StdOut.println(element);
    }
  }
}
