package _2022_3_15;

public class _111_MinimumDepthOfBinaryTree_Method1_Recursion {
    /*
        Time Complexity：O（n)
        Space Complexity: O(logn)
        与maxDepth的区别就是minDepth需要考虑 [2,null,3,null,4,null,5,null,6] 的情况
         即：这棵树只有左孩子或者右孩子

        递归: 1.确定递归函数的参数和返回值
              2.确定终止条件
     */
    public int minDepth(TreeNode root) {
         int min=0;
         if(root==null) return 0;
         if(root.left!=null&&root.right!=null){
             min=Math.min(minDepth(root.left),minDepth(root.right));
         }
         else if(root.left!=null){
             min=minDepth(root.left);
         }else if(root.right!=null){
             min=minDepth(root.right);
         }
         return min+1;
    }
}
