package leetcode.problems.medium;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.problems.data.TreeNode;

public class BottomLeftTreeValue {

	public int findBottomLeftValue(TreeNode root) {
		int result = root.val;
		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		nodeQueue.offer(root);
		while (!nodeQueue.isEmpty()) {
			TreeNode resultNode = nodeQueue.poll();
			result = resultNode.val;
			if (resultNode.right != null) {
				nodeQueue.offer(resultNode.right);
			}
			if (resultNode.left != null) {
				nodeQueue.offer(resultNode.left);
			}
		}
		return result;
	}

	public static void main(String[] args) {

	}

}
