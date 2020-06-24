package lc.sort;

/**
 * Created on 2020-05-18-21:59
 *
 * @author Chen Yuxiang(yuxiangchen@sohu-inc.com)
 * 912. 排序数组
 * https://leetcode-cn.com/problems/sort-an-array/
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class SortBase {
    private static int[] aux;

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void mergeSort(int[] nums, int low, int high) {
        if(low >= high) {
            return;
        }

        int mid = (high + low) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);

        //do merge
        int lp = low;
        int rp = mid + 1;


        for (int i = low; i <= nums.length; i++) {
            aux[i] = nums[i];
        }

        for(int current = low; current <= high; current ++) {

            if(lp > mid) { // left part exhausted
                nums[current] = aux[rp++];
            }else if(rp > high) { // right part exhausted
                nums[current] = aux[lp++];
            }else if(aux[lp] < aux[rp]) {
                nums[current] = aux[lp++];  //left element is smaller
            }else {
                nums[current] = aux[rp++];
            }
        }

        return;

    }

    public static int partition(int[] nums, int low, int high) {
        int lp = low;
        int rp = high;
        int key = nums[low];
        while(lp < rp) {
            while(lp < rp && nums[rp] >= key) {
                rp --;
            }
            while(lp < rp && nums[lp] <= key) {
                lp ++;
            }
            swap(nums, lp, rp);
        }
        swap(nums, low, lp);
        return lp;
    }

    public static void qSort(int[] nums, int low, int high) {
        if(low >= high) {
            return;
        }
        int splitIndex = partition(nums, low, high);
        qSort(nums, low, splitIndex - 1);
        qSort(nums, splitIndex + 1, high);
    }

    public int[] sortArray(int[] nums) {

        // mergeSort
//        aux = new int[nums.length];
//        mergeSort(nums, 0, nums.length - 1);

        // quickSort
        qSort(nums, 0, nums.length - 1);


        return nums;
    }
}
