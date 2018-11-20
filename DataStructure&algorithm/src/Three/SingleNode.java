package Three;

public class SingleNode<T> {
	SingleNode next;
	T element;

	public SingleNode() {
		next = null;
		element = null;
	}

	public SingleNode(T element) {
		next = null;
		this.element = element;
	}

	public boolean hasNext() {
		return this.next() != null;
	}

	public SingleNode next() {
		return this.next;
	}
}
