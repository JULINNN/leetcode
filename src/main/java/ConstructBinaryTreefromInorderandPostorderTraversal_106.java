import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromInorderandPostorderTraversal_106 {

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        buildTree(inorder, postorder);
    }


    private static Map<Integer, Integer> inorderIndexMap = new HashMap<>();
    private static int postorderIndex = 0;

    public static SimpleUtil.TreeNode buildTree(int[] inorder, int[] postorder) {

        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap
                    .put(inorder[i], i);
        }

        postorderIndex = postorder.length - 1;
        return build(postorder, 0, postorder.length - 1);
    }

    public static SimpleUtil.TreeNode build(int[] postorder, int left, int right) {

        if (left > right) {
            return null;
        }

        int nodeVal = postorder[postorderIndex--];
        SimpleUtil.TreeNode node = new SimpleUtil.TreeNode(nodeVal);

        Integer inorderIndex = inorderIndexMap.get(nodeVal);
        node.right = build(postorder, inorderIndex + 1, right);
        node.left = build(postorder, left, inorderIndex - 1);
        return node;

    }


}
