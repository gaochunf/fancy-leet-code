package leetcode.problems.medium;

import java.util.Stack;

import leetcode.problems.data.ListNode;

/**
 * 
 * https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/
 * 
 * @author gaochf
 *
 */

public class DoubleNumberAsLinkedList {
	public ListNode doubleIt(ListNode head) {
		Stack<ListNode> nodestack = new Stack<ListNode>();
		ListNode stacknode = head;
		while (stacknode != null) {
			nodestack.push(stacknode);
			stacknode = stacknode.next;
		}

		int incre = 0;
		while (!nodestack.isEmpty()) {
			ListNode curNode = nodestack.pop();
			int value = curNode.val;
			value = value * 2 + incre;
			incre = (int) (value / 10);
			value = value % 10;

			curNode.val = value;
		}

		if (incre > 0) {
			ListNode newHead = new ListNode(incre, head);
			head = newHead;
		}

		return head;

	}

	public static void main(String[] args) {

	}

}
