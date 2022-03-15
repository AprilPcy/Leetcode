package _2022_3_14;

import java.util.Arrays;

public class _169_MajorityElement_Method2_Sort {
    /*
      方法二:利用sort方法，由于超过一半的数为Majority Element,所以排序后，在中间的数一定为Target Element
        Time Complexity: O(nlogn)
        Space Complexity: O(1) or O(n)
        由于Arrays.sort 的底层是 quickSort，quickSort的 Time Complexity: O(nlogn)
        所以最终的 Time Complexity: O(nlogn)
     */
    public int majorityElement(int[] nums){
        if(nums.length<2) return nums[0];
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
