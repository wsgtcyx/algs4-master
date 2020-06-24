package lc.sort;

import lc.sort.SortBase;

/**
 * Created on 2020-05-24-00:04
 *
 * @author Chen Yuxiang(yuxiangchen@sohu-inc.com)
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        int targetIndex = len - k;

        while(true) {
            int partitionIdx = partition(nums, left, right);
            if(partitionIdx == targetIndex) {
                return nums[partitionIdx];
            }else if(partitionIdx < targetIndex) {
                left = partitionIdx + 1;
            }else {
                right = partitionIdx - 1;
            }
        }

    }


    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int lp = left;
        int rp = right;
        while(lp < rp) {
            while(lp < rp && nums[rp] >= pivot) {
                rp --;
            }
            while(lp < rp && nums[lp] <= pivot) {
                lp ++;
            }
            swap(nums, lp, rp);
        }
        swap(nums, left, lp);
        return lp;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
