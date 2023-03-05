import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecoverBinarySearchTree_99 {

    public static void main(String[] args) {

    }

    public static void recoverTree(SimpleUtil.TreeNode root) {
        List<Integer> rtn = new ArrayList();
        recurse(root, rtn);
        Collections.sort(rtn);
        dfs(root, rtn);
    }

    public static void dfs(SimpleUtil.TreeNode root, List<Integer> rtn) {
        if (root == null) {
            return;
        }

        dfs(root.left,rtn);
        root.val = rtn.get(0);
        rtn.remove(0);
        dfs(root.right,rtn);
    }

    public static void recurse(SimpleUtil.TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        recurse(root.left, result);
        result.add(root.val);
        recurse(root.right, result);

    }
}
