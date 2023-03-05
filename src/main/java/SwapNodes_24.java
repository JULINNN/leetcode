import java.util.List;

public class SwapNodes_24 {


    public static void main(String[] args) {
        SimpleUtil.ListNode node1 = new SimpleUtil.ListNode(1);
        SimpleUtil.ListNode node2 = new SimpleUtil.ListNode(2);
        SimpleUtil.ListNode node3 = new SimpleUtil.ListNode(3);
        SimpleUtil.ListNode node4 = new SimpleUtil.ListNode(4);
        SimpleUtil.ListNode node5 = new SimpleUtil.ListNode(5);
        SimpleUtil.ListNode node6 = new SimpleUtil.ListNode(6);
//        ListNode node6 = new ListNode(7);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;


        print(swapPairs(node1));
    }

    public static SimpleUtil.ListNode swapPairs(SimpleUtil.ListNode head) {

        SimpleUtil.ListNode curNode = head;



        SimpleUtil.ListNode rtnNode = new SimpleUtil.ListNode();
        SimpleUtil.ListNode lastNode = rtnNode;

        SimpleUtil.ListNode remain = head;
        if(remain.next == null)
            return head;

        while (remain != null && remain.next != null) {
            SimpleUtil.ListNode nextNode = curNode.next;
            SimpleUtil.ListNode tmpNode = curNode.next.next;
            nextNode.next = curNode;
            curNode.next = tmpNode;
            remain = tmpNode;
            lastNode.next = nextNode;

            lastNode = curNode;
            curNode = tmpNode;
        }

        return rtnNode.next;
    }

    public static void print(SimpleUtil.ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
