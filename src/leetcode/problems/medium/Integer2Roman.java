package leetcode.problems.medium;

/**
 * https://leetcode.com/problems/integer-to-roman/description/
 * 
 * @author gaochf
 *
 */

public class Integer2Roman {
	public String intToRoman(int num) {
		StringBuffer sb = new StringBuffer();
		int thousand = num / 1000;
		for (int index = 0; index < thousand; index++) {
			// M 1000
			sb.append("M");
		}
		num = num - 1000 * thousand;
		if (num >= 900) {
			sb.append("CM");
			// CM 900
			num = num - 900;
		}
		if (num >= 500) {
			sb.append("D");
			// D 500
			num = num - 500;
		}
		if (num >= 400) {
			sb.append("CD");
			// CD 400
			num = num - 400;
		}
		int hundred = num / 100;
		for (int index = 0; index < hundred; index++) {
			// C 100
			sb.append("C");
		}
		num = num - 100 * hundred;
		if (num >= 90) {
			sb.append("XC");
			// XC 90
			num = num - 90;
		}
		if (num >= 50) {
			sb.append("L");
			// L 50
			num = num - 50;
		}
		if (num >= 40) {
			sb.append("XL");
			// XL 40
			num = num - 40;
		}
		int ten = num / 10;
		for (int index = 0; index < ten; index++) {
			// X 10
			sb.append("X");
		}
		num = num - ten * 10;
		if (num >= 9) {
			sb.append("IX");
			// IX 9
			num = num - 9;
		}
		if (num >= 5) {
			sb.append("V");
			// V 5
			num = num - 5;
		}
		if (num >= 4) {
			sb.append("IV");
			// IV 4
			num = num - 4;
		}
		for (int index = 0; index < num; index++) {
			// I 1
			sb.append("I");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Integer2Roman i2r = new Integer2Roman();
		int param = 1994;
		System.out.println(param + ": " + i2r.intToRoman(param));
		param = 3;
		System.out.println(param + ": " + i2r.intToRoman(param));
	}
}
