import java.util.Scanner;
public class Sum {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int target = in.nextInt();
        int[] nums = new int[len];
        for (int i=0; i < len; i++) {
            nums[i] = in.nextInt();
        }
        twoSum(nums,target);
    }
    public static void twoSum(int[] nums, int target) {
        for (int i=0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.println((i+1) + " " + (j+1));
                }
            }
        }
    }
}