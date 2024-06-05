package leetcode.problems.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * https://leetcode.com/problems/map-sum-pairs/description/
 * 
 * @author gaochf
 *
 */
public class MapSum {

	private Map<String, Integer> value = null;

	public MapSum() {
		value = new HashMap<String, Integer>();
	}

	public void insert(String key, int val) {
		value.put(key, val);

	}

	public int sum(String prefix) {
		int sum = 0;
		for (String key : value.keySet()) {
			if (key.indexOf(prefix) == 0) {
				sum = sum + value.get(key);
			}
		}
		return sum;
	}
}

/**
 * Your MapSum object will be instantiated and called as such: MapSum obj = new
 * MapSum(); obj.insert(key,val); int param_2 = obj.sum(prefix);
 */