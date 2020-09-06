package offer.array;

/**
 * 旋转数组的最小数字
 */
public class Q11 {
    public static void main(String[] args) {
        System.out.println(minArray(new int[]{1, 1, 3, 1}));
    }

    public static int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }

        int s = 0, e = numbers.length - 1;
        if (numbers[s] < numbers[e]) {
            return numbers[s];
        }

        int mid = 0;

        while (s < e) {
            if (s == e - 1) {
                return Math.min(numbers[s], numbers[e]);
            }
            mid = (s + e) / 2;
            if (numbers[mid] == numbers[s] && numbers[mid] == numbers[e]) {
                int min = numbers[s];
                for (int i = s + 1; i <= e; i++) {
                    if (numbers[i] < min) {
                        min = numbers[i];
                    }
                }
                return min;
            }
            if (numbers[mid] >= numbers[s] && numbers[mid] >= numbers[e]) {
                s = mid;
                continue;
            }
            if (numbers[mid] <= numbers[e] && numbers[mid] <= numbers[s]) {
                e = mid;
                continue;
            }
            break;
        }

        return numbers[mid];
    }
}
