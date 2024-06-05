package leetcode.problems.medium;

/**
 * 
 * https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/description/
 * 
 * @author gaochf
 *
 */

public class AppendToMakeSubsequence {

	public int appendCharacters(String s, String t) {
		int matched = 0;
		for (int index = 0; index < s.length(); index++) {
			if (matched >= t.length()) {
				break;
			}
			if (s.charAt(index) == t.charAt(matched)) {
				matched++;
			}
		}
		return t.length() - matched;
	}

	public static void main(String[] args) {
		AppendToMakeSubsequence atms = new AppendToMakeSubsequence();
		String s = "coaching";
		String t = "coding";
		System.out.println("appendCharacters( " + s + ", " + t + "): " + atms.appendCharacters(s, t));

		s = "z";
		t = "abcde";
		System.out.println("appendCharacters( " + s + ", " + t + "): " + atms.appendCharacters(s, t));
		
		
		s = "abcde";
		t = "a";
		System.out.println("appendCharacters( " + s + ", " + t + "): " + atms.appendCharacters(s, t));
	}

}
