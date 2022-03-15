package _2022_3_14;

public class _104_MaximumDepthofBinaryTree_Method1_Recursion {
    public int maxDepth(TreeNode root) {
        //  Time Complexity: O(n)
        //  Space Complexity： best O(logn) worst O(n)
        if(root==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
