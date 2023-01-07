package com.alorithm.normal;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 王贤
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        final RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        final ListNode fifth = new ListNode(5);
        final ListNode forth = new ListNode(4,fifth);
        final ListNode third = new ListNode(3,forth);
        final ListNode second = new ListNode(2,third);
        final ListNode first = new ListNode(1,second);
        System.out.println(removeNthFromEnd.removeNthFromEnd(first,2));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = dummy;
        while (cur !=null){
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0;i<n;i++){
            stack.pop();
        }
        ListNode prev= stack.peek();
        prev.next=prev.next.next;
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
