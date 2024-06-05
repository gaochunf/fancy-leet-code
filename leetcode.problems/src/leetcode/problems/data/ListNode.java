package leetcode.problems.data;

/**
 * 
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * 
 * @author gaochf
 *
 */

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
