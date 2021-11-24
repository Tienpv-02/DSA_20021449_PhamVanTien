import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
  private Node<Item> first;
  private Node<Item> last;
  private int n;

  private static class Node<Item> {
    private Item item;
    private Node<Item> next;
    private Node<Item> prev;
  }

  public Deque() {
    first = null;
    last = null;
    n = 0;
  }

  public boolean isEmpty() {
    return first == null || last == null;
  }

  public int size() {
    return n;
  }

  public void addFirst(Item item) {
    if (item == null) {
      throw new IllegalArgumentException();
    }
    Node<Item> oldFirst = first;
    first = new Node<Item>();
    first.item = item;
    first.next = oldFirst;
    if (isEmpty()) {
      last = first;
    } else {
      oldFirst.prev = first;
    }
    n++;
  }

  public void addLast(Item item) {
    if (item == null) {
      throw new IllegalArgumentException();
    }
    Node<Item> oldLast = last;
    last = new Node<Item>();
    last.item = item;
    last.prev = oldLast;
    if (isEmpty()) {
      first = last;
    } else {
      oldLast.next = last;
    }
    n++;
  }

  public Item removeFirst() {
    if (isEmpty()) throw new NoSuchElementException();
    Item item = first.item;
    first = first.next;
    n--;
    if (isEmpty()) last = null;
    else first.prev = null;
    return item;
  }

  public Item removeLast() {
    if (isEmpty()) throw new NoSuchElementException();
    Item item = last.item;
    last = last.prev;
    n--;
    if (isEmpty()) {
      first = null;
    } else last.next = null;
    return item;
  }

  public Iterator<Item> iterator() {
    return new LinkedIterator(first);
  }

  private class LinkedIterator implements Iterator<Item> {
    private Node<Item> current;
    public LinkedIterator(Node<Item> first) {
      current = first;
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public Item next() {
      if (!hasNext()) throw new NoSuchElementException();
      Item item = current.item;
      current = current.next;
      return item;
    }
  }

  public static void main(String[] args) {
    Deque<String> deque = new Deque<>();
    while (!StdIn.isEmpty()) {
      String item = StdIn.readString();
      if (item.equals("-")) {
        StdOut.println("remove firt: " + deque.removeFirst());
      } else if (item.equals("_")) {
        StdOut.println("remove last : " + deque.removeLast());
      } else {
        deque.addLast(item);
      }
    }
    StdOut.println(deque.size() + " items left on deque");
    for (Object element : deque) {
      StdOut.println(element);
    }
  }
}