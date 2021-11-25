import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Solver {
  private List<Board> solution;
  private boolean isSolvable;

  private class SearchNode implements Comparable<SearchNode> {
    private Board board;
    private SearchNode prevNote;
    private int numOfMoves;
    private int manhattanPriority;

    public SearchNode(Board board, SearchNode prevNote, int numOfMoves) {
      if (board == null) {
        throw new IllegalArgumentException();
      }
      this.board = board;
      this.prevNote = prevNote;
      this.numOfMoves = numOfMoves;
      this.manhattanPriority = this.board.manhattan() + this.numOfMoves;
    }

    public int priorityFunction() {
      return manhattanPriority;
    }

    @Override
    public int compareTo(SearchNode o) {
      return Integer.compare(this.priorityFunction(), o.priorityFunction());
    }
  }


  public Solver(Board initial) {
    if (initial == null) {
      throw new IllegalArgumentException();
    }
    MinPQ<SearchNode> gameTree1 = new MinPQ<>();
    MinPQ<SearchNode> gameTree2 = new MinPQ<>();
    gameTree1.insert(new SearchNode(initial,null, 0));
    isSolvable = true;
    gameTree2.insert(new SearchNode(initial.twin(), null, 0));
    while (!gameTree1.isEmpty() && !gameTree2.isEmpty()) {
      if (gameTree2.min().board.isGoal()) {
        isSolvable = false;
        return;
      }
      if (gameTree1.min().board.isGoal()) {
        break;
      }
      SearchNode searchNode1 = gameTree1.delMin();
      for (Board element : searchNode1.board.neighbors()) {
        if (searchNode1.prevNote == null || !element.equals(searchNode1.prevNote.board)) {
          gameTree1.insert(new SearchNode(element, searchNode1,
              searchNode1.numOfMoves + 1));
        }
      }
      SearchNode searchNode2 = gameTree2.delMin();
      for (Board element : searchNode2.board.neighbors()) {
        if (searchNode2.prevNote == null || !element.equals(searchNode2.prevNote.board)) {
          gameTree2.insert(new SearchNode(element, searchNode2,
              searchNode2.numOfMoves + 1));
        }
      }
    }
    solution = new ArrayList<>();
    SearchNode node = gameTree1.min();
    do {
      solution.add(node.board);
      node = node.prevNote;
    }
    while (node != null);
    Collections.reverse(solution);
  }

  public boolean isSolvable() {
    return isSolvable;
  }

  public int moves() {
    return isSolvable ? solution.size() : -1;
  }

  public Iterable<Board> solution() {
    return isSolvable ?  solution : null;
  }

}
