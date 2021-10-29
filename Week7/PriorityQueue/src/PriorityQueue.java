class PriorityQueue {
  private int n=0;
  private int[] a = new int[10000];
  void insert(int k)     //  thêm một số vào hàng đợi
  {
    n++;
    a[n-1] = k;
  }

  int deleteMin()
  {

    int min= Integer.MAX_VALUE;
    int flag=0;
    for(int i=0;i<n;i++) {
      if(a[i]<min) {
        min =a[i];
        flag=i;
      }
    }
    int result = a[flag];
    for (int i = flag;i < (n-1);i++) {
      a[i] = a[i+1];
    }
    n--;
    a[n]=0;
    return result;
  }// xóa số nhỏ nhất ra khỏi hàng đợi và trả về số đó.
}