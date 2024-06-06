package leetcode.problems.medium;

import java.util.Arrays;

/**
 * 
 * https://leetcode.com/problems/hand-of-straights/description/?envType=daily-question&envId=2024-06-06
 * 
 * @author gaochf
 *
 */

public class HandOfStraights {

	public boolean isNStraightHand(int[] hand, int groupSize) {
		if (hand.length % groupSize > 0) {
			return false;
		}
		if (groupSize == 1) {
			return true;
		}
		Arrays.sort(hand);
		int startIndex = 0;
		boolean startIndexSet = false;
		int groupMatched = 0;
		int previousValue = -1;
		while (startIndex < hand.length) {
			// reset
			if (groupMatched == 0) {
				previousValue = hand[startIndex];
				groupMatched = 1;
				hand[startIndex] = -1;
				startIndexSet = false;
			}
			for (int index = startIndex + 1; index < hand.length; index++) {
				if (hand[index] == previousValue + 1) {
					previousValue = previousValue + 1;
					hand[index] = -1;
					groupMatched++;
				} else if (hand[index] == previousValue) {
					if (!startIndexSet) {
						startIndex = index;
						startIndexSet = true;
					}
				} else if (hand[index] == -1) {
					// do nothing ,jues continue
					continue;
				} else {
					return false;
				}

				if (groupMatched == groupSize) {
					if (!startIndexSet) {
						startIndex = index + 1;
					}
					break;
				}
			}

			if (groupMatched < groupSize) {
				return false;
			} else {
				groupMatched = 0;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		HandOfStraights hs = new HandOfStraights();
		int[] hand = new int[] { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
		int groupSize = 3;
		System.out.println("result: " + hs.isNStraightHand(hand, groupSize));

		hand = new int[] { 1, 1, 2, 2, 3, 3 };
		groupSize = 3;
		System.out.println("result: " + hs.isNStraightHand(hand, groupSize));
	}
}
