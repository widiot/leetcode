package offer.array;

/**
 * 0~n-1中缺失的数字
 */
public class Q53Q2 {
    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println(missingNumber(a));
    }

    public static int missingNumber1(int[] nums) {
        // O(log(n))
        int start = 0, end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    public static int missingNumber(int[] nums) {
        // O(n)

        int len = nums.length;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return ((len + 1) * len / 2) - sum;
    }
}
