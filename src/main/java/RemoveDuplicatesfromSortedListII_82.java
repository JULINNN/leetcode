import java.util.Arrays;

public class RemoveDuplicatesfromSortedListII_82 {

    public static void main(String[] args) {
        SimpleUtil.ListNode node1 = new SimpleUtil.ListNode(1);
        SimpleUtil.ListNode node2 = new SimpleUtil.ListNode(1);
        SimpleUtil.ListNode node3 = new SimpleUtil.ListNode(1);
        SimpleUtil.ListNode node4 = new SimpleUtil.ListNode(1);
        SimpleUtil.ListNode node5 = new SimpleUtil.ListNode(1);
        SimpleUtil.ListNode node6 = new SimpleUtil.ListNode(1);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        node1 = deleteDuplicates(node1);

        SimpleUtil.printNode(node1);
    }

    public static SimpleUtil.ListNode deleteDuplicates(SimpleUtil.ListNode head) {
        if (head == null) {
            return null;
        }
        SimpleUtil.ListNode curNode = head.next;
        int[] vals = new int[300];
        Arrays.fill(vals, Integer.MIN_VALUE);
        int index = 0;
        boolean increase = true;
        vals[0] = head.val;
        while (curNode != null) {
            if (vals[index] != curNode.val) {
                if (increase)
                    vals[++index] = curNode.val;
                else
                    vals[index] = curNode.val;
                increase = true;
                curNode = curNode.next;
                continue;
            }
            increase = false;
            curNode = curNode.next;
        }
        if(!increase){
            vals[index] = Integer.MIN_VALUE;
        }

        SimpleUtil.ListNode rtnNode = new SimpleUtil.ListNode();
        SimpleUtil.ListNode rtnHead = rtnNode;
        if(vals[0] == Integer.MIN_VALUE)
            return null;
        int i = 0;
        while (vals[i + 1] != Integer.MIN_VALUE) {
            rtnNode.val = vals[i++];
            SimpleUtil.ListNode nextNode = new SimpleUtil.ListNode();
            rtnNode.next = nextNode;
            rtnNode = rtnNode.next;
        }
        rtnNode.val = vals[i];
        return rtnHead;
    }
}
