package leetcode.problems.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * https://leetcode.com/problems/apply-operations-to-make-string-empty/description/
 * 
 * @author gaochf
 *
 */
public class ApplyOperationsToMakeStringEmpty {
	public String lastNonEmptyString(String s) {
		Map<Character, Integer> charCount = new HashMap<Character, Integer>();
		Map<Character, Integer> charLastIndex = new HashMap<Character, Integer>();
		int maxCount = 0;
		for (int index = 0; index < s.length(); index++) {
			char charV = s.charAt(index);
			if (charCount.containsKey(charV)) {
				int count = charCount.get(charV) + 1;
				charCount.put(charV, count);
				maxCount = count > maxCount ? count : maxCount;
			} else {
				maxCount = 1 > maxCount ? 1 : maxCount;
				charCount.put(charV, 1);
			}
			charLastIndex.put(charV, index);
		}

		Map<Integer, Character> lastIndex2Count = new HashMap<Integer, Character>();
		for (Character charV : charCount.keySet()) {
			if (charCount.get(charV) == maxCount) {
				lastIndex2Count.put(charLastIndex.get(charV), charV);
			}
		}

		StringBuffer result = new StringBuffer();
		while (!lastIndex2Count.isEmpty()) {
			int minIndex = s.length();
			for (Integer index : lastIndex2Count.keySet()) {
				minIndex = index < minIndex ? index : minIndex;
			}
			result.append(lastIndex2Count.get(minIndex));
			lastIndex2Count.remove(minIndex);
		}

		return result.toString();

	}
//	public String lastNonEmptyString(String s) {
//		StringBuffer removeAfter = new StringBuffer(s);
//		StringBuffer temp = new StringBuffer();
//
//		List<Character> dup = new ArrayList<Character>();
//		String result = s;
//
//		while (!removeAfter.isEmpty()) {
//			dup.clear();
//			temp = new StringBuffer();
//			result = removeAfter.toString();
//
//			for (int index = 0; index < removeAfter.length(); index++) {
//				char charV = removeAfter.charAt(index);
//				if (dup.contains(charV)) {
//					temp.append(charV);
//				} else {
//					dup.add(charV);
//				}
//			}
//			
//			removeAfter.setLength(0);
//			removeAfter.append(temp);
//		}
//
//		return result;
//	}

	public static void main(String[] args) {

		ApplyOperationsToMakeStringEmpty ao2mse = new ApplyOperationsToMakeStringEmpty();
		String param = "aabcbbca";
		System.out.println(param + ": " + ao2mse.lastNonEmptyString(param));

		param = "abcd";
		System.out.println(param + ": " + ao2mse.lastNonEmptyString(param));

	}
}
