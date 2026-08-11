/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
         if(head == null) {
            return null;
        }
        Node temp=head;
        while (temp!=null){
            Node copyNode=new Node(temp.val);
            copyNode.next=temp.next;
            temp.next=copyNode;
            temp=copyNode.next;
        }
        connectRandomPointers(head);

        return connectNextPointers(head);
    }
    public void connectRandomPointers(Node head){
        Node temp=head;
        while(temp!=null){
            Node copyNode=temp.next;
            if(temp.random != null) {
    copyNode.random = temp.random.next;
}
            
            temp=copyNode.next;
        }
    }
    public Node connectNextPointers(Node head){
        Node dNode=new Node(-1);
        Node res=dNode;
        Node temp=head;
        while(temp!=null){
            res.next=temp.next;
            temp.next=temp.next.next;
            res=res.next;
            temp=temp.next;
        }
        return dNode.next;
    }
}
   




