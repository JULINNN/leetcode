
public class RotateList_61 {



    public static void main(String[] args) {
        SimpleUtil.ListNode node1 = new SimpleUtil.ListNode(0);
        SimpleUtil.ListNode node2 = new SimpleUtil.ListNode(1);
        SimpleUtil.ListNode node3 = new SimpleUtil.ListNode(2);
        SimpleUtil.ListNode node4 = new SimpleUtil.ListNode(3);
        SimpleUtil.ListNode node5 = new SimpleUtil.ListNode(4);
        SimpleUtil.ListNode node6 = new SimpleUtil.ListNode(5);


        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;


        rotateRight(node1, 4);
    }


    public static SimpleUtil.ListNode rotateRight(SimpleUtil.ListNode head, int k) {

        if (head == null) {
            return null;
        }
        SimpleUtil.ListNode curNode = head;
        SimpleUtil.ListNode lastNode;
        int c = 1;
        while (curNode.next != null) {
            curNode = curNode.next;
            c++;
        }
        lastNode = curNode;


        int rotateIndex = c - k % c;

        c = 1;
        curNode = head;
        while (c++ != rotateIndex) {
            curNode = curNode.next;
        }

        lastNode.next = head;
        head = curNode.next;
        curNode.next = null;

        return head;
    }


}
