package leetcode.problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * 
 * @author gaochf
 *
 */

public class LongestSubstringWithoutRepeating {

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int index = 0;
		int subStringMax = 0;
		List<Character> subString = new ArrayList<>(s.length());
		for (index = 0; index < s.length(); index++) {
			for (int innerIndex = index; innerIndex < s.length(); innerIndex++) {
				char charAtInnerIndex = s.charAt(innerIndex);
				if (subString.contains(charAtInnerIndex)) {
					if (subString.size() > subStringMax) {
						subStringMax = subString.size();
						for (int i = 0; i < subString.size(); i++)
							System.out.print(subString.get(i));
						System.out.println('1');
					}
					subString.clear();
					break;
				} else {
					subString.add(charAtInnerIndex);
					// if whole string is not repeated
					if (innerIndex == s.length() - 1) {
						if (subString.size() > subStringMax) {
							subStringMax = subString.size();
							for (int i = 0; i < subString.size(); i++)
								System.out.print(subString.get(i));
							System.out.println('2');
							subString.clear();
							break;
						}
					}
				}
			}
		}

		return subStringMax;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeating lswp = new LongestSubstringWithoutRepeating();
		String param = "abcabcbb";
		System.out.println(param + ": " + lswp.lengthOfLongestSubstring(param));
		param = "bbbbb";
		System.out.println(param + ": " + lswp.lengthOfLongestSubstring(param));
		param = "pwwkew";
		System.out.println(param + ": " + lswp.lengthOfLongestSubstring(param));
		param = " ";
		System.out.println(param + ": " + lswp.lengthOfLongestSubstring(param));
		param = "jbpnbwwd";
		System.out.println(param + ": " + lswp.lengthOfLongestSubstring(param));
	}

}
