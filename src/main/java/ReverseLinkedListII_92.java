public class ReverseLinkedListII_92 {


    public static void main(String[] args) {


        SimpleUtil.ListNode listNode = SimpleUtil.ListNode.listNodeFactory();

        listNode = reverseBetween(listNode, 2, 5);

        SimpleUtil.printNode(listNode);
    }

    public static SimpleUtil.ListNode reverseBetween(SimpleUtil.ListNode head, int left, int right) {

        SimpleUtil.ListNode preNode = new SimpleUtil.ListNode();
        SimpleUtil.ListNode curNode = head;
        SimpleUtil.ListNode preLeft = new SimpleUtil.ListNode();
        SimpleUtil.ListNode preHead = preLeft;
        SimpleUtil.ListNode postRight = new SimpleUtil.ListNode();

        int count = 0;
        while (curNode != null) {

            count++;

            if (count  < left) {
                preLeft.next = new SimpleUtil.ListNode(curNode.val);
                preLeft = preLeft.next;
            }

            if(count == left){
                preNode = new SimpleUtil.ListNode(curNode.val);
                postRight = preNode;
            }

            if (left < count && right >= count) {
                SimpleUtil.ListNode tmpNode = curNode.next;
                curNode.next = preNode;
                preNode = curNode;
                curNode = tmpNode;
            } else {
                curNode = curNode.next;
            }

            if(right == count){
                postRight.next = curNode;
                preLeft.next = preNode;
                break;
            }
        }



        return preHead.next;
    }
}
