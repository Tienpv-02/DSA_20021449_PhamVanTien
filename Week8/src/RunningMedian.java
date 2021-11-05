import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class RunningMedian {
    public static List<Double> runningMedian(List<Integer> a) {
      // Write your code here
      int N = a.size();
      List<Double> result = new ArrayList<>();
      Queue<Integer> maxPQ = new PriorityQueue<>(N/2 + 1, Collections.reverseOrder());
      Queue<Integer> minPQ = new PriorityQueue<>(N/2 + 1);
      double median = a.get(0);
      for (Integer _a : a) {
        if (_a < median) {
          maxPQ.add(_a);
        } else {
          minPQ.add(_a);
        }

        if (maxPQ.size() > minPQ.size()) {
          minPQ.add(maxPQ.remove());
        } else if (maxPQ.size() < minPQ.size()) {
          maxPQ.add(minPQ.remove());
        }

        if (maxPQ.size() > minPQ.size()) {
          median = maxPQ.peek();
        } else if (maxPQ.size() < minPQ.size()) {
          median = minPQ.peek();
        } else {
          median = (maxPQ.peek() + minPQ.peek()) / (double) 2;
        }
        result.add(median);
      }
      return result;
    }
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    List<Integer> A = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      A.add(scan.nextInt());
    }
    scan.close();
    System.out.println(runningMedian(A));
  }
}