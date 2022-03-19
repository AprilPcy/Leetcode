package _2022_3_18;

public class _24_SwapNodesInPairs {
    // Time complexity: O(n)
    // Space complexity: O(1)
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0,head);
        ListNode curr=dummy;
        while(head!=null&&head.next!=null){
            ListNode left=head;
            ListNode right=head.next;

            //swap
            curr.next=right;
            left.next=right.next;
            right.next=left;

            //moving to the next
            curr=left;
            head=left.next;


        }
        return dummy.next;

    }
}
