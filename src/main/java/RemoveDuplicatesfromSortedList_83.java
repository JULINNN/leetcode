public class RemoveDuplicatesfromSortedList_83 {

    public static void main(String[] args) {
        SimpleUtil.ListNode node1 = new SimpleUtil.ListNode(1);
        SimpleUtil.ListNode node2 = new SimpleUtil.ListNode(2);
        SimpleUtil.ListNode node3 = new SimpleUtil.ListNode(2);
        SimpleUtil.ListNode node4 = new SimpleUtil.ListNode(4);
        SimpleUtil.ListNode node5 = new SimpleUtil.ListNode(5);
        SimpleUtil.ListNode node6 = new SimpleUtil.ListNode(6);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        node1 = deleteDuplicates(node1);

        SimpleUtil.printNode(node1);
    }

    public static SimpleUtil.ListNode deleteDuplicates(SimpleUtil.ListNode head) {
        if(head == null){
            return null;
        }
        SimpleUtil.ListNode curNode = head;
        int[] vals = new int[300];
        int index = 0;
        vals[0] = head.val;
        while (curNode.next != null) {
            if (vals[index] != curNode.next.val) {
                vals[++index] = curNode.next.val;
                curNode = curNode.next;
                continue;
            }
            curNode.next = curNode.next.next;
        }
        return head;
    }
}
