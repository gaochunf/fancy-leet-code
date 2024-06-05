package leetcode.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 * 
 * @author gaochf
 *
 */

public class LetterCombinationOfPhoneNmuber {

	private static Map<Character, List<String>> mapping = new HashMap<Character, List<String>>();
	static {
		mapping.put('2', Arrays.asList("a", "b", "c"));
		mapping.put('3', Arrays.asList("d", "e", "f"));
		mapping.put('4', Arrays.asList("g", "h", "i"));
		mapping.put('5', Arrays.asList("j", "k", "l"));
		mapping.put('6', Arrays.asList("m", "n", "o"));
		mapping.put('7', Arrays.asList("p", "q", "r", "s"));
		mapping.put('8', Arrays.asList("t", "u", "v"));
		mapping.put('9', Arrays.asList("w", "x", "y", "z"));
	}

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		if (digits == null || digits.isEmpty()) {
			return result;
		}

		// init
		int[] indexValue = new int[digits.length()];
		for (int index = 0; index < indexValue.length; index++) {
			indexValue[index] = 0;
		}

		while (true) {
			// check if end
			{
				char charValue = digits.charAt(digits.length() - 1);
				if (indexValue[digits.length() - 1] >= mapping.get(charValue).size()) {
					break;
				}
			}
//			int numbers2Bound = 0;
//			for (int index = 0; index < digits.length(); index++) {
//				char charValue = digits.charAt(index);
//				int charLettersLength = mapping.get(charValue).size();
//				int charLetterIndex = indexValue[index];
//				if (charLetterIndex == charLettersLength - 1) {
//					numbers2Bound++;
//				} else {
//					break;
//				}
//			}
//			if (numbers2Bound == digits.length()) {
//				break;
//			}

			// add combination into result
			StringBuffer sb = new StringBuffer();
			for (int index = 0; index < digits.length(); index++) {
				char charValue = digits.charAt(index);
				int charLetterIndex = indexValue[index];
				sb.append(mapping.get(charValue).get(charLetterIndex));
			}
			result.add(sb.toString());
			sb.setLength(0); // cleanup the sb for re-use

			// step forward
			indexValue[0]++;
			// process carry
			for (int index = 0; index < digits.length() - 1; index++) {
				char charValue = digits.charAt(index);
				int charLettersLength = mapping.get(charValue).size();
				if (indexValue[index] == charLettersLength) {
					// carry
					indexValue[index] = 0;
					indexValue[index + 1]++;
				} else {
					break;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		LetterCombinationOfPhoneNmuber lcpn = new LetterCombinationOfPhoneNmuber();
		String param = "23";
		System.out.println(param + ": " + lcpn.letterCombinations(param).size());
		param = "2";
		System.out.println(param + ": " + lcpn.letterCombinations(param).size());
		param = "";
		System.out.println(param + ": " + lcpn.letterCombinations(param).size());
	}

}
