//package AVLTree;
//
//public class AVLTree<T extends Comparable<T>> {
//	AVLNode<T> root;
//
//	/**
//	 * 在AVLTree中插入新结点
//	 *
//	 * @param element 要插入结点的element域值
//	 */
//	public void insert(T element) {
//		if (element == null) {
//			throw new RuntimeException("element can\'t be null");
//		}
//		this.root = insert(element, root);
//	}
//
//	/**
//	 * LL平衡旋转（右单转）
//	 * <p>
//	 * 由于在结点A的左孩子（L）的左子树（L）上插入了新结点，A的平衡因子由1增至2，导致以A为根的子树失去平衡，需要一次向右的旋转操作。将A的左孩子B向右上旋转代替A成为根结点，将A结点向右下旋转成为B的右子树的根结点，而B的愿右子树则作为A结点的左子树
//	 *
//	 * @param subRoot
//	 * @return
//	 */
//	private AVLNode<T> singleRotateRight(AVLNode<T> subRoot) {
//		// 把leftNode结点旋转为根结点，把leftNode的右子树变为subRoot的左子树，subRoot变为leftNode的右子树
//		AVLNode<T> leftNode = subRoot.leftChild;
//		subRoot.leftChild = leftNode.rightChild;
//		leftNode.rightChild = subRoot;
//
//		// 重新计算结点们的高度
//		subRoot.height = Math.max(subRoot.leftChild.height, subRoot.rightChild.height) + 1;
//		leftNode.height = Math.max(leftNode.leftChild.height, subRoot.height) + 1;
//
//		// 返回新的根结点
//		return leftNode;
//	}
//
//	/**
//	 * RR平衡旋转（左单旋转）
//	 * <p>
//	 * 由于在结点A的右孩子（R）的右子树（R）上插入了新结点，A的平衡因子由-1减至-2，导致以A为根的子树失去平衡，需要一次向左的旋转操作。将A的右孩子B向左上旋转代替A成为根结点，将A结点向左下旋转成为B的左子树的根结点，而B的原左子树则作为A结点的右子树
//	 *
//	 * @param node
//	 * @return
//	 */
//	private AVLNode<T> singleRotateLeft(AVLNode<T> node) {
//
//	}
//
//	/**
//	 * LR平衡旋转（先左后右双旋转）
//	 * <p>
//	 * 由于在A的左孩子（L）的右子树（R）上插入新结点，A的平衡因子由1增至2，导致以A为根的子树失去平衡，需要进行两次旋转操作，先左旋转后右旋转。先将A结点的左孩子B的右子树的根结点C向左上旋转提升到B结点的位置，然后再把该C结点向右上旋转提升至A结点的位置
//	 *
//	 * @param subRoot
//	 * @return
//	 */
//	private AVLNode<T> doubleRotateLeftRight(AVLNode<T> subRoot) {
//
//	}
//
//	/**
//	 * RL平衡旋转（先右旋后左双旋转）
//	 * <p>
//	 * 由于在A的右孩子（R）的左子树（L）上插入新结点，A的平衡因子由-1减至-2，导致以A为根的子树失去平衡，需要进行两次旋转操作，先右旋转后左旋转。先将A结点的右孩子B的左子树的根结点C向右上旋转提升到B结点的位置，然后再把该C结点向左上旋转提升到A结点的位置
//	 *
//	 * @param subRoot
//	 * @return
//	 */
//	private AVLNode<T> doubleRotateRightLeft(AVLNode<T> subRoot) {
//
//	}
//
//	/**
//	 * 与BST（二叉查找树）的插入实现原理一样，使用递归算法，根据值大小查找到插入位置，然后进行插入操作
//	 * 插入完成后，需要进行平衡判断，评估子树是否需要进行平衡修复，最后要记得重新计算插入结点路径上的高度。
//	 *
//	 * @param element
//	 * @param node
//	 * @return
//	 */
//	private AVLNode<T> insert(T element, AVLNode<T> node) {
//		if (node == null) {
//			// 在递归时，node表示的是新结点的合适的插入点
//			// 如果已经没有孩子结点了，就可以创建新结点插入了
//			node = new AVLNode<T>(element);
//		} else if (element.compareTo(node.element) < 0) {
//			// 向左子树寻找插入位置
//			node.leftChild = insert(element, node.leftChild);
//
//			// 插入后计算子树的高度，等于2则需要重新恢复平衡，由于是左边插入，左子树的高>=右子树的高度
//			if (node.leftChild.height - node.rightChild.height == 2) {
//				// 判断element是插入点的左孩子还是右孩子
//				if (element.compareTo(node.leftChild.element) < 0) {
//					// 进行LL
//					node = singleRotateRight(node);
//				} else {
//					// 进行LR
//					node = doubleRotateLeftRight(node);
//				}
//			}
//		} else if (element.compareTo(node.element) > 0) {
//			// 向右子树寻找插入位置
//			node.rightChild = insert(element, node.rightChild);
//
//			if (node.rightChild.height - node.leftChild.height == 2) {
//				if (element.compareTo(node.rightChild.element) < 0) {
//					// 进行RL
//					node = doubleRotateRightLeft(node);
//				} else {
//					node = singleRotateLeft(node);
//				}
//			}
//		}
//		// 重新计算各个结点的高度
//		node.height = Math.max(node.leftChild.height, node.rightChild.height) + 1;
//		return node;
//	}
//
//	private AVLNode<T> remove(T element, AVLNode<T> subRoot) {
//		if (subRoot == null) {
//			return null;
//		}
//
//		int compareResult = element.compareTo(subRoot.element);
//
//		if (compareResult < 0) {
//			// 从左子树中查找要删除的元素
//			subRoot.leftChild = remove(element, subRoot.leftChild);
//			// 检查是否平衡
//			if (subRoot.rightChild.height - subRoot.leftChild.height == 2) {
//				AVLNode<T> currentNode = subRoot.rightChild;
//				// 判断需要进行哪种旋转
//				if (currentNode.leftChild.height > currentNode.rightChild.height) {
//					// LL
//					subRoot = singleRotateRight(subRoot);
//				} else {
//					// LR
//					subRoot = doubleRotateRightLeft(subRoot);
//				}
//			}
//		} else if (compareResult > 0) {
//			// 从右子树中查找需要删除的元素
//			subRoot.rightChild = remove(element, subRoot.rightChild);
//			// 检查是否平衡
//			if()
//		}
//	}
//
//	/**
//	 * 判断以subRoot为根的子树是否平衡
//	 * @param subNode  子树的根
//	 * @return
//	 */
//	private boolean isBalanced(AVLNode<T> subNode) {
//		return Math.abs(subNode.leftChild.height - subNode.rightChild.height) >= 2;
//	}
//
//	/**
//	 * 进行旋转，从LL、RR、LR、RL中选择一种正确的旋转方式进行旋转
//	 * @param subNode  要进行旋转的子树的根
//	 * @return
//	 */
//	private AVLNode<T> rotate(AVLNode<T> subNode) {
//
//	}
//}
