import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class JesseAndCookies {
  public static int cookies(int k, List<Integer> A) {
    // Write your code here
    Queue pq = new PriorityQueue(A);
    int count = 0;
    while (k > (int) pq.peek() && pq.size() >= 2) {
      int m1 = (int) pq.remove();
      int m2 = (int) pq.remove();
      pq.add(m1 + 2*m2);
      count++;
    }
    if ((int)pq.peek() >= k) {
      return count;
    }
    return -1;
  }

}
