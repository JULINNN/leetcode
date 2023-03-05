import java.util.*;
import java.util.stream.Collectors;

public class BinaryTreeLevelOrderTraversal_102 {

    public static void main(String[] args) {

        SimpleUtil.TreeNode root = new SimpleUtil.TreeNode(3);
        SimpleUtil.TreeNode node1 = new SimpleUtil.TreeNode(9);
        SimpleUtil.TreeNode node2 = new SimpleUtil.TreeNode(20);
        SimpleUtil.TreeNode node3 = new SimpleUtil.TreeNode(5);
        SimpleUtil.TreeNode node4 = new SimpleUtil.TreeNode(7);


        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        levelOrder(root).forEach(System.out::println);

    }

    public static List<List<Integer>> levelOrder(SimpleUtil.TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Deque<Map<Integer, SimpleUtil.TreeNode>> queue = new ArrayDeque<>();
        Map<Integer, List<Integer>> tmp = new HashMap<>();

        Map<Integer, SimpleUtil.TreeNode> poll = Map.of(0, root);

        while (poll != null) {

            poll.forEach((key, node) -> {

                tmp.putIfAbsent(key, new ArrayList<>());
                tmp.computeIfPresent(key, (k, v) -> {
                    v.add(node.val);
                    return v;
                });

                if (node.left != null)
                    queue.add(Map.of(key + 1, node.left));
                if (node.right != null)
                    queue.add(Map.of(key + 1, node.right));
            });
            poll = queue.poll();
        }
        return new ArrayList<>(tmp.values());
    }
}
