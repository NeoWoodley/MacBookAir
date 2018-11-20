package Three;

public class DoubleNode<T> {
	DoubleNode pre=null;
	DoubleNode next=null;
	T element;

	public DoubleNode() {
		this.element=null;
	}

	public DoubleNode(T element) {
		this.element=element;
	}

	public boolean hasNext() {
		return this.next!=null;
	}

	public boolean hasPre() {
		return this.pre!=null;
	}

	public DoubleNode next() {
		return this.next;
	}

	public DoubleNode pre() {
		return this.pre;
	}
}
