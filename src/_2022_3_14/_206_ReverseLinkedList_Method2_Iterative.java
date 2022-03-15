package _2022_3_14;

public class _206_ReverseLinkedList_Method2_Iterative {
    public ListNode reverseList(ListNode head){
        //  Time Complexity: O(n)
        //  Space Complexity：O(1)
        ListNode newNode=null;
        ListNode newHead=head;
        while(head!=null){
            newHead=head.next;
            head.next=newNode;
            newNode=head;
            head=newHead;
        }
        return newNode;
    }
}
