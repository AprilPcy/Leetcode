package _2022_3_16;

import java.util.LinkedList;
import java.util.List;

public class _315_CountOfSmallerNumbersAfterSelf {
    // Time complexity: O(logn)
    // Space complexity: O(n)
    private class Items{
        int item;
        int index;

        public Items(int item, int index) {
            this.item = item;
            this.index = index;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list=new LinkedList<>();
        if(nums.length==1) {
            list.add(0);
            return list;
        }
        Items[] items=new Items[nums.length];
        for (int i = 0; i <nums.length ; i++) {
            items[i]=new Items(nums[i],i);
        }
        int[] count=new int[nums.length];
        countSmaller(items,count,0,nums.length-1);
        for(int c:count){
            list.add(c);
        }
        return list;
    }

    public void countSmaller(Items[] item,int[] nums,int left,int right) {
          if(left==right) return ;
          int mid=(left+right)>>1;
          countSmaller(item,nums,left,mid);
          countSmaller(item,nums,mid+1,right);
          merge(item,nums,left,mid,right);
    }

    private void merge(Items[] item,int[] count, int left, int mid, int right) {
        Items []temp=new Items[right-left+1];
        int L=left;
        int R=mid+1;
        int i=0;
        int k=0;
        while(L<=mid&&R<=right){
            if(item[L].item>item[R].item){
                count[item[L].index]+=(right-R+1);
                temp[i++]=item[L++];
            }else{
                temp[i++]=item[R++];
            }
        }
        while(L<=mid) {
             temp[i++]=item[L++];

        }
        while(R<=right) {
            temp[i++]=item[R++];
        }
        for (int j = 0; j <temp.length ; j++) {
            item[left+j]=temp[j];

        }

    }
}
