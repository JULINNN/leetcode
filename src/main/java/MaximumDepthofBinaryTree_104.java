public class MaximumDepthofBinaryTree_104 {

    public static void main(String[] args) {

    }

    public static int maxDepth(SimpleUtil.TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
