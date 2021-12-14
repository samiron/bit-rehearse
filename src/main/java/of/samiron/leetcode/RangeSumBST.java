package of.samiron.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 */
public class RangeSumBST {

    /**
     * 8 ms	47.4 MB
     */
    public int rangeSumBST(TreeNode root, int low, int high) {

        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;

        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode n = stack.pop();
            if(n.val >= low && n.val <= high) {
                sum += n.val;
            }

            if(n.left != null) stack.push(n.left);
            if(n.right != null) stack.push(n.right);
        }

        return sum;

    }

    /**
     * 7 ms	47.2 MB
     */
    public int rangeSumBSTQ(TreeNode root, int low, int high) {

        Queue<TreeNode> queue = new LinkedList<>();
        int sum = 0;

        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode n = queue.remove();
            if(n.val >= low && n.val <= high) {
                sum += n.val;
            }

            if(n.left != null) queue.add(n.left);
            if(n.right != null) queue.add(n.right);
        }

        return sum;

    }


    private int sum;
    private int low;
    private int high;

    /**
     * 1ms, 47.4 MB
     */
    public int rangeSumBSTRecursion(TreeNode root, int low, int high) {
        this.sum = 0;
        this.low = low;
        this.high = high;
        dfs(root);
        return sum;
    }

    private void dfs(TreeNode node) {
        if(node == null) return;
        if(node.val >= this.low && node.val <= high) sum += node.val;
        dfs(node.left);
        dfs(node.right);
    }


    public static void main(String[] args) {
        new RangeSumBST().rangeSumBST(treeNode(), 7, 15);
    }

    private static TreeNode treeNode() {
        return null;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
