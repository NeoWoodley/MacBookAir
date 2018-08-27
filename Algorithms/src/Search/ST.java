package Search;

public class ST<Key extends Comparable<Key>,Value> {
	private void delete(Key key) {
		put(key, null);
	}

	private boolean contains(Key key) {
		return get(key) != null;
	}

	private boolean isEmpty() {
		return size()==0;
	}

	private int size() {
		return 0;
	}

	private int size(Key lo, Key hi) {
		if (hi.compareTo(lo)<0)
			return 0;
		else if (contains(hi))
			return rank(hi)-rank(lo)+1;
		else
			return rank(hi) - rank(lo);
	}

	private void put(Key key, Value value) {

	}

	private Value get(Key key) {
		return value;
	}

	private void deleteMin() {
		delete(min());
	}

	private void deleteMax() {
		delete(max());
	}

	private Iterable<Key> keys() {
		return keys(min(), max());
	}
}
