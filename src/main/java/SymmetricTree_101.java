public class SymmetricTree_101 {


    public static void main(String[] args) {

    }

    public static boolean isSymmetric(SimpleUtil.TreeNode root) {
        return helper(root.left,root.right);
    }

    public static boolean helper(SimpleUtil.TreeNode left, SimpleUtil.TreeNode right){
        if(left == null && right != null)
            return false;
        if(left != null && right == null)
            return false;
        if (left == null && right == null)
            return true;
        if(left.val != right.val)
            return false;

        return helper(left.left, right.right) && helper(left.right, right.left);

    }
}
