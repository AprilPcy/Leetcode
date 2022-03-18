package _2022_3_17;

public class _148_SortedList {
    // Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
    // Time complexity is :O(nlogn)
    // Space complexity : O(1)
    // 1. 寻找LinkedList的中间节点,我们首先考虑到的就是用Two Pointer 去找到他的中间节点
    // 2. 我们需要把一个链表分成两个链表，比较他们的大小，需要用到MergeSort的思路
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode curr=head;
        ListNode mid=getMid(curr);
        ListNode left=sortList(curr);
        ListNode right=sortList(mid.next);
        ListNode res=merge(left,right);
        return res;

    }

    private ListNode merge(ListNode left, ListNode right) {
        // Leetcode 21 Merge Two Sorted List
        if(left==null) return right;
        if(right==null) return left;
        if(left.val<right.val){
            left.next=merge(left.next,right);
            return left;
        }else{
            right.next=merge(left,right.next);
            return right;
        }

    }
    private ListNode getMid(ListNode head) {
        // Leetcode 876 Middle Of The LinkedList
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow.next;
        slow.next=null;
        return mid;
    }


}
