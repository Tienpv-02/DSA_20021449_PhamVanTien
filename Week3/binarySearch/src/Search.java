public class Search {

  public static int binarySearch(int[] a, int number) {
    return binarySearch1(a, number, 0 , a.length-1);
  }

  public static int binarySearch1(int[] a, int number, int lIndex, int rIndex) {
    if (rIndex >= lIndex) {
      int midIndex = lIndex + (rIndex - lIndex) / 2;     // ~ (rIndex + lIndex) / 2
      if (a[midIndex] == number) {
        return midIndex;
      } else if (number > a[midIndex]) {
        return binarySearch1(a, number, midIndex + 1 , rIndex);
      } else {
        return binarySearch1(a, number, lIndex, midIndex - 1);
      }
    }
    return -1;
  }
}
