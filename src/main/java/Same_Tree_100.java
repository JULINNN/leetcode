import java.util.ArrayList;
import java.util.List;

public class Same_Tree_100 {

    public static class TreeNode {
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
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode q1 = new TreeNode(1);
//        TreeNode q2 = new TreeNode(1);
        TreeNode q3 = new TreeNode(2);

        p1.left = p2;
        p1.right = p3;

        q1.right = q3;

        isSameTree(p1,q1);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> rtn1 = new ArrayList();
        List<Integer> rtn2 = new ArrayList();

        recurse(p,rtn1);
        recurse(q,rtn2);

        return rtn1.equals(rtn2);
    }


    public static void recurse(TreeNode root, List<Integer> result) {
        if (root == null) {
            result.add(Integer.MIN_VALUE);
            return;
        }

        result.add(root.val);
        recurse(root.left,result);
        recurse(root.right,result);

    }
}
