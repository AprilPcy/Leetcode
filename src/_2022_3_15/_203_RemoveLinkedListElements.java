package _2022_3_15;

public class _203_RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        // Time complexity:O(n)
        // Space complexity:O(1)
        /*
          因为有可能删除的是第一个节，所以利用虚拟节点的想法
         */
        if(head==null) return head;
        ListNode dummy=new ListNode(0,head);
        ListNode curr=dummy;
        while(curr!=null&&curr.next!=null){
            if(curr.next.val==val){
                curr.next=curr.next.next;
            }else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
