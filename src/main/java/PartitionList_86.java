public class PartitionList_86 {

    public static void main(String[] args) {

        SimpleUtil.ListNode node1 = new SimpleUtil.ListNode(1);
        SimpleUtil.ListNode node2 = new SimpleUtil.ListNode(4);
        SimpleUtil.ListNode node3 = new SimpleUtil.ListNode(3);
        SimpleUtil.ListNode node4 = new SimpleUtil.ListNode(2);
        SimpleUtil.ListNode node5 = new SimpleUtil.ListNode(5);
        SimpleUtil.ListNode node6 = new SimpleUtil.ListNode(2);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

       node1 = partition(node1,3);

        SimpleUtil.printNode(node1);
    }

    public static SimpleUtil.ListNode partition(SimpleUtil.ListNode head, int x) {

        SimpleUtil.ListNode smallerNode = new SimpleUtil.ListNode();
        SimpleUtil.ListNode biggerNode = new SimpleUtil.ListNode();
        SimpleUtil.ListNode curNode = head;
        SimpleUtil.ListNode smallerHead = smallerNode;
        SimpleUtil.ListNode biggerHead = biggerNode;

        while (curNode != null) {

            if (curNode.val >= x) {
                biggerNode.next = new SimpleUtil.ListNode(curNode.val);
                biggerNode = biggerNode.next;
            } else {
                smallerNode.next = new SimpleUtil.ListNode(curNode.val);
                smallerNode = smallerNode.next;
            }
            curNode = curNode.next;
        }

        smallerNode.next = biggerHead.next;

        return smallerHead.next;
    }
}
