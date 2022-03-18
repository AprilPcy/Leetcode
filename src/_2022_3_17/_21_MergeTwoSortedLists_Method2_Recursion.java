package _2022_3_17;

public class _21_MergeTwoSortedLists_Method2_Recursion {
    // Time complexity is O(n+m)
    // Space complexity is O(1）
    // 1.考虑返回值和下一层
       // 2. 考虑边界值
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        if(list1.val<list2.val){
            list1.next=mergeTwoLists(list1.next,list2);
            return list1;
        }else{
            list2.next=mergeTwoLists(list1,list2.next);
            return list2;
        }

    }

}
