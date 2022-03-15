package _2022_3_15;

public class _53_MaximumSubarray_Method1_DivideAndConquer {
    // subArray 是连续的子数组，subSequence可以不连续
    // Divide and Conquer
    /*  3种情况：
        1.The maximum subarray contained only in the left side
        2.The maximum subarray contained only in the right side
        3.The maximum subarray that can use elements from both sides
           Time Complexity: a=2,b=2,d=1--->  log(b,a)=d --->O(n^d(logn))
                                      所以是 O(nlogn)
           Space Complexity: O(logn)
     */
    public int maxSubArray(int[] nums) {
        return maxSubArray(nums,0,nums.length-1);
    }

    private int maxSubArray(int[] nums, int left, int right) {
        int mid=(left+right)>>1;
        if(right==left) return nums[left];
        //1.最大子数组在[Left,mid]
        int leftMax=maxSubArray(nums,left,mid);
        //2. 最大子数组在[mid+1,right]
        int rightMax=maxSubArray(nums,mid+1,right);
        int max=Math.max(leftMax,rightMax);
        //3.最大数组在[left,mid]+[mid+1,right]
        int L=Integer.MIN_VALUE;
        int leftSum=0;
        for (int i = mid; i >=left ; i--) {
              leftSum+=nums[i];
              L=Math.max(leftSum,L);
        }
        int R=Integer.MIN_VALUE;
        int rightSum=0;
        for (int i = mid+1; i <=right ; i++) {
              rightSum+=nums[i];
              R=Math.max(rightSum,R);
        }
        int sum=L+R;
        return Math.max(sum,max);

    }
}
