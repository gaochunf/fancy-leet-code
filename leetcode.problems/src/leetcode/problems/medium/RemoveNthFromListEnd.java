package leetcode.problems.medium;

import leetcode.problems.data.ListNode;

/**
 * 
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * 
 * @author gaochf
 *
 */
public class RemoveNthFromListEnd {

	public ListNode removeNthFromEnd(ListNode head, int n) {
//		if (head.next == null && n == 1) {
//			return null;
//		}
//		ListNode nthNode = head;
//		ListNode finalNode = head;
//		for (int gap = 0; gap <= n; gap++) {
//			finalNode = finalNode.next;
//		}
//		if (finalNode == null && nthNode == head) {
//			return head.next;
//		}
//		while (finalNode != null) {
//			nthNode = nthNode.next;
//			finalNode = finalNode.next;
//		}
//
//		nthNode.next = nthNode.next.next;

		// calculate length first
		int length = 0;
		ListNode temp = head;
		while (temp != null) {
			length++;
			temp = temp.next;
		}
		int steps = length - n;
		temp = head;
		for (int step = 1; step < steps; step++) {
			temp = temp.next;
		}
		if (steps == 0) {
			return head.next;
		} else {
			temp.next = temp.next.next;
		}
		return head;
	}

	public static void main(String[] args) {

	}

}
