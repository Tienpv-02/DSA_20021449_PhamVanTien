import java.util.Scanner;


public class HeightOfBT {
    /*
    class Node
        int data;
        Node left;
        Node right;
    */

  static class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
      this.data = data;
      left = null;
      right = null;
    }
  }
  public static int height(Node root) {
    // Write your code here.
    if (root == null) {
      return -1;
    }
    else {
      return Math.max(height(root.left), height(root.right)) + 1;
    }
    /*return level(root, 0) - 1;*/
  }

  public static int level(Node root, int l) {
    if (root != null) {
      l++;
      int left = level(root.left, l);
      int right = level(root.right, l);
      return Math.max(left, right);
    }
    return l;
  }

    public static Node insert(Node root, int data) {
      if(root == null) {
        return new Node(data);
      } else {
        Node cur;
        if(data <= root.data) {
          cur = insert(root.left, data);
          root.left = cur;
        } else {
          cur = insert(root.right, data);
          root.right = cur;
        }
        return root;
      }
    }

    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int t = scan.nextInt();
      Node root = null;
      while(t-- > 0) {
        int data = scan.nextInt();
        root = insert(root, data);
      }
      scan.close();
      int height = height(root);
      System.out.println(height);
    }
}
