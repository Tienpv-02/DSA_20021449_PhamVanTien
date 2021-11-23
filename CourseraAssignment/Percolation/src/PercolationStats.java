import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import java.util.ArrayList;

/** doc.*/
public class PercolationStats {
  private int n;
  private double[] threshold;
  private double x;
  private double s;

  /** perform independent trials on an n-by-n grid.*/
  public PercolationStats(int n, int trials) {
    if (n <= 0 || trials <= 0) {
      throw new IllegalArgumentException();
    }
    this.n = n;
    threshold = new double[trials];

    for (int i = 0; i < trials; i++) {
      Percolation percolation = new Percolation(n);
      int[] randomSiteID = StdRandom.permutation(n * n);
      for (int j = 0; j < n * n; j++) {
        int row = randomSiteID[j] / n + 1;
        int col = randomSiteID[j] % n + 1;
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
    PercolationStats percolationStats1 = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    PercolationStats percolationStats2 = new PercolationStats(2, 100000);
    System.out.printf("%-14s = %f\n","mean", percolationStats1.mean());
    System.out.printf("%-14s = %f\n","stddev", percolationStats1.stddev());
    System.out.printf("[%f - %f]\n", percolationStats1.confidenceLo(), percolationStats1.confidenceHi());
    System.out.printf("%-14s = %f\n","mean",percolationStats2.mean());
    System.out.printf("%-14s = %f\n","stddev", percolationStats2.stddev());
    System.out.printf("[%f - %f]\n", percolationStats2.confidenceLo(), percolationStats2.confidenceHi());
  }

}
