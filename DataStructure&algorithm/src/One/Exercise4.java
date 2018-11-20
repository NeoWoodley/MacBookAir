package One;

public class Exercise4 {
	public int length(Node node) {
		if(node==null)
			return 0;
		return 1 + length(node.next);
	}

	class Node {
		Object data=null;
		Node next=null;
	}
}
