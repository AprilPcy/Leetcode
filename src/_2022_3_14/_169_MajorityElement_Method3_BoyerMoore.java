package _2022_3_14;



public class _169_MajorityElement_Method3_BoyerMoore {
    /*
      方法三: 利用Boyer-Moore Voting Algorithm的思路
         1. 假设我们设置这个数为x,其他数为y,由于我们需要找出超过一半的数,
             所以 x-y>0 也就是相互抵消的思路
         2. 所以我们首先从第一个数开始计数,设置count=1，当遇到与它不同的数，count-1，
           相同的数count+1,如果count=0 则从下一个数开始，重新count=1，当走到最后如果count!=0
           则那个数就是target
             Time Complexity: O(n)
             Space Complexity: O(1)
     */
    public int majorityElement(int[] nums){
        if(nums.length<2) return nums[0];
        int count=1;
        int curr=nums[0];
        for (int i = 1; i < nums.length ; i++) {
            curr=count==0?nums[i]:curr;
            count=curr==nums[i]?count+1:count-1;
        }
        return curr;

    }
}
