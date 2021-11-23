import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/** doc.*/
public class Percolation {
  private WeightedQuickUnionUF grid;
  private boolean[][] isOpen;
  private final int N;
  private final int virtualTopSite;
  private final int virtualBottomSite;
  private int numberOfOpenSites;

  /** creates n-by-n grid, with all sites initially blocked.*/
  public Percolation(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException();
    }
    grid = new WeightedQuickUnionUF(n * n + 2); // + virtualBottomSite, virtualBottomSite
    this.N = n;
    virtualTopSite = N * N;
    virtualBottomSite = N * N + 1;
    numberOfOpenSites = 0;
    isOpen = new boolean[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        isOpen[i][j] = false;
      }
    }
  }

  /** refer to object ID in WeightedQuickUnionUF.*/
  private int siteID(int row, int col) {
    if (row > N || row <= 0 || col > N || col <= 0) {
      throw  new IllegalArgumentException();
    }
    return (row - 1) * N + col - 1;
  }

  /** opens the site (row, col) if it is not open already.*/
  public void open(int row, int col) {
    if (row > N || row <= 0 || col > N || col <= 0) {
      throw  new IllegalArgumentException();
    }
    if (row == 1) {
      grid.union(siteID(row, col), virtualTopSite);
    }
    if (row == N) {
      grid.union(siteID(row, col), virtualBottomSite);
    }
    numberOfOpenSites++;
    isOpen[row][col] = true;
    // Up
    if (row > 1 && isOpen(row - 1, col)) {
      grid.union(siteID(row, col), siteID(row - 1, col));
    }
    // Down
    if (row < N && isOpen(row + 1, col)) {
      grid.union(siteID(row, col), siteID(row + 1, col));
    }
    // Left
    if (col > 1 && isOpen(row, col -1)) {
      grid.union(siteID(row, col), siteID(row, col - 1));
    }
    // Right
    if (col < N && isOpen(row, col + 1)) {
      grid.union(siteID(row, col), siteID(row, col + 1));
    }
  }

  /** is the site (row, col) open?.*/
  public boolean isOpen(int row, int col) {
    if (row > N || row <= 0 || col > N || col <= 0) {
      throw  new IllegalArgumentException();
    }
    return isOpen[row][col];
  }

  /** is the site (row, col) full?.*/
  public boolean isFull(int row, int col) {
    if (row > N || row <= 0 || col > N || col <= 0) {
      throw  new IllegalArgumentException();
    }
    return grid.find(siteID(row, col)) == grid.find(virtualTopSite);
  }


  /** returns the number of open sites.*/
  public int numberOfOpenSites() {
    return this.numberOfOpenSites;
  }

  /** does the system percolate?.*/
  public boolean percolates() {
    return grid.find(virtualTopSite) == grid.find(virtualBottomSite);
  }


  /** test client (optional).*/
  public static void main(String[] args) {
    Percolation percolation = new Percolation(5);
    percolation.open(1,2);
    percolation.open(2,2);
    percolation.open(2,3);
    percolation.open(3,3);
    //percolation.open(4,3);
    percolation.open(4,4);
    percolation.open(5,4);
    System.out.println(percolation.percolates());
  }
}
