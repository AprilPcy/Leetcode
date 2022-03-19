package _2022_3_18;

public class _92_ReverseLinkedList_II {
    // My version
    // Time complexity: O(2*n)
    // Space complexity  reverse O(n) iterative O(1)
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null||head.next==null||left==right) return head;
        ListNode prev=Node(left-1,head);
        ListNode rightNode=Node(right,head);
        ListNode leftNode=prev.next;
        ListNode next=rightNode.next;
        reverse(leftNode,rightNode);
        leftNode.next=next;
        if(left==1) return rightNode;
        prev.next=rightNode;
        return head;
    }
    public ListNode Node(int index,ListNode head){
        ListNode node=head;
        for(int i=0;i<index-1;i++){
            node=node.next;
        }
        return node;
    }
    public void reverse(ListNode left,ListNode right){
        if(left==right) return ;
        reverse(left.next,right);
        left.next.next=left;
        left.next=null;
    }
    //Follow up: Could you do it in one pass?
    // Time complexity: O(n)
    // Space complexity O(1)
    public ListNode reverseBetween1(ListNode head, int left, int right) {
        if(head==null||head.next==null||left==right) return head;
        ListNode prev=null;
        ListNode curr=head;
        while(left>1){
            prev=curr;
            curr=curr.next;
            left--;
            right--;
        }
        ListNode last=curr;
        ListNode newNode=null;
        ListNode newCurr=null;
        while (right>0){
           newCurr=curr.next;
           curr.next=newNode;
           newNode=curr;
           curr=newCurr;
           right--;
        }
        last.next=newCurr;
        if(prev==null) return newNode;
        else prev.next=newNode;
        return head;
    }

}
