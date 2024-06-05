package leetcode.problems.medium;

/**
 * 
 * https://leetcode.com/problems/multiply-strings/description/
 * 
 * @author gaochf
 *
 */
public class MultiplyStrings {

	public String multiply(String num1, String num2) {
		StringBuffer sb = new StringBuffer();
		for (int num0 = 0; num0 < num1.length() + num2.length(); num0++) {
			sb.append('0');
		}
		for (int num1index = num1.length() - 1; num1index >= 0; num1index--) {
			for (int num2index = num2.length() - 1; num2index >= 0; num2index--) {
				int num1int = (int) (num1.charAt(num1index) - '0');
				int num2int = (int) (num2.charAt(num2index) - '0');
				int product = num1int * num2int;
				int currentIncre = num1.length() - num1index + num2.length() - num2index - 1;
				while (product > 0) {
					int remainder = product % 10;
					product = (int) product / 10;
					if (sb.length() < currentIncre) {
						sb.insert(0, remainder);
					} else {
						int numCurrent = (int) (sb.charAt(sb.length() - currentIncre) - '0');
						product = product + (int) ((numCurrent + remainder) / 10);
						remainder = (numCurrent + remainder) % 10;
						sb.setCharAt((sb.length() - currentIncre), (char) (remainder + '0'));

					}
					currentIncre++;
				}
			}
		}
		// remove head 0s
		while (sb.charAt(0) == '0' && sb.length() > 1) {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		MultiplyStrings ms = new MultiplyStrings();
		String param1 = "123";
		String param2 = "456";
		String result = ms.multiply(param1, param2);
		System.out.println(param1 + " * " + param2 + " = " + result);

		param1 = "6";
		param2 = "501";
		result = ms.multiply(param1, param2);
		System.out.println(param1 + " * " + param2 + " = " + result);

		param1 = "0";
		param2 = "0";
		result = ms.multiply(param1, param2);
		System.out.println(param1 + " * " + param2 + " = " + result);

		param1 = "0";
		param2 = "9133";
		result = ms.multiply(param1, param2);
		System.out.println(param1 + " * " + param2 + " = " + result);

	}

}
