package _2022_3_14;

import java.util.*;

public class _229_Majority_Element_II_Method1_HashMap {
    /*
       Time Complexity: O(n)
       Space Complexity：O(n)
       思路参考LeetCode 169 Majority_Element
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list=new LinkedList<>();
        if(nums.length<2)  {
            list.add(nums[0]);
            return list;
        }
        int range=nums.length/3;
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            if(hashMap.containsKey(nums[i])){
                hashMap.put(nums[i],hashMap.get(nums[i])+1);
            }else{
                hashMap.put(nums[i],1);
            }
        }
        Set entrySet=hashMap.entrySet();
        for (Object set:entrySet){
            Map.Entry m=(Map.Entry) set;
            int value=(int)m.getValue();
            int key=(int)m.getKey();
            if(value>range){
                list.add(key);
            }

        }
        return list;

    }
}
