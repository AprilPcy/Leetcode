package _2022_3_14;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class _169_MajorityElement_Method4_DivideAndConquer {
    /*
       Time Complexity: O(nlogn)
          Master Theorem---> a=2,b=2,d=1
          log(b,a)=d --->O(n^d(logn))
           所以是 O(nlogn)
       Space Complexity：O(logn)

     */
    public int majorityElement(int[] nums) {
        if(nums.length<2) return nums[0];
        return majorityCount(nums,0,nums.length-1);
    }

    private int majorityCount(int[] nums, int left, int right) {
        if(left==right) return nums[left];
        int mid=(left+right)>>1;
        int l=majorityCount(nums,left,mid);
        int r=majorityCount(nums,mid+1,right);
        if(l==r) return l;
        int leftCount=count(nums,l,left,right);
        int rightCount=count(nums,r,left,right);
        return leftCount>rightCount?l:r;
    }

    private int count(int[] nums, int l, int left, int right) {
        int c=0;
        for (int i = 0; i <nums.length ; i++) {
            if(l==nums[i]) c++;
        }
        return c;
    }
}
