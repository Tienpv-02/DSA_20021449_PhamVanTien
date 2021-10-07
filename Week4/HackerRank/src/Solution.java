public class Solution {

  static class SinglyLinkedListNode {

    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
      this.data = nodeData;
      this.next = null;
    }
  }

  /**
   * print elements.
   */
  static void printLinkedList(SinglyLinkedListNode head) {
    SinglyLinkedListNode node = head;

    while (node != null) {
      System.out.println(node.data);
      node = node.next;
    }
  }

  /**
   * insert node at tail.
   */
  static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
    SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
    if (head == null) {
      head = newNode;
    } else {
      SinglyLinkedListNode node = head;
      while (node.next != null) {
        node = node.next;
      }
      node.next = newNode;
    }
    return head;
  }

  /**
   * insert node at tail.
   */
  static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
    SinglyLinkedListNode head = new SinglyLinkedListNode(data);
    head.next = llist;
    return head;
  }

  /**
   * insert node at position.
   */
  public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data,
      int position) {
    SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
    if (position == 0) {
      newNode.next = llist;
      llist = newNode;
    } else {
      SinglyLinkedListNode node = llist;
      --position;
      while (position > 0) {
        node = node.next;
        --position;
      }
      newNode.next = node.next;
      node.next = newNode;
    }
    return llist;
  }

  /**
   * delete node .
   */
  public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
    if (position == 0) {
      llist = llist.next;
    } else {
      SinglyLinkedListNode node = llist;
      --position;
      while (position > 0) {
        node = node.next;
        --position;
      }
      node.next = node.next.next;
    }
    return llist;
  }

  /**
   * reverse Print.
   */
  public static void reversePrint(SinglyLinkedListNode llist) {
    if (llist.next != null) {
      reversePrint(llist.next);
    }
    System.out.println(llist.data);
  }

  /**
   * reverse .
   */
  public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
    SinglyLinkedListNode currentNode = llist;
    SinglyLinkedListNode prevNode = null;

    while (currentNode != null) {
      SinglyLinkedListNode nextNode = currentNode.next;
      currentNode.next = prevNode;
      prevNode = currentNode;
      currentNode = nextNode;
    }
    return prevNode;
  }

  /**
   * compare two lists.
   */
  static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    SinglyLinkedListNode node1 = head1;
    SinglyLinkedListNode node2 = head2;
    while (node1 != null || node2 != null) {
      if (node1 == null || node2 == null || node1.data != node2.data) {
        return false;
      }
      node1 = node1.next;
      node2 = node2.next;
    }
    return true;
  }

  /**
   * merge 2 linked lists.
   */
  static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    if (head1 == null) {
      return head2;
    } else if (head2 == null) {
      return head1;
    }
    if (head1.data < head2.data) {
      head1.next = mergeLists(head1.next, head2);
      return head1;
    } else {
      head2.next = mergeLists(head2.next, head1);
      return head2;
    }
  }

  /** get node.*/
  public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
    // Write your code here
    SinglyLinkedListNode node1 = llist;
    SinglyLinkedListNode node2 = llist;
    while (positionFromTail > 0) {
      node1 = node1.next;
      positionFromTail--;
    }
    while (node1.next != null) {
      node1 = node1.next;
      node2 = node2.next;
    }
    return node2.data;
  }
}

