package of.samiron.leetcode;

/**
 * Leetcode 2: https://leetcode.com/problems/add-two-numbers/
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = null;
        ListNode pointer = null;

        while(l1 != null || l2 != null) {

            int tempsum = carry;
            if(l1 != null) {
                tempsum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                tempsum += l2.val;
                l2 = l2.next;
            }

            carry = tempsum > 9 ? tempsum / 10 : 0;
            int resultDigit = tempsum % 10;

            if(result == null) {
                result = new ListNode(resultDigit);
                pointer = result;
            } else {
                pointer.next = new ListNode(resultDigit);
                pointer = pointer.next;
            }

        }

        if(carry != 0) {
            pointer.next = new ListNode(carry);
        }

        return result;



    }

    private void doIt() {
        print(addTwoNumbers(number(2, 4, 3), number(5, 6, 4)));
        print(addTwoNumbers(number(1), number(0, 0, 1)));
        print(addTwoNumbers(number(9, 9, 9), number(9, 9, 9)));

    }

    private ListNode number(Integer... digits) {
        ListNode head = new ListNode(digits[0]);
        ListNode pointer = head;
        for(int i = 1 ; i < digits.length ; i++) {
            pointer.next = new ListNode(digits[i]);
            pointer = pointer.next;
        }
        return head;
    }

    private void print(ListNode number) {
        ListNode pointer = number;
        while(pointer != null) {
            System.out.print(pointer.val);
            pointer = pointer.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new AddTwoNumbers().doIt();
    }


}
