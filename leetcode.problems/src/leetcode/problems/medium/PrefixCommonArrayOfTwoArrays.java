package leetcode.problems.medium;

/**
 * 
 * https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/description/
 * 
 * @author gaochf
 *
 */
public class PrefixCommonArrayOfTwoArrays {

	public int[] findThePrefixCommonArray(int[] A, int[] B) {
		int length = A.length;
		int[] valueCount = new int[length];
		int[] result = new int[length];

		for (int index = 0; index < length; index++) {
			// index = value -1
			valueCount[A[index] - 1]++;
			valueCount[B[index] - 1]++;
			int indexResult = 0;
			for (int countIndex = 0; countIndex < length; countIndex++) {
				if (valueCount[countIndex] == 2) {
					indexResult++;
				}
			}
			result[index] = indexResult;
		}
		return result;
	}

	public static void main(String[] args) {

		PrefixCommonArrayOfTwoArrays pca = new PrefixCommonArrayOfTwoArrays();
		int[] A = new int[] { 1, 3, 2, 4 };
		int[] B = new int[] { 3, 1, 2, 4 };
		int[] result = pca.findThePrefixCommonArray(A, B);
		System.out.println(result.length);
	}

}
