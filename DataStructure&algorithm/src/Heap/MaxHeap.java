package Heap;

public class MaxHeap<T extends Comparable> {
	Node<T>[] Nodes;
	private int numOfNode;
	public Node<T> root;

	// 内部结点类
	private class Node<T> {
		Node<T> parent;
		Node<T> leftChild;
		Node<T> rightChild;
		T element;

		Node(T element) {
			this.parent = null;
			this.leftChild = null;
			this.rightChild = null;
			this.element = element;
		}

		@Override
		public String toString() {
			return this.element.toString() + " ";
		}
	}

	public MaxHeap(T[] element) {
		createMaxHeap(element);
	}

	private void createMaxHeap(T[] elements) {
		createHeap(elements);
		siftUp();
	}

	private void createHeap(T[] elements) {
		this.Nodes = new Node[elements.length + 1];  // 索引为0的位置不存放结点
		this.numOfNode = Nodes.length - 1;
		// 创建结点类数组
		Nodes[0] = null;
		for (int i = 1; i < Nodes.length; i++) {
			Nodes[i] = new Node<T>(elements[i - 1]);
		}

		// 设置根结点
		this.root = Nodes[1];

		// 将各个具有父子关系的结点进行关联
		for (int parentIndex = 1; parentIndex <= elements.length / 2; parentIndex++) {
			Nodes[parentIndex].leftChild = Nodes[2 * parentIndex];
			if (2 * parentIndex + 1 < Nodes.length) {
				Nodes[parentIndex].rightChild = Nodes[2 * parentIndex + 1];
			}
			// 就算结点是根结点，也是可以统一到下面这一行中去
			Nodes[parentIndex].parent = Nodes[parentIndex / 2];
		}
//		siftUp();
	}

	public void insert(T element) {

	}

	/**
	 * 最大堆删除操作就是删除二叉树的根结点
	 * 步骤：
	 * 1、用结点类数组中的最后一个元素，替换根结点；即根结点的element值换成最后一个结点的element值
	 * 2、判断是否是最大堆
	 * 3、若不是就将根结点下沉
	 */
	public void delete() {
//		this.root.element=
	}

	public void siftUp() {
		siftUp(this.numOfNode / 2);
	}

	public void preOrderTraverse() {
		preOrderTraverse(this.root);
	}

	/**
	 * 让结点"上浮"
	 * 能够让以indexOfRoot为根的子树成为最大堆
	 *
	 * @param indexOfRoot 子根的索引
	 */
	private void siftUp(int indexOfRoot) {
		int parentIndex = indexOfRoot;
		if (parentIndex >= 1 && parentIndex <= this.numOfNode/2) {
			int biggerChild = getBiggerChild(parentIndex);
			int compareResult = getElement(parentIndex).compareTo(getElement(biggerChild));
			// 若是需要进行交换
			if (compareResult < 0) {
				swap(parentIndex, biggerChild);
				siftUp(biggerChild);  // 交换结点的同时，可能会破坏子树的最大堆性质，需要再次上浮
			}
			siftUp(parentIndex - 1);  // 从索引值为"numOfNode/2"逐步递减到root所在索引"1"
		}
		return;
	}

	/**
	 * 获取element域值更大的子女的索引值
	 *
	 * @param parentIndex
	 * @return 返回索引值
	 */
	private int getBiggerChild(int parentIndex) {
		int leftChildIndex = 2 * parentIndex;
		int rightChildIndex = 2 * parentIndex + 1;  // 可能不存在右儿子
		if (leftChildIndex >= 2 && leftChildIndex <= this.numOfNode && rightChildIndex >= 3 && rightChildIndex <= this.numOfNode) {
			return getElement(leftChildIndex).compareTo(getElement(rightChildIndex)) >= 0 ? leftChildIndex :
					rightChildIndex;
		}
		return leftChildIndex==this.numOfNode?leftChildIndex:-1;
	}

	private void preOrderTraverse(Node<T> node) {
		if (node != null) {
			print(node);
			preOrderTraverse(node.leftChild);
			preOrderTraverse(node.rightChild);
		}
	}

	/**
	 * 交换两个结点，实际上只要交换结点的element域的值即可
	 *
	 * @param x
	 * @param y
	 */
	private void swap(int x, int y) {
		T tempElement = getElement(x);
		setElement(x, getElement(y));
		setElement(y, tempElement);
	}

	private T getElement(int index) {
		return this.Nodes[index].element;
	}

	private void setElement(int index, T element) {
		this.Nodes[index].element = element;
	}

	private Node<T> getNode(int index) {
		return this.Nodes[index];
	}

//	private void print() {
//
//	}

	private void print(int index) {
		System.out.print(getNode(index));
	}

	private void print(Node<T> node) {
		System.out.print(node);
	}

	public static void main(String[] agrs) {
		Integer[] nums = {10, 3, 544, 34, 5, 46, 52, 7, 6, 856, 4, 1};
		MaxHeap<Integer> maxHeap = new MaxHeap(nums);
		maxHeap.preOrderTraverse();
	}
}
