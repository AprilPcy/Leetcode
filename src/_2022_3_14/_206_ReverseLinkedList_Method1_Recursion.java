package _2022_3_14;

public class _206_ReverseLinkedList_Method1_Recursion {
    public ListNode reverseList(ListNode head) {
        //  Time Complexity: O(n)
        //  Space Complexity：O(n)
        if(head==null||head.next==null) return head;
        ListNode newHead=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }

}
