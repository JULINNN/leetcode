public class RemoveNthNode_19 {


    public static void main(String[] args) {
        SimpleUtil.ListNode node1 = new SimpleUtil.ListNode(1);
        SimpleUtil.ListNode node2 = new SimpleUtil.ListNode(2);
        SimpleUtil.ListNode node3 = new SimpleUtil.ListNode(3);
        SimpleUtil.ListNode node4 = new SimpleUtil.ListNode(4);
        SimpleUtil.ListNode node5 = new SimpleUtil.ListNode(5);
        SimpleUtil.ListNode node6 = new SimpleUtil.ListNode(6);


        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;


        removeNthFromEnd(node1, 3);

        print(node1);
    }

    public static SimpleUtil.ListNode removeNthFromEnd(SimpleUtil.ListNode head, int n) {
        SimpleUtil.ListNode curNode = head;
        int c = 0;
        while (curNode != null) {
            c++;
            curNode = curNode.next;
        }

        if (c == 1 && n == 1)
            return new SimpleUtil.ListNode();

        if (c == n) {
            return head.next;
        }

        int i = 0;
        curNode = head;
        while (i < c - n - 1) {
            curNode = curNode.next;
            i++;
        }
        curNode.next = curNode.next.next;
        return head;
    }


    public static void print(SimpleUtil.ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
