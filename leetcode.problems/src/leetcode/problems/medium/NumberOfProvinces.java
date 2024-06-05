package leetcode.problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/number-of-provinces/description/
 * 
 * @author gaochf
 *
 */
public class NumberOfProvinces {

	public int findCircleNum(int[][] isConnected) {
		int length = isConnected.length;
		// province number, start from 1; 0 means not processed yet
		int[] province = new int[length];
		int currentProvinceMax = 1;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (isConnected[i][j] == 1) {
					if (province[i] == 0 && province[j] == 0) {
						// all new
						province[i] = currentProvinceMax++;
						province[j] = province[i];
					} else if (province[i] != 0 && province[j] == 0) {
						// j is new
						province[j] = province[i];
					} else if (province[i] == 0 && province[j] != 0) {
						// i is new
						province[i] = province[j];
					} else if (province[i] != province[j]) {
						// both are not new, and they are different
						// change all j's province to i's province
						int jprovince = province[j];
						for (int index = 0; index < length; index++) {
							if (province[index] == jprovince) {
								province[index] = province[i];
							}
						}
					}
					// if both are not new and they are same, then do nothing.
				} else {
					// not connected
					if (province[i] == 0) {
						province[i] = currentProvinceMax++;
					}
					if (province[j] == 0) {
						province[j] = currentProvinceMax++;
					}
				}
			}
		}
		// return province number : how many different numbers in int[] province
		List<Integer> result = new ArrayList<Integer>();
		for (int index = 0; index < length; index++) {
			if (!result.contains(province[index])) {
				result.add(province[index]);
			}
		}
		return result.size();

	}

	public static void main(String[] args) {
		NumberOfProvinces nop = new NumberOfProvinces();
		int[][] param = new int[3][];
		param[0] = new int[] { 1, 1, 0 };
		param[1] = new int[] { 1, 1, 0 };
		param[2] = new int[] { 0, 0, 1 };
		System.out.println("number of province: " + nop.findCircleNum(param));
	}

}
