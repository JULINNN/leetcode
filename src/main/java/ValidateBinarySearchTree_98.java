import java.util.*;

public class ValidateBinarySearchTree_98 {

    public static void main(String[] args) {


        SimpleUtil.TreeNode head = new SimpleUtil.TreeNode(2);
        head.left = new SimpleUtil.TreeNode(1);
        head.right = new SimpleUtil.TreeNode(3);

        System.out.println(isValidBST(head));
    }

    public static boolean isValidBST(SimpleUtil.TreeNode root) {
        List<Integer> result = new ArrayList<>();

        recurse(root,result);
        for (int i = 1; i < result.size(); i++) {
            if(result.get(i) <= result.get(i-1))
                return false;
        }

        return true;
    }

    public static void recurse(SimpleUtil.TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        recurse(root.left,result);
        result.add(root.val);
        recurse(root.right,result);

    }
}
