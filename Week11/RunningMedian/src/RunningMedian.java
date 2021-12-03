import edu.princeton.cs.algs4.BST;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class RunningMedian {


  private class Num {
    public int value;
    public int stt;
    Num(int value, int stt) {
    }
  }
  public static void main(String[] args) {
    List<Double> result = new ArrayList<>();
    BST<Integer,Integer> bst = new BST<Integer,Integer>();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int i=0;
    while(i<n) {
      n--;
      int x = sc.nextInt();
      bst.put(x,i);
      i++;
      int size = bst.size();
      if(size % 2 == 1) {
        double add = (double)(bst.get(size/2));
        result.add(add);
      }
      else {
        double add=(double)( (bst.get(size/2) +bst.get(size-1))/2 );
        result.add(add);
      }

    }
    for (Double d : result) {
      System.out.printf(d + " ");
    }
  }
}
