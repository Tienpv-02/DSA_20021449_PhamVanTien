import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
  private static final int CAPACITY = 16;
  private Item[] rq;
  private int n;

  public RandomizedQueue() {
    rq = (Item[]) new Object[CAPACITY];
    n = 0;
  }

  public boolean isEmpty() {
    return n == 0;
  }

  public int size() {
    return n;
  }

  private void resize(int capacity) {
    assert capacity >= n;
    Item[] copy = (Item[]) new Object[capacity];
    for (int i = 0; i < n; i++) {
      copy[i] = rq[i];
    }
    rq = copy;
  }

  public void enqueue(Item item) {
    if (item == null) throw new IllegalArgumentException();
    if ( n == rq.length) resize(2 * rq.length);
    rq[n] = item;
    n++;
  }

  public Item dequeue() {
    if (isEmpty()) throw new NoSuchElementException();
    int randomIndex = StdRandom.uniform(0,n-1);
    Item item = rq[randomIndex];
    removeAt(randomIndex);
    return item;
  }

  private void removeAt(int index) {
    if (index < 0 || index >= n) throw new IllegalArgumentException();
    for (int i = index; i < n - 1; i++) {
      rq[i] = rq[i + 1];
    }
    rq[n-1] = null;
    n--;
    if (n > 0 && n == rq.length / 4) resize(rq.length / 2);
  }

  public Item sample() {
    if (isEmpty()) throw new NoSuchElementException();
    int randomIndex = StdRandom.uniform(n);
    Item item = rq[randomIndex];
    return item;
  }

  public Iterator<Item> iterator() {
    return new ArrayIterator();
  }

  private class ArrayIterator implements Iterator<Item> {
    private int i = 0;
    private int[] randomIterator;

    ArrayIterator() {
      randomIterator = new int[n];
      for (int j = 0; j < n; j++) {
        randomIterator[j] = j;
      }
      StdRandom.shuffle(randomIterator);
      i = 0;
    }
    public boolean hasNext() {
      return i < n;
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }

    @Override
    public Item next() {
      if (!hasNext()) throw new NoSuchElementException();
      Item item = rq[randomIterator[i]];
      i++;
      return item;
    }

  }

  public static void main(String[] args) {
    RandomizedQueue<String> rq = new RandomizedQueue<>();
    System.out.println("Adding 1-16");
    rq.enqueue("1");
    rq.enqueue("2");
    rq.enqueue("3");
    rq.enqueue("4");
    rq.enqueue("5");
    rq.enqueue("6");
    rq.enqueue("7");
    rq.enqueue("8");
    rq.enqueue("9");
    rq.enqueue("10");
    rq.enqueue("11");
    rq.enqueue("12");
    rq.enqueue("13");
    rq.enqueue("14");
    rq.enqueue("15");
    rq.enqueue("16");
    for (String element: rq) {
      StdOut.print(element + " ");
    }
    StdOut.printf("\nRandom item: %s\n", rq.sample());
    StdOut.println("removing " + rq.dequeue());
    StdOut.println("removing " + rq.dequeue());
    StdOut.println("Remain :");
    for (String element: rq) {
      StdOut.print(element + " ");
    }
    StdOut.printf("\nSize: %d", rq.size());
  }
}
