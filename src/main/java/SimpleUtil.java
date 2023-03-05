import java.util.function.Consumer;

public class SimpleUtil {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }


        public static ListNode listNodeFactory() {

            SimpleUtil.ListNode node1 = new SimpleUtil.ListNode(1);
            SimpleUtil.ListNode node2 = new SimpleUtil.ListNode(2);
            SimpleUtil.ListNode node3 = new SimpleUtil.ListNode(3);
            SimpleUtil.ListNode node4 = new SimpleUtil.ListNode(4);
            SimpleUtil.ListNode node5 = new SimpleUtil.ListNode(5);
            SimpleUtil.ListNode node6 = new SimpleUtil.ListNode(6);


            node1.next = node2;
            node2.next = node3;
            node3.next = node4;
            node4.next = node5;
            node5.next = node6;
            return node1;
        }
    }


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

    public static void treeTravel(TreeNode root, Consumer<TreeNode> consumer) {
        if (root == null) {
            return;
        }
        treeTravel(root.left, consumer);
        consumer.accept(root);
        treeTravel(root.right, consumer);
    }

    public static void printTree(TreeNode root) {
        treeTravel(root, node -> System.out.println(node.val));
    }


    public static void nodeForLoop(ListNode listNode, Consumer<ListNode> comsumer) {
        ListNode curNode = listNode;
        while (curNode != null) {
            comsumer.accept(curNode);
            curNode = curNode.next;
        }
    }

    public static void printNode(ListNode listNode) {
        nodeForLoop(listNode, node -> System.out.println(node.val));
    }

    public static void printMatrix(int[][] matrix) {

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%5d", anInt);
            }
            System.out.println();
        }
    }
}
