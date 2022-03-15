package _2022_3_14;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class _169_MajorityElement_Method1_HashMap {
    /*
       Time Complexity: O(n)
       Space Complexity：O(n)
      坑点：1. 假设map中已经有key=1,value=2,当加入一个新的key=1,value=3的时候会覆盖旧
                因此map中的key=1，value=3

           2. HashMap不能根据value去找到它的key值，只能根据key找到他的value，
               也就是map.get()--根据key找到value

           3. Collection entrySet=map.entrySet();
              map.entrySet中的值为EntrySet<Map.Entry<K,V>> 是以键值对的形式存在的
                Entry<K,V> 是Map<K,V>的内部Interface
                  for (Object set:entrySet){
                     Map.Entry m=(Map.Entry) set;
                  }
     */
    public int majorityElement(int[] nums) {
        if(nums.length<2) return nums[0];
        HashMap<Integer,Integer> map=new HashMap<>();

        for (int i = 0; i <nums.length ; i++) {
             if(map.containsKey(nums[i])){
                 map.put(nums[i],map.get(nums[i])+1);
             }else{
                 map.put(nums[i],1);
             }
        }
        int max=Integer.MIN_VALUE;
        int res=Integer.MIN_VALUE;
        Collection entrySet=map.entrySet();
        for (Object set:entrySet){
            Map.Entry m=(Map.Entry) set;
            int value=(int)m.getValue();
            int key=(int)m.getKey();
            if(max<value){
                max=value;
                res=key;
            }
        }
        return res;
    }
}
