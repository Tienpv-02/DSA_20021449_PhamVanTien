import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastCollinearPoints {
  private final List<LineSegment> segments;

  public FastCollinearPoints(Point[] points) {
    if (points == null) throw new IllegalArgumentException();
    int n = points.length;
    Arrays.sort(points);
    for (int i = 0; i < points.length - 1; i++) {
      if (points[i] == points[i+1] || points[i] == null || points[i+1] == null)
        throw new IllegalArgumentException();
    }
    segments = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      Point origin = points[i];
      //các điểm cần so sánh , các điểm nằm phía trên hoặc bằng so với origin
      Point[] upperPoints = Arrays.copyOfRange(points,i + 1, n);
      Arrays.sort(upperPoints, origin.slopeOrder());
      int lo = 0, hi = 0;
      while (lo < upperPoints.length) {
        while (hi + 1 < upperPoints.length &&
            origin.slopeTo(upperPoints[lo]) == origin.slopeTo(upperPoints[hi + 1])) {
          hi++;
        }
        if (hi - lo + 1 >= 3) {
          segments.add(new LineSegment(origin, upperPoints[hi]));
        }
        hi++;
        lo = hi;
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
//
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
//    FastCollinearPoints collinear = new FastCollinearPoints(points);
//    System.out.println("number of segments" +collinear.numberOfSegments());
//    for (LineSegment segment : collinear.segments()) {
//      StdOut.println(segment);
//      segment.draw();
//    }
//    StdDraw.show();
//  }
}
