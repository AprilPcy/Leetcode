package _2022_3_17;

public class _21_MergeTwoSortedLists_Method1_Iterative {
    // my first own writing version
    // 利用mergeSort的思路
    // Time complexity is O(n+m)
    // Space complexity is O(1)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode dummy=new ListNode(0,list1);
        ListNode curr=dummy;
        while(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                curr.next=list1;
                list1=list1.next;
            }else{
                curr.next=list2;
                list2=list2.next;
            }
            curr=curr.next;
        }
        while(list1!=null){
            curr.next=list1;
            list1= list1.next;
            curr=curr.next;
        }
        while(list2!=null){
            curr.next=list2;
            list2=list2.next;
            curr=curr.next;
        }
        return dummy.next;
    }
    //my optimized version 一样的方法 进一步优化
    //ierative
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode dummy=new ListNode(0,list1);
        ListNode curr=dummy;
        while(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                curr.next=list1;
                list1=list1.next;
            }else{
                curr.next=list2;
                list2=list2.next;
            }
            curr=curr.next;
        }
        curr.next=list1!=null?list1:list2;
        return dummy.next;
    }
}
