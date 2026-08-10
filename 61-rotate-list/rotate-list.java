class Solution {

    public ListNode findNthNode(ListNode head, int k) {
        ListNode temp = head;

        for(int i = 1; i < k; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode tail = head;
        int len = 1;

        while(tail.next != null) {
            len++;
            tail = tail.next;
        }

        k = k % len;

        if(k == 0) {
            return head;
        }

        tail.next = head;

        ListNode newNode = findNthNode(head, len - k);

        head = newNode.next;
        newNode.next = null;

        return head;
    }
}