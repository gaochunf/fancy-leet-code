package leetcode.problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import leetcode.problems.data.TreeNode;

/**
 * 
 * https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/description/
 * 
 * @author gaochf
 *
 */

public class SmallestSubtreeWithDeepest {

	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		Map<TreeNode, Integer> node2layer = new HashMap<TreeNode, Integer>(); // layer, start from 1
		Map<TreeNode, TreeNode> node2parent = new HashMap<TreeNode, TreeNode>();
		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		nodeQueue.offer(root);
		node2layer.put(root, 1);
		int maxLayer = 1;

		while (!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.poll();
			int layer = node2layer.get(node) + 1;
			if (node.left != null) {
				node2layer.put(node.left, layer);
				node2parent.put(node.left, node);
				nodeQueue.offer(node.left);
				maxLayer = layer > maxLayer ? layer : maxLayer;
			}
			if (node.right != null) {
				node2layer.put(node.right, layer);
				node2parent.put(node.right, node);
				nodeQueue.offer(node.right);
				maxLayer = layer > maxLayer ? layer : maxLayer;
			}
		}

		List<TreeNode> commonNode = new ArrayList<TreeNode>();
		for (TreeNode node : node2layer.keySet()) {
			if (node2layer.get(node) == maxLayer) {
				commonNode.add(node);
			}
		}

		while (commonNode.size() > 1) {
			List<TreeNode> temp = new ArrayList<TreeNode>();
			for (TreeNode node : commonNode) {
				TreeNode parent = node2parent.get(node);
				if (!temp.contains(parent)) {
					temp.add(parent);
				}
			}
			commonNode = temp;
		}

		// find their common root
		return commonNode.get(0);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		SmallestSubtreeWithDeepest sswd = new SmallestSubtreeWithDeepest();
		System.out.println("result: " + sswd.subtreeWithAllDeepest(root).val);
	}

}
