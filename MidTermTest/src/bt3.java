import edu.princeton.cs.algs4.In;
import java.util.LinkedList;
import java.util.Stack;

public class bt3 {
  static class Node {
    public int data;
    public Node next;

    public Node(int nodeData) {
      this.data = nodeData;
      this.next = null;
    }
  }
  public static void reversePrint(Node head, int k) {
    Node currentNode = head;
    Node prevNode = null;

    while (currentNode != null && k > 0) {
      Node nextNode = currentNode.next;
      currentNode.next = prevNode;
      prevNode = currentNode;
      currentNode = nextNode;
    }
    while (k > 0 && prevNode != null) {
      System.out.print(prevNode.data);
      prevNode = prevNode.next;
      k--;
    }
  }
}
