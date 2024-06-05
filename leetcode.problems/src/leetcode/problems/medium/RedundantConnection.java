package leetcode.problems.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * https://leetcode.com/problems/redundant-connection/description/
 * 
 * @author gaochf
 *
 */
public class RedundantConnection {

	public int[] findRedundantConnection(int[][] edges) {
		int[] result = null;
		// node value to flag
		int[] nodes = new int[edges.length + 1];
		int maxFlag = 1;

		for (int index = 0; index < edges.length; index++) {
			int[] edge = edges[index];
			if (nodes[edge[0]] != 0 && nodes[edge[1]] != 0) {
				if (nodes[edge[0]] == nodes[edge[1]]) {
					// redundant edge
					result = edge;
				} else {
					int edge0flag = nodes[edge[0]];
					int edge1flag = nodes[edge[1]];
					for (int nodeindex = 0; nodeindex < nodes.length; nodeindex++) {
						if (nodes[nodeindex] == edge1flag) {
							nodes[nodeindex] = edge0flag;
						}
					}
				}
			} else if (nodes[edge[0]] == 0 && nodes[edge[1]] == 0) {
				int currentFlag = maxFlag++;
				nodes[edge[0]] = currentFlag;
				nodes[edge[1]] = currentFlag;
			} else if (nodes[edge[0]] != 0 && nodes[edge[1]] == 0) {
				// 1 is new
				nodes[edge[1]] = nodes[edge[0]];
			} else if (nodes[edge[0]] == 0 && nodes[edge[1]] != 0) {
				// 0 is new
				nodes[edge[0]] = nodes[edge[1]];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		RedundantConnection rc = new RedundantConnection();
		int[][] param = new int[3][2];
		param[0] = new int[] { 1, 2 };
		param[1] = new int[] { 1, 3 };
		param[2] = new int[] { 2, 3 };
		int[] result = rc.findRedundantConnection(param);
		System.out.println("Result: [" + result[0] + ", " + result[1] + "]");
	}

}

/**
 * wrong answer, it is due to the behavior of Map. If modifinf map during
 * iterating the map, the final result is undefined !!!
 */
//class Solution {
//    public int[] findRedundantConnection(int[][] edges) {
//        int[] result = null;
//		// node value to flag
//		Map<Integer, Integer> nodes = new HashMap<Integer, Integer>();
//		int maxFlag = 1;
//		
//		for (int index = 0; index < edges.length; index++) {
//			int[] edge = edges[index];
//			if (nodes.containsKey(edge[0]) && nodes.containsKey(edge[1])) {
//				if (nodes.get(edge[0]) == nodes.get(edge[1])) {
//					// redundant edge
//					result = edge;
//				} else {
//					int edge0flag = nodes.get(edge[0]);
//					int edge1flag = nodes.get(edge[1]);
//					for (Integer key : nodes.keySet()) {
//						if (nodes.get(key) == edge0flag) {
//							nodes.put(key, edge1flag);
//						}
//					}
//				}
//			} else if (!nodes.containsKey(edge[0]) && !nodes.containsKey(edge[1])) {
//				int currentFlag = maxFlag++;
//				nodes.put(edge[0], currentFlag);
//				nodes.put(edge[1], currentFlag);
//			} else if (nodes.containsKey(edge[0]) && !nodes.containsKey(edge[1])) {
//				// 1 is new
//				nodes.put(edge[1], nodes.get(edge[0]));
//			} else if (!nodes.containsKey(edge[0]) && nodes.containsKey(edge[1])) {
//				// 0 is new
//				nodes.put(edge[0], nodes.get(edge[1]));
//			}
//		}
//		return result;
//    }
//}
