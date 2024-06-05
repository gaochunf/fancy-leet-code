package leetcode.problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/group-anagrams/description/
 * 
 * @author gaochf
 *
 */
public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {

		Map<String, List<String>> strMap = new HashMap<String, List<String>>();
		for (int index = 0; index < strs.length; index++) {
			String str = strs[index];
			String encodedStr = encodeKey(str);
			if (strMap.containsKey(encodedStr)) {
				strMap.get(encodedStr).add(str);
			} else {
				List<String> encodedStrValue = new ArrayList<String>();
				encodedStrValue.add(str);
				strMap.put(encodedStr, encodedStrValue);
			}
		}
		List<List<String>> result = new ArrayList<List<String>>();
		for (String key : strMap.keySet()) {
			result.add(strMap.get(key));
		}

		return result;
	}

	// str only consists of lowercase English letters.
	// encode str to "[no.]a[no.]b...[no.]z"
	private String encodeKey(String str) {
		Map<Character, Integer> charNo = new HashMap<Character, Integer>();
		for (int index = 0; index < str.length(); index++) {
			char charV = str.charAt(index);
			if (charNo.containsKey(charV)) {
				charNo.put(charV, charNo.get(charV) + 1);
			} else {
				charNo.put(charV, 1);
			}
		}
		StringBuffer result = new StringBuffer();
		for (int index = 'a'; index <= 'z'; index++) {
			char charV = (char) index;
			if (charNo.containsKey(charV)) {
				result.append(charNo.get(charV)).append(charV);
			} else {
				result.append('0').append(charV);
			}
		}
		return result.toString();

	}

	public static void main(String[] args) {
		GroupAnagrams ga = new GroupAnagrams();
		String[] param = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> result = ga.groupAnagrams(param);

		System.out.println("end");
	}

}
