import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BT6 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String line = sc.nextLine();
    String[] words = line.split(" ");
    PriorityQueue<String> pq = new PriorityQueue();
    for (int i = 0; i < words.length; i++) {
      pq.add(words[i]);
    }

    List<String> wordList = new ArrayList<>();
    ArrayList<Integer> f = new ArrayList<>();
    while (!pq.isEmpty()) {
      String preWord = pq.element();
      int count = 0;
      while (pq.remove(preWord)) {
        count++;
      }
      wordList.add(preWord);
      f.add(count);
    }

    for (int i = 0; i < wordList.size(); i++) {
      System.out.println(wordList.get(i) + ": " + f.get(i));
    }
  }
}