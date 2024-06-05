package leetcode.problems.medium;

/**
 * 
 * https://leetcode.com/problems/132-pattern/description/
 * 
 * @author gaochf
 *
 */

public class Pattern132 {
	public boolean find132pattern(int[] nums) {
		if (nums.length < 3) {
			return false;
		}
		int min = Integer.MIN_VALUE;
		int high = nums.length;

		// Iterate through the array from the last to first
		for (int i = nums.length - 1; i >= 0; i--) {
			// If the current num is less than the min, we found pattern.
			// and return true
			if (nums[i] < min) {
				return true;
			}

			// Check if the current number is greater than the potential middle element.
			while (high < nums.length && nums[i] > nums[high]) {
				min = nums[high]; // Update the minimum value.
				high++; // Move to the next potential middle element.
			}
			high--; // Adjust the potential middle index.
			nums[high] = nums[i]; // Update the potential middle element with the current number.
			System.out.println("min=" + min + ";high=" + high + ";i=" + i);
			for (int index = 0; index < nums.length; index++) {
				System.out.print(" " + nums[index]);
			}
			System.out.println("//");
		}

		return false;
	}

	public static void main(String[] args) {
		Pattern132 p132 = new Pattern132();
//		int[] param = new int[] { 1, 2, 3, 4 };
//		System.out.println("Result: " + p132.find132pattern(param));
//
//		param = new int[] { 3, 1, 4, 2 };
//		System.out.println("Result: " + p132.find132pattern(param));

		int[] param = new int[] { 1,5,4,9,1 };
		System.out.println("Result: " + p132.find132pattern(param));

	}

	private boolean otherAnswer(int[] nums) {
		// base Case
		if (nums.length < 3) {
			return false;
		}

		int min = Integer.MIN_VALUE;
		int high = nums.length;

		// Iterate through the array from the last to first
		for (int i = nums.length - 1; i >= 0; i--) {
			// If the current num is less than the min, we found pattern.
			// and return true
			if (nums[i] < min) {
				return true;
			}

			// Check if the current number is greater than the potential middle element.
			while (high < nums.length && nums[i] > nums[high]) {
				min = nums[high]; // Update the minimum value.
				high++; // Move to the next potential middle element.
			}
			high--; // Adjust the potential middle index.
			nums[high] = nums[i]; // Update the potential middle element with the current number.
			System.out.println("min=" + min + ";high=" + high + ";i=" + i);
			for (int index = 0; index < nums.length; index++) {
				System.out.print(" " + nums[index]);
			}
			System.out.println("//");
		}
		return false;
	}

	private boolean wrongAnswer(int[] nums) {
		if (nums.length < 3) {
			return false;
		}
		int indexmax = -1;
		int indexmiddle = nums.length - 1;
		// find the first increasing pair
		for (int index = indexmiddle - 1; index >= 0; index--) {
			if (nums[index] > nums[indexmiddle]) {
				indexmax = index;
				break;
			}
			if (nums[index] < nums[indexmiddle]) {
				indexmiddle = index;
				break;
			}
		}
		if (indexmax <= 0) {
			return false;
		}
		// adjust middle to largest-middle
		int middlemax = nums[indexmiddle];
		for (int index = indexmax; index < nums.length; index++) {
			if (nums[index] > middlemax) {
				indexmiddle = index;
			}
		}

		for (int index = indexmax - 1; index >= 0; index--) {
			if (nums[index] < nums[indexmiddle]) {
				return true;
			} else if (nums[index] > nums[indexmax]) {
				//
				indexmax = index;

				middlemax = nums[indexmiddle];
				for (int indexin = indexmax; index < nums.length; index++) {
					if (nums[indexin] > middlemax) {
						indexmiddle = indexin;
					}
				}
			}
		}
		return false;
	}

	private boolean inefficientAnswer(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (i > 1 && nums[i] >= nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < nums.length; j++) {
				int max = nums[i];
				if (nums[j] > nums[i] && nums[j] > max) {
					max = nums[j];
					for (int k = j + 1; k < nums.length; k++) {
						if (nums[k] < nums[j] && nums[k] > nums[i]) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
