package leetcode.problems.medium;

/**
 * 
 * https://leetcode.com/problems/construct-smallest-number-from-di-string/description/
 * 
 * @author gaochf
 *
 */
public class SmallestNumberFromDI {
	public String smallestNumber(String pattern) {
		StringBuffer result = new StringBuffer();
		int currentMax = 2;
		int firstD = 0;
		result.append(1);
		for (int index = 0; index < pattern.length(); index++) {
			char di = pattern.charAt(index);
			if (di == 'I') {
				result.append(currentMax);
				firstD = index + 1;
			} else { // di=D
				result.insert(firstD, currentMax);
			}
			currentMax++;
		}
		return result.toString();
	}

	public static void main(String[] args) {
		SmallestNumberFromDI sndi = new SmallestNumberFromDI();

		String pattern = "IIIDIDDD";
		System.out.println(pattern + ": " + sndi.smallestNumber(pattern));
		
		pattern = "DDD";
		System.out.println(pattern + ": " + sndi.smallestNumber(pattern));
	}
}
