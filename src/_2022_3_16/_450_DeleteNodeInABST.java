package _2022_3_16;

public class _450_DeleteNodeInABST {
    // 这道题结合Leetcode 285. Inorder Successor in BST
    // 510 Inorder Successor in BST II
    // 700 Search in a Binary Search Tree
    public TreeNode deleteNode(TreeNode root, int key) {
        // 1.找到需要删除的节点,如果找不到直接return root
        if(root==null) return root;
        TreeNode node=searchNode(root,key);
        if(node==null) return root;
        // 2.考虑需要删除的节点的度
        // 2.1 degree of 2-->
        if(node.left!=null&&node.right!=null){
            TreeNode p=successor(root,node);
            node.val=p.val;
            node=p;
        }
        TreeNode replacement=node.left!=null? node.left:node.right;
        TreeNode parent=parent(root,node );
        // 2.2 degree of 1-->
        if(replacement!=null){
            //2.2.1 node=root
            if(parent==null){
                 root=replacement;
            }else{
                if(node==parent.left) parent.left=replacement;
                else parent.right = replacement;
            }
        }else{
            // 2.3 degree of 0-->
             // node =root
            if(parent==null) root=null;
            else{
                if(node==parent.left) parent.left=null;
                if(node==parent.right) parent.right=null;
            }
        }
        return root;

    }

    private TreeNode parent(TreeNode root, TreeNode node) {
        TreeNode curr = root;
        TreeNode parent=null;
        while (curr != node) {
            parent=curr;
            curr=curr.val>node.val?curr.left:curr.right;
        }
        return parent;
    }

    private TreeNode successor(TreeNode root, TreeNode node) {
        // 1. node.right!=null
        TreeNode s=node.right;
        if(s!=null){
            while(s.left!=null){
                s=s.left;
            }
            return s;
        }
        // 2. node.right==null
        TreeNode res=null;
        TreeNode curr=root;
        while(curr!=null) {
            curr = curr.val > node.val ? (res = curr).left : curr.right;
        }
        return res;
    }

    private TreeNode searchNode(TreeNode root, int key) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val > key) curr = curr.left;
            if (curr.val < key) curr = curr.right;
            else {
                return curr;
            }
        }
        return null;
    }
}
