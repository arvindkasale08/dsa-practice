import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeMap {

	class Pair {
		String val;
		int timestamp;

		public Pair(String val, int timestamp) {
			this.val = val;
			this.timestamp = timestamp;
		}
	}

	private HashMap<String, List<Pair>> map;

	public TimeMap() {
		map = new HashMap();
	}

	public void set(String key, String value, int timestamp) {
		if (!map.containsKey(key)) {
			map.put(key, new ArrayList<>());
		}
		map.get(key).add(new Pair(value, timestamp));
	}

	public String get(String key, int timestamp) {
		if (!map.containsKey(key)) {
			return "";
		}
		List<Pair> pairs = map.get(key);
		return search(pairs, timestamp);
	}

	private String search(List<Pair> pairs, int timestamp) {
		int low = 0;
		int high = pairs.size() - 1;

		while (low < high) {
			int middle = low + (high - low + 1) / 2;
			if (pairs.get(middle).timestamp <= timestamp) {
				low = middle;
			} else {
				high = middle - 1;
			}
		}
		return pairs.get(low).timestamp <= timestamp ? pairs.get(low).val : "";
	}

	public static void main(String[] args) {
		TimeMap timeMap = new TimeMap();
		timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
		System.out.println(timeMap.get("foo", 1));         // return "bar"
		System.out.println(timeMap.get("foo", 3));         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
		timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
		System.out.println(timeMap.get("foo", 4));         // return "bar2"
		System.out.println(timeMap.get("foo", 5));         // return "bar2"

	}
}
