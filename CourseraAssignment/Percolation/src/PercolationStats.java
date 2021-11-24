import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/** doc.*/
public class PercolationStats {
  private final double[] threshold;
  private double x;
  private double s;

  /** perform independent trials on an n-by-n grid.*/
  public PercolationStats(int n, int trials) {
    if (n <= 0 || trials <= 0) {
      throw new IllegalArgumentException();
    }
    threshold = new double[trials];

    for (int i = 0; i < trials; i++) {
      Percolation percolation = new Percolation(n);
      int[] randomSiteId = StdRandom.permutation(n * n);
      for (int j = 0; j < n * n; j++) {
        int row = randomSiteId[j] / n + 1;
        int col = randomSiteId[j] % n + 1;
        percolation.open(row, col);
        if (percolation.percolates()) {
          break;
        }
        threshold[i] = (double) percolation.numberOfOpenSites() / (n * n);
      }
      x = StdStats.mean(threshold);
      s = StdStats.stddev(threshold);
    }
  }

  /** sample mean of percolation threshold.*/
  public double mean() {
    return x;
  }

  /** sample standard deviation of percolation threshold.*/
  public double stddev() {
    return s;
  }

  /** low endpoint of 95% confidence interval.*/
  public double confidenceLo() {
    return x - 1.96 * s / Math.sqrt(threshold.length);
  }

  /** high endpoint of 95% confidence interval.*/
  public double confidenceHi() {
    return x + 1.96 * s / Math.sqrt(threshold.length);
  }

  /** test client (see below).*/
  public static void main(String[] args) {
    PercolationStats percolationStats = new PercolationStats(Integer.parseInt(args[0]),
        Integer.parseInt(args[1]));
    System.out.printf("%-23s = %f\n", "mean", percolationStats.mean());
    System.out.printf("%-23s = %f\n", "stddev", percolationStats.stddev());
    System.out.printf("%s%f%s%f%s\n", "95% confidence interval = [", percolationStats.confidenceLo()
        , ", ", percolationStats.confidenceHi(), "]");
  }

}
