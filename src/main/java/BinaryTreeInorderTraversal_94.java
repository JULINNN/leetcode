import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal_94 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List result = new ArrayList();
        recurse(root,result);
        return result;

    }

    public void recurse(TreeNode root,List<Integer> result) {
        if (root == null) {
            return;
        }

        recurse(root.left,result);
        result.add(root.val);
        recurse(root.right,result);

    }
}
