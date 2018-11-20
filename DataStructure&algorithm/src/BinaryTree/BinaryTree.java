package BinaryTree;

public class BinaryTree<T extends Comparable<T>> {
	private BinaryTreeNode<T> root;  // 根结点

	// 内部结点类
	private class BinaryTreeNode<T> {
		BinaryTreeNode<T> parent;
		BinaryTreeNode<T> leftChild;
		BinaryTreeNode<T> rightChild;
		T element;

		BinaryTreeNode(T element) {
			this.parent = null;
			this.leftChild = null;
			this.rightChild = null;
			// 空结点
			if (element.equals("*")) {
				element = null;
			}
			this.element = element;
		}

		@Override
		public String toString() {
			return "element: " + this.element;
		}
	}

	public BinaryTree() {
		this.root = null;
	}

	public void createBinaryTree(T[] elements) {
		BinaryTreeNode<T>[] binaryTreeNode = new BinaryTreeNode[elements.length + 1];
		// 创建结点类的数组，存放要建的结点，从数组索引为1的地方开始存放
		for (int i = 1; i < elements.length + 1; i++) {
			binaryTreeNode[i] = new BinaryTreeNode<T>(elements[i - 1]);
		}
		this.root = binaryTreeNode[1];

		// 第i个结点的父结点索引为i/2向下取整，第i个结点的左子女为2i，右子女为2i+1
		for (int parentIndex = 1; parentIndex <= elements.length / 2; parentIndex++) {
			binaryTreeNode[parentIndex].leftChild = binaryTreeNode[parentIndex * 2];
			if (parentIndex * 2 + 1 < binaryTreeNode.length)
				binaryTreeNode[parentIndex].rightChild = binaryTreeNode[parentIndex * 2 + 1];
			if (parentIndex != 1) {
				binaryTreeNode[parentIndex].parent = binaryTreeNode[parentIndex / 2];
			}
		}
	}

	/**
	 * 先序遍历
	 */
	public void preOrderTraverse() {
		System.out.println("先序遍历");
		preOrderTraverse(root);
	}

	/**
	 * 中序遍历
	 */
	public void inOrderTraverse() {
		System.out.println("中序遍历");
		inOrderTraverse(root);
	}

	/**
	 * 后序遍历
	 */
	public void postOrderTraverse() {
		System.out.println("后序遍历");
		postOrderTraverse(root);
	}

	private void preOrderTraverse(BinaryTreeNode<T> node) {
		if (node != null) {
			printNode(node);
			preOrderTraverse(node.leftChild);
			preOrderTraverse(node.rightChild);
		}
	}

	private void inOrderTraverse(BinaryTreeNode<T> node) {
		if (node != null) {
			inOrderTraverse(node.leftChild);
			printNode(node);
			inOrderTraverse(node.rightChild);
		}
	}

	private void postOrderTraverse(BinaryTreeNode node) {
		if (node != null) {
			postOrderTraverse(node.leftChild);
			postOrderTraverse(node.rightChild);
			printNode(node);
		}
	}

	private void printNode(BinaryTreeNode<T> node) {
		if (node.element != null) {
			System.out.println(node.toString());
		}
	}

	public static void main(String[] args) {
		BinaryTree<String> binaryTree = new BinaryTree<String>();
		String[] elements = {"A", "B", "C", "D", "E", "F", "*", "*", "*", "G"};
		binaryTree.createBinaryTree(elements);
		binaryTree.preOrderTraverse();
		System.out.println("----------");
		binaryTree.inOrderTraverse();
		System.out.println("----------");
		binaryTree.postOrderTraverse();
		System.out.println("----------");
	}
}
