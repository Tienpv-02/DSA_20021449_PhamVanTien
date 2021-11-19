public class BST {
//  boolean checkBST(Node root) {
//    return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//  }

  public static boolean checkBST(Node root) {
    boolean check = true;
    if(root != null) {
      check = checkBST(root.left) && (root.data <= root.left.data && root.data >= root.right.data ) && checkBST(root.right);
    }
    return check;
  }

  boolean isBST(Node root, int min, int max) {
    if (root == null) {
      return true;
    }
    if (root.data < min || root.data > max) {
      return false;
    }
    return (isBST(root.left, min, root.data - 1) && isBST(root.right, root.data + 1, max));
  }
}
