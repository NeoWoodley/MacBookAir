package JosephusQuestionLinkedList;

/**
 * 双向链表
 */
public class LinkedList<E> {
	int size;
	Node first;  // 头结点
	Node last;  // 尾结点

	class Node<E> {
		E element;
		Node next;
		Node pre;

		private Node(Node pre, E element, Node next) {
			this.element = element;
			this.pre = pre;
			this.next = next;
		}
	}

	public LinkedList() {
		this.size = 0;
	}

	public void add(E element) {
		this.linkLast(element);
	}

	public void add(int index, E element) {

	}

	/**
	 * 在first结点的后面链接一个新结点
	 *
	 * @param element 新结点的element值
	 */
	public void linkFirst(E element) {
		Node<E> first = this.first;  // 获取当前list的first头结点
		Node<E> newNode = new Node<>(null, element, first);  // 创建出新结点，并将新结点的pre暂时指向null、
		this.first = newNode;  // newNode代替原来的头结点，成为新的头结点
		// 如果在添加新结点之前，是个空链表
		if (first == null) {
			this.last = newNode;  // 新添加的结点既是头结点，又是尾结点
		} else {
			first.pre = newNode;  // 将新添加的结点和原来的头结点链接起来
		}
		size++;
	}

	/**
	 * 在last结点的后面链接一个新结点
	 *
	 * @param element 新结点的element值
	 */
	public void linkLast(E element) {
		Node<E> last = this.last;  // 获取当前list的last尾结点
		Node<E> newNode = new Node<>(last, element, null);  // 创建出新结点，并将新结点的pre链接到last之前的结点上，但新结点的next暂时指向null
		this.last = newNode;  // newNode代替原来的尾结点，成为新的尾结点
		// 如果在添加新结点之前，是个空链表
		if (last == null) {
			this.first = newNode;  // 新添加的结点既是头结点，又是尾结点
		} else {
			last.next = newNode;
		}
		size++;
	}

	/**
	 * 在结点succ之前插入一个值为element的新的结点
	 *
	 * @param element 新结点的element值
	 * @param succ    插入点在结点succ之前
	 */
	public void linkBefore(E element, Node succ) {
		Node pre = succ.pre;
		Node newNode = new Node(pre, element, succ);  // 新结点的pre指向succ结点的前面一个结点，next指向succ结点
		succ.pre=newNode;
		// 如果succ原本是first头结点
		if (pre == null) {
			this.first = newNode;
		} else {
			pre.next=newNode;
		}
		size++;
	}

	public E remove(int index) {
		this.checkElementIndex(index);
		System.out.println("remove index: "+index);
		return this.unlink(this.getNode(index));
	}

	public Node<E> getNode(int index) {
		Node node;
		int i;
		// 如果要查找的结点的索引更加靠近前半部分，就从头结点开始查找
		// 若size=1，那么执行else
		if (index < this.size >> 1) {
			node = this.first;

			for (i = 0; i < index; i++) {
				node = node.next;
			}

			return node;
		} else {
			node=this.last;

			for (i = this.size - 1; i > index; i--) {
				node=node.pre;
			}

			return node;
		}
	}

	public E unlink(Node<E> node) {
		E element=node.element;
		Node<E> next=node.next;
		Node<E> pre = node.pre;
		// 如果删掉的结点是头结点
		if (pre == null) {
			this.first = next;
		} else {
			pre.next=next;
			node.pre=null;  // 这样垃圾回收机制才能顺利回收被移除的节点
		}
		// 如果删掉的结点是尾结点
		if (next == null) {
			this.last = pre;
		} else {
			next.pre=pre;
			node.next=null;  // 这样垃圾回收机制才能顺利回收被移除的节点
		}

		node.element = null;
		size--;
		return element;
	}

	private void checkElementIndex(int index) {
		if (!this.isElementIndex(index)) {
			throw new IndexOutOfBoundsException();
		}
	}

	private boolean isElementIndex(int index) {
		return index>=0&&index<this.size;
	}

	public void printWinner() {
		Node first=this.first;
		while (first != null) {
			System.out.print("最后的胜利者是："+first.element+" ");
			first=first.next;
		}
	}
}
