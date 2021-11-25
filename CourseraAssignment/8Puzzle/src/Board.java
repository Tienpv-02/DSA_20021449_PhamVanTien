import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;
import java.util.List;

public class Board {
  private final int n;
  private final int[][] tiles;
  private int hammingDist;
  private int manhattanDist;
  private int blankSqRow;
  private int blankSqCol;

  public Board(int[][] tiles) {
    this.tiles = tiles;
    n = tiles.length;
    hammingDist = 0;
    manhattanDist = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (tiles[i][j] == 0) {
          blankSqRow = i;
          blankSqCol = j;
          continue;
        }
        int actualRow = (tiles[i][j] - 1) / n;
        int actualCol = (tiles[i][j] - 1) % n;
        int dist = Math.abs(actualRow - i) + Math.abs(actualCol - j);
        if (dist != 0) {
          manhattanDist += dist;
          hammingDist++;
        }
      }
    }
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(n + "\n");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        stringBuilder.append(" ").append(tiles[i][j]);
      }
      stringBuilder.append("\n");
    }
    return stringBuilder.toString();
  }

  public int dimension() {
    return n;
  }

  public int hamming() {
    return hammingDist;
  }

  public int manhattan() {
    return manhattanDist;
  }

  public boolean isGoal() {
    return hammingDist == 0;
  }

  public boolean equals(Object y) {
    if (!(y instanceof Board)) {
      return false;
    }
    Board temp = (Board) y;
    if (temp.dimension() != n) {
      return false;
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (this.tiles[i][j] != temp.tiles[i][j]) {
          return false;
        }
      }
    }
    return true;
  }

  private Board neighborBoard(int deltaRow, int deltaCol) {
    int[][] newTiles = new int[n][];
    for (int r = 0; r < n; r++) {
      newTiles[r] = tiles[r].clone();
    }
    newTiles[blankSqRow][blankSqCol] = tiles[blankSqRow +deltaRow][blankSqCol +deltaCol];
    newTiles[blankSqRow + deltaRow][blankSqCol + deltaCol] = tiles[blankSqRow][blankSqCol];
    return new Board(newTiles);
  }

  public Iterable<Board> neighbors() {
    List<Board> neighborList = new ArrayList<Board>();
    //Up
    if (blankSqRow > 0) {
      neighborList.add(neighborBoard(-1, 0));
    }
    //Down
    if (blankSqRow < n - 1) {
      neighborList.add(neighborBoard(1, 0));
    }
    //Left
    if (blankSqCol > 0) {
      neighborList.add(neighborBoard(0, -1));
    }
    //Right
    if (blankSqCol < n - 1) {
      neighborList.add(neighborBoard(0, 1));
    }
    return neighborList;
  }

  public Board twin() {
    int[][] newTiles = new int[n][];
    for (int r = 0; r < n; r++) {
      newTiles[r] = tiles[r].clone();
    }
    if (newTiles[0][0] != 0 && newTiles[1][0] != 0) {
      newTiles[0][0] = tiles[1][0];
      newTiles[1][0] = tiles[0][0];
    }
    else {
      newTiles[0][1] = tiles[1][1];
      newTiles[1][1] = tiles[0][1];
    }
    return new Board(newTiles);
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    int n = in.readInt();
    int[][] tiles = new int[n][n];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        tiles[i][j] = in.readInt();
    Board initial = new Board(tiles);
    for (Board element : initial.neighbors()) {
      StdOut.println(element);
    }
    StdOut.println("hamming " + initial.hamming());
    StdOut.println("manhattan " + initial.manhattan());
  }
}
