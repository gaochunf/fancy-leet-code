package leetcode.problems.medium;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 * 
 * @author gaochf
 *
 */
public class String2Integer {
	public int myAtoi(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int result = 0;
		int isNegative = 1; // 1 or -1
		boolean digitStarted = false;

		for (int index = 0; index < s.length(); index++) {
			char charAtIndex = s.charAt(index);
			switch (charAtIndex) {
			case ' ':
				if (digitStarted) {
					// ended
					return result;
				} else {
					// do nothing
					continue;
				}
			case '-':
				if (digitStarted || isNegative == -1) {
					// ended
					return result;
				} else {
					isNegative = -1;
					digitStarted = true;
					// '-' also starts the digits, '- 123' not allowed
					continue;
				}
			case '+':
				if (digitStarted) {
					// ended
					return result;
				} else {
					isNegative = 1;
					digitStarted = true;
					continue;
				}
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				digitStarted = true;
				int digitValue = charAtIndex - '0';
				// MIN, MAX check:
				// -2147483648 [0x80000000] ~~~ 2147483647 [0x7fffffff]
				if (isNegative == -1) {
					if (result <= -214748365 || (result == -214748364 && digitValue > 8)) {
						// out of value range
						return Integer.MIN_VALUE;
					} else {
						if (result == 0) {
							result = -1 * digitValue;
						} else {
							result = result * 10 - digitValue;
						}
					}
				} else {
					if (result >= 214748365 || (result == 214748364 && digitValue > 7)) {
						// out of value range
						return Integer.MAX_VALUE;
					} else {
						if (result == 0) {
							result = digitValue;
						} else {
							result = result * 10 + digitValue;
						}
					}
				}
				continue;
			default:
				// none digit, end
				return result;
			}
		}

		return result;
	}

	public static void main(String[] args) {

		String2Integer s2i = new String2Integer();
		String param = "42";
		System.out.println(param + ": " + s2i.myAtoi(param));
		param = "   -42";
		System.out.println(param + ": " + s2i.myAtoi(param));
		param = "4193 with words";
		System.out.println(param + ": " + s2i.myAtoi(param));
		param = "     ";
		System.out.println(param + ": " + s2i.myAtoi(param));
		param = "  -004193 with words";
		System.out.println(param + ": " + s2i.myAtoi(param));
		param = "words and 987";
		System.out.println(param + ": " + s2i.myAtoi(param));
		param = "+1";
		System.out.println(param + ": " + s2i.myAtoi(param));
		param = "+-2";
		System.out.println(param + ": " + s2i.myAtoi(param));
		param = "-+3";
		System.out.println(param + ": " + s2i.myAtoi(param));
	}
}
