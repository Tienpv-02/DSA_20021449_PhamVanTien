import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BruteCollinearPoints {
  private final List<LineSegment> segments;

  public BruteCollinearPoints(Point[] points) {
    if (points == null) throw new IllegalArgumentException();
    int n = points.length;
    Arrays.sort(points);
    for (int i = 0; i < points.length - 1; i++) {
        if (points[i] == points[i+1] || points[i] == null || points[i+1] == null)
          throw new IllegalArgumentException();
    }
    segments = new ArrayList<>();
    for (int p = 0; p < n - 3; p++) {
      for (int q = p + 1; q < n - 2; q++) {
        for (int r = q + 1; r < n - 1; r++) {
          for (int s = r + 1; s < n; s++) {
            if (points[p].slopeTo(points[q]) == points[p].slopeTo(points[r])
                && points[p].slopeTo(points[q]) == points[p].slopeTo(points[s])) {
              segments.add(new LineSegment(points[p],points[s]));
            }
          }
        }
      }
    }
  }

  public int numberOfSegments() {
    return segments.size();
  }

  public LineSegment[] segments() {
    LineSegment[] segmentArray = new LineSegment[segments.size()];
    return segments.toArray(segmentArray);
  }

//  public static void main(String[] args) {
//    // read the n points from a file
//    In in = new In(args[0]);
//    int n = in.readInt();
//    Point[] points = new Point[n];
//    for (int i = 0; i < n; i++) {
//      int x = in.readInt();
//      int y = in.readInt();
//      points[i] = new Point(x, y);
//    }
//    // draw the points
//    StdDraw.enableDoubleBuffering();
//    StdDraw.setXscale(0, 32768);
//    StdDraw.setYscale(0, 32768);
//    for (Point p : points) {
//      p.draw();
//    }
//    StdDraw.show();
//
//    // print and draw the line segments
//    BruteCollinearPoints collinear = new BruteCollinearPoints(points);
//    for (LineSegment segment : collinear.segments()) {
//      StdOut.println(segment);
//      segment.draw();
//    }
//    StdDraw.show();
//  }
}
