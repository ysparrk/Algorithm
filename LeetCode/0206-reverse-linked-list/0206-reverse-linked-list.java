/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode tmpNode = new ListNode(); //현재 노드를 계속 맨 앞에 넣는다.

        ListNode cur = head;  //첫번째 노드

        while (cur != null) {
            ListNode nextNode = cur.next;

            cur.next = tmpNode.next;
            tmpNode.next = cur;
            cur = nextNode;
        }

        return tmpNode.next;
    }
}