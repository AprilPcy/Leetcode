package _2022_3_15;

import java.util.LinkedList;
import java.util.Queue;

public class _111_MinimumDepthOfBinaryTree_Method1_Iterative {
    /*
        Time Complexity：O（n)
        Space Complexity: O(logn)

        递归: 1.确定递归函数的参数和返回值
              2.确定终止条件
     */
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int levelSize=1;
        int minHeight=1;
        while(!queue.isEmpty()){
            for (int i = 0; i <levelSize ; i++) {
                TreeNode poll=queue.poll();
                if(poll.left==null&&poll.right==null) return minHeight;
                if(poll.left!=null) queue.offer(poll.left);
                if(poll.right!=null) queue.offer(poll.right);
            }
            levelSize=queue.size();
            minHeight++;
        }
        return minHeight;


    }
}
