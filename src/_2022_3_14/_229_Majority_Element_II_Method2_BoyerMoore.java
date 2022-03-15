package _2022_3_14;

import java.util.LinkedList;
import java.util.List;

public class _229_Majority_Element_II_Method2_BoyerMoore {
    /*
      利用Boyer-Moore Voting Algorithm的思路
      Hint: How many majority elements could it possibly have?
      Solutions:
      There can be at most one majority element which is more than ⌊n/2⌋ times.
      There can be at most two majority elements which are more than ⌊n/3⌋ times.
      There can be at most three majority elements which are more than ⌊n/4⌋ times.
         所以,最多有两个Majority Element
       思路:
         1. 我们需要建立两个指针(因为可能有两个 Majority Element),这两个指针的数值不能相同 curr1 和curr2
            1.1 当遍历到某个元素的时候，我们发现这个元素的值与curr1和curr2都不相同，则count1--和count2--
            1.2 当这个元素的值与curr1相同时,count1++;
            1.3 当这个元素的值与curr2相同时,count2++;
            1.4 当count1=0 的时候,我们需要把让 curr1=nums[i],此时我们需要注意由于curr1和curr2不能相等，所以
            需要加入判定条件 count1==0&&nums[i]!=curr2，同理可得 count2=0的1情况
         2. 当遍历完所有的数值，我们得到curr1 和curr2，由于最多有两个 Majority Element，可能只有1个或者没有
            我们需要对 curr1和curr2 进行判定是否他们的数量大于 nums.length/3

       坑点： 1. 由于nums里面的数值可能为Integer中的任意数，我们初始化值的时候不能设置int curr2=0 或者其他数
         我们需要设置Integer curr2=null;
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list=new LinkedList<>();
        if(nums.length<2)  {
            list.add(nums[0]);
            return list;
        }
        int count1=1;
        int count2=0;
        int curr1=nums[0];
        Integer curr2=null;
        for (int i = 1; i < nums.length; i++) {
            if(count1==0&&nums[i]!=curr2){
                count1++;
                curr1=nums[i];
            }
            else if(count2==0&&nums[i]!=curr1){
                count2++;
                curr2=nums[i];
            }
            else if(nums[i]==curr1) count1++;
            else if(nums[i]==curr2) count2++;
            else {
                count1--;
                count2--;
            }
        }
        int c1=0;
        int c2=0;
        for (int i = 0; i < nums.length; i++) {
            if(curr1==nums[i]) c1++;
            if(curr2!=null&&curr2==nums[i]) c2++;
        }
        if(c1>nums.length/3) list.add(curr1);
        if(c2>nums.length/3) list.add(curr2);
        return list;


    }
}
