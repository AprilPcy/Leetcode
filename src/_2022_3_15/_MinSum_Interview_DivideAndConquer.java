package _2022_3_15;
/*
  题目: 给一个数字比如[1,3,2,5,6,4],找到左边比他小的数的总和
    example: 1-->null
            3-->1
            2-->1
            5-->1,2,3
            6-->1,2,3,5
            4-->1,2,3
            所以总和为 1+1+1+2+3+1+2+3+5+1+2+3=1*5+2*3+3*3+5*1=25
 */

import com.sun.jdi.PathSearchingVirtualMachine;

public class _MinSum_Interview_DivideAndConquer {
    /*
       找左边比它小数，其实是排序多找右边比他大的数乘以本身，比如
        1右边比它大的数有5个,所以1*5=5
        2右边比他大的数有3个,所以2*3=6
        3右边比它大的数有3个，所以3*3=9
        以此内推..
     我们可以用到MergeSort的思路,当开始Sort的时候，我们需要左右两边的数，此时我们可以
     找右边比左边大的数量乘以他本身
     */
    public static int MinSum(int[]arr){
        return MinSum(arr,0,arr.length-1);
    }
    public static int MinSum(int[]arr,int left,int right){
        if(left==right) return 0;
        int mid=(left+right)>>1;
        return MinSum(arr,left,mid)+MinSum(arr,mid+1,right)+Sort(arr,left,mid,right);
    }

    private static int Sort(int[] arr, int left, int mid, int right) {
        int[]temp=new int[right-left+1];
        int i=0;
        int L=left;
        int R=mid+1;
        int sum=0;
        while(L<=mid&&R<=right){
            sum+=arr[L]<arr[R]?arr[L]*(right-R+1):0;
            temp[i++]=arr[L]<arr[R]?arr[L++]:arr[R++];

        }
        while(L<=mid) temp[i++]=arr[L++];
        while(R<=right) temp[i++]=arr[R++];
        return sum;
    }

    public static void main(String[] args) {
        int []arr={1,3,4,2,5};
        System.out.println(MinSum(arr));

    }
}
