package _2022_3_18;

public class _237_DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        if(node==null||node.next==null) return;
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
