package AVLTree;

/**
 * 平衡二叉树的结点类
 */
public class AVLNode<T extends Comparable<T>> {
	AVLNode<T> leftChild;
	AVLNode<T> rightChild;
	AVLNode<T> parent;  // TODO: 2018/10/21 这里需不需要parent属性？？？
	T element;
	int height;  // 当前结点的高度

	// 三个构造方法
	public AVLNode(T element) {
		this(null, null, element);
	}

	public AVLNode(AVLNode<T> leftChild, AVLNode<T> rightChild, T element) {
		this(leftChild, rightChild, element, 0);
	}

	public AVLNode(AVLNode<T> leftChild, AVLNode<T> rightChild, T element, int height) {
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.element = element;
		this.height = height;
	}
}
