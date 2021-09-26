package veitch;

/**
 * https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/
 *
 * @author zhengweichao  2021-09-26 10:33 上午
 **/
public class CheckIfAllTheIntegersInRangeAreCovered {


    public boolean isCovered(int[][] ranges, int left, int right) {
        // 差分数组
        int[] diff = new int[52];
        for (int[] range : ranges) {
            ++diff[range[0]];
            --diff[range[1] + 1];
        }
        // 前缀和
        int curr = 0;
        for (int i = 1; i <= 50; ++i) {
            curr += diff[i];
            if (i >= left && i <= right && curr <= 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[] array1 = new int[]{2, 2};
        int[] array2 = new int[]{3, 4};
        int[] array3 = new int[]{5, 6};
        int[][] arrays = new int[][]{array1, array2, array3};

        System.out.println(new CheckIfAllTheIntegersInRangeAreCovered().isCovered(arrays, 1, 7));
    }

}
