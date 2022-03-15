package _2022_3_14;

import java.util.LinkedList;
import java.util.Queue;

public class _104_MaximumDepthOfBinaryTree_Method2_Iterative {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int height=0;
        int levelSize=1;
        while(!queue.isEmpty()){
            for (int i = 0; i < levelSize; i++) {
                TreeNode poll=queue.poll();
                if(poll.left!=null) queue.offer(poll.left);
                if(poll.right!=null) queue.offer(poll.right);
            }
            levelSize=queue.size();
            height++;
        }
        return height;

    }
}
