import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * doc.
 */
public class Percolation {
  private final int n;
  private final int virtualTopSite;
  private final int virtualBottomSite;
  private final WeightedQuickUnionUF grid;
  private final boolean[][] isOpen;
  private int numberOfOpenSites;

  /**
   * creates n-by-n grid, with all sites initially blocked.
   */
  public Percolation(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException();
    }
    grid = new WeightedQuickUnionUF(n * n + 2); // + virtualBottomSite, virtualBottomSite
    this.n = n;
    virtualTopSite = n * n;
    virtualBottomSite = n * n + 1;
    numberOfOpenSites = 0;
    isOpen = new boolean[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        isOpen[i][j] = false;
      }
    }
  }

  /**
   * refer to object ID in WeightedQuickUnionUF.
   */
  private int siteId(int row, int col) {
    if (row > n || row <= 0 || col > n || col <= 0) {
      throw new IllegalArgumentException();
    }
    return (row - 1) * n + col - 1;
  }

  /**
   * opens the site (row, col) if it is not open already.
   */
  public void open(int row, int col) {
    if (row > n || row <= 0 || col > n || col <= 0) {
      throw new IllegalArgumentException();
    }
    if (isOpen[row][col]) {
      return;
    }
    if (row == 1) {
      grid.union(siteId(row, col), virtualTopSite);
    }
    if (row == n) {
      grid.union(siteId(row, col), virtualBottomSite);
    }
    numberOfOpenSites++;
    isOpen[row][col] = true;
    // Up
    if (row > 1 && isOpen(row - 1, col)) {
      grid.union(siteId(row, col), siteId(row - 1, col));
    }
    // Down
    if (row < n && isOpen(row + 1, col)) {
      grid.union(siteId(row, col), siteId(row + 1, col));
    }
    // Left
    if (col > 1 && isOpen(row, col - 1)) {
      grid.union(siteId(row, col), siteId(row, col - 1));
    }
    // Right
    if (col < n && isOpen(row, col + 1)) {
      grid.union(siteId(row, col), siteId(row, col + 1));
    }
  }

  /**
   * is the site (row, col) open?.
   */
  public boolean isOpen(int row, int col) {
    if (row > n || row <= 0 || col > n || col <= 0) {
      throw new IllegalArgumentException();
    }
    return isOpen[row][col];
  }

  /**
   * is the site (row, col) full?.
   */
  public boolean isFull(int row, int col) {
    if (row > n || row <= 0 || col > n || col <= 0) {
      throw new IllegalArgumentException();
    }
    return grid.find(siteId(row, col)) == grid.find(virtualTopSite);
  }

  /**
   * returns the number of open sites.
   */
  public int numberOfOpenSites() {
    return this.numberOfOpenSites;
  }

  /**
   * does the system percolate?.
   */
  public boolean percolates() {
    return grid.find(virtualBottomSite) == grid.find(virtualTopSite);
  }

  /**
   * test client (optional).
   */
  public static void main(String[] args) {
    /*Percolation percolation = new Percolation(5);
    percolation.open(1,2);
    percolation.open(2,2);
    percolation.open(2,3);
    percolation.open(3,3);
    //percolation.open(4,3);
    percolation.open(4,4);
    percolation.open(5,4);
    System.out.println(percolation.percolates());*/
  }
}
