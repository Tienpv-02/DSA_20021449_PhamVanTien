public class Search {

  public static int binarySearch(List<Integer> a, int number, int lIndex, int rIndex) {
    if (rIndex >= lIndex) {
      int midIndex = lIndex + (rIndex - lIndex) / 2;
      if (a.get(midIndex) == number) {
        return midIndex;
      } else if (number > a.get(midIndex)) {
        return binarySearch(a, number, midIndex + 1 , rIndex);
      } else {
        return binarySearch(a, number, lIndex, midIndex - 1);
      }
    }
    return -1;
  }
  public static int introTutorial(int V, List<Integer> arr) {
    // Write your code here
    return binarySearch(arr, V, 0, arr.size()-1);
  }

}
