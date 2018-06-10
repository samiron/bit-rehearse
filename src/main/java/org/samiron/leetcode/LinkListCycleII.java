package org.samiron.leetcode;

import java.util.HashSet;
import java.util.List;

public class LinkListCycleII {

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[]{
                makeList(false),
                makeList(true),
                null
        };
        LinkListCycleII solution = new LinkListCycleII();
        for (ListNode listHead : lists) {
            ListNode result = solution.detectCycle(listHead);
            if (result == null) {
                System.out.println("No cycle exists");
            } else {
                System.out.println("Cycle starts from:" + result.val);
            }
        }
    }

    private static ListNode makeList(boolean isCyclic) {
        /**
         * 1 -> 2 -> 3 -> 4
         *      ^---------|
         */

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        if (isCyclic) {
            head.next.next.next.next = head.next; //The loop
        }

        return head;
    }

    /**
     * base cases
     * - 1 element -> self loop
     * - 2 elements -> second element pointing to first
     * - n elements -> Last one is pointing to anyone
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        HashSet<ListNode> visitedNodes = new HashSet<>();
        visitedNodes.add(head);
        ListNode cursor = head.next;
        boolean cycleFound = false;
        while (cursor != null && !cycleFound) {
            if (visitedNodes.contains(cursor.next)) {
                cycleFound = true;
            }
            visitedNodes.add(cursor);
            cursor = cursor.next;
        }
        return cursor == null ? null : cursor;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
