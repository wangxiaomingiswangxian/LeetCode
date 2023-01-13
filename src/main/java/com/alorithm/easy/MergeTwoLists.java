package com.alorithm.easy;


/**
 * @author 王贤
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        final MergeTwoLists mergeTwoLists = new MergeTwoLists();
        final ListNode listNode = new ListNode(4);
        final ListNode listNode1 = new ListNode(2,listNode);
        final ListNode listNode2 = new ListNode(1,listNode1);
        final ListNode listNode3 = new ListNode(4);
        final ListNode listNode4 = new ListNode(3,listNode3);
        final ListNode listNode5 = new ListNode(1,listNode4);
        System.out.println(mergeTwoLists.mergeTwoLists(listNode2,listNode5).val);

        final ListNode listNode6 = new ListNode();

    }

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode sentry = new ListNode(-101);
        doMerge(sentry,list1,list2);
        return sentry.next;
    }

    public void doMerge(ListNode merge, ListNode list1, ListNode list2) {
        if (list1 == null) {
            merge.next = list2;
            return;
        }
        if (list2 == null) {
            merge.next = list1;
            return;
        }
        if (list1.val < list2.val) {
            merge.next = list1;
            doMerge(merge.next,list1.next,list2);
        }else {
            merge.next = list2;
            doMerge(merge.next,list1,list2.next);
        }

    }

}
