import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII_95 {

    public static void main(String[] args) {

        generateTrees(3).forEach(SimpleUtil::printTree);

    }

    public static List<SimpleUtil.TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    public static List<SimpleUtil.TreeNode> helper(int start, int end) {
        List<SimpleUtil.TreeNode> rtn = new ArrayList<>();

        if (start > end) {
            rtn.add(null);
            return rtn;
        }

        for (int i = start; i <= end; i++) {
            List<SimpleUtil.TreeNode> lefts = helper(start, i - 1);
            List<SimpleUtil.TreeNode> rights = helper(i + 1, end);

            for(SimpleUtil.TreeNode left : lefts){
                for (SimpleUtil.TreeNode right : rights) {
                    SimpleUtil.TreeNode head = new SimpleUtil.TreeNode(i);
                    head.left = left;
                    head.right = right;
                    rtn.add(head);
                }
            }
        }

        return rtn;
    }
}
