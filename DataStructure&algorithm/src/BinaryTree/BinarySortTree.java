package BinaryTree;

/**
 * 自己写
 */
public class BinarySortTree<T extends Comparable<T>> {
	private Node<T> root;  // 根结点

	// 内部类
	private class Node<T extends Comparable<T>> {
		T element;
		Node<T> leftChild;
		Node<T> rightChild;
		Node<T> parent;

		Node(T newElement) {
			this.parent = null;
			this.leftChild = null;
			this.rightChild = null;
			this.element = newElement;
		}

		Node(T newElement, Node<T> parent) {
			this.parent = parent;
			this.leftChild = null;
			this.rightChild = null;
			this.element = newElement;
		}

		Node(T newElement, Node<T> parent, Node<T> leftChild, Node<T> rightChild) {
			this.parent = parent;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
			this.element = newElement;
		}

		T getElement() {
			return this.element;
		}

		@Override
		public String toString() {
			return "element: " + this.element;
		}
	}

	public BinarySortTree() {
		root = null;
	}

	public void createBinTree() {


	}

	/**
	 * 先序遍历
	 */
	public void preOrderTraverse() {
		preOrderTraverse(root);
	}

	/**
	 * 中序遍历
	 */
	public void inOrderTraverse() {
		inOrderTraverse(root);
	}

	/**
	 * 后序遍历
	 */
	public void postOrderTraverse() {
		postOrderTraverse(root);
	}

	/**
	 * @param element 键值
	 * @return element域为指定键值的结点
	 * 递归实现查找
	 */
	public Node<T> search(T element) {
		return search(root, element);
	}

	/**
	 * @param element
	 * @return 非递归实现查找
	 */
	public Node<T> iterativeSearch(T element) {
		return iterativeSearch(root, element);
	}

	public T min() {
		Node<T> node = min(root);
		if (node != null) {
			return node.element;
		}

		return null;
	}

	/**
	 * 查找最大结点的element域值
	 *
	 * @return
	 */
	public T max() {
		Node<T> node = max(root);
		if (node != null) {
			return node.element;
		}

		return null;
	}

	/**
	 * 查找指定结点的后继结点。即，查找"二叉树中数据值大于该结点"的"最小结点"
	 * <p>
	 * 后继节点
	 * 若一个节点有右子树，那么该节点的后继节点是其右子树中val值最小的节点（也就是右子树中所谓的leftMostNode）
	 * 若一个节点没有右子树，那么判断该节点和其父节点的关系
	 * 2.1 若该节点是其父节点的左边孩子，那么该节点的后继结点即为其父节点
	 * 2.2 若该节点是其父节点的右边孩子，那么需要沿着其父亲节点一直向树的顶端寻找，直到找到一个节点P，P节点是其父节点Q的左边孩子，那么Q就是该节点的后继节点
	 *
	 * @param node 指定的结点
	 * @return 返回后继结点
	 */
	public Node<T> successor(Node<T> node) {
		// 如果x存在右孩子，则"x的后继结点"为"以其右孩子为根的子树的最小结点"。
		if (node.rightChild != null) {
			return min(node.rightChild);
		}
		// 如果x没有右孩子。则x有以下两种可能：
		// 1. x是"一个左孩子"，则"x的后继结点"为 "它的父结点"。
		// 2. x是"一个右孩子"，则查找"x的最低的父结点，并且该父结点要具有左孩子（这个左儿子是node所在子树的根）"，找到的这个"最低的父结点"就是"x的后继结点"。
		Node<T> parentNode = node.parent;
		// 如果node始终是其父结点的右儿子的话，就一直循环下去
		while (parentNode != null && node == parentNode.rightChild) {
			node = parentNode;
			parentNode = parentNode.parent;
			// 如果沿着node的父结点一直向树的顶端寻找，但是找不到一个结点P，使得P结点是其父结点Q的左儿子的话，这个时候就会一路上升找到root，而root的parentNode是null，那么跳出循环的话，会返回null，符合一般情况
		}
		return parentNode;
	}

	/**
	 * 查找指定结点的前驱结点。即，查找"二叉树中数据值小于该结点"的"最大结点"
	 * <p>
	 * 前驱节点
	 * 若一个节点有左子树，那么该节点的前驱节点是其左子树中val值最大的节点（也就是左子树中所谓的rightMostNode）
	 * 一个节点没有左子树，那么判断该节点和其父节点的关系
	 * 2.1 若该节点是其父节点的右边孩子，那么该节点的前驱结点即为其父节点。
	 * 2.2 若该节点是其父节点的左边孩子，那么需要沿着其父亲节点一直向树的顶端寻找，直到找到一个节点P，P节点是其父节点Q的右边孩子（可参考例子2的前驱结点是1），那么Q就是该节点的后继节点
	 * 类似，我么可以得到求后继节点的规则。
	 *
	 * @param node
	 * @return
	 */
	public Node<T> predecessor(Node<T> node) {
		// 如果x存在左孩子，则"x的前驱结点"为"以其左孩子为根的子树的最大结点"
		if (node.leftChild != null) {
			return node.leftChild;
		}

		// 如果x没有左孩子。则x有以下两种可能：
		// (01) x是"一个右孩子"，则"x的前驱结点"为 "它的父结点"。
		// (01) x是"一个左孩子"，则查找"x的最低的父结点，并且该父结点要具有右孩子"，找到的这个"最低的父结点"就是"x的前驱结点"。
		Node<T> parentNode = node.parent;
		while (parentNode != null && node == parentNode.leftChild) {
			node = parentNode;
			parentNode = parentNode.parent;  // 若node结点不存在前驱结点，那么也是符合的，也会正确返回null
		}

		return parentNode;
	}

	/**
	 * 新建结点，并且将其插入到二叉搜索树中
	 *
	 * @param element 要插入结点的element域值
	 */
	public void insert(T element) {
		Node<T> newNode = new Node<T>(element, null, null, null);

		if (newNode != null) {
			insert(this, newNode);
		}
	}

	/**
	 * 根据element的值来删除指定的结点
	 *
	 * @param element 要删除结点的element域
	 */
	public void delete(T element) {
		// 获取要删除的结点
		Node<T> toDeleteNode = search(element);
		// 如果该节点存在，就删除
		if (toDeleteNode != null) {
			delete(toDeleteNode);
		}
	}

	public void remove(T element) {
		Node<T> toDeleteNode = search(element);

		if (toDeleteNode != null) {
			remove(this,toDeleteNode);
		}
	}

	public void clear() {
		destory(root);
		root = null;
	}

	public void print() {
		if (root != null) {
			print(root, root.element, 0);
		}
	}

	private void preOrderTraverse(Node<T> node) {
		if (node != null) {
			printNode(node);
			preOrderTraverse(node.leftChild);
			preOrderTraverse(node.rightChild);
		}
	}

	private void inOrderTraverse(Node<T> node) {
		if (node != null) {
			inOrderTraverse(node.leftChild);
			printNode(node);
			inOrderTraverse(node.rightChild);
		}
	}

	private void postOrderTraverse(Node node) {
		if (node != null) {
			postOrderTraverse(node.leftChild);
			postOrderTraverse(node.rightChild);
			printNode(node);
		}
	}

	private void printNode(Node<T> node) {
		System.out.println(node.toString());
	}

	private Node<T> search(Node<T> node, T element) {
		if (node == null) {
			return null;
		}

		int compareResult = element.compareTo(node.element);
		if (compareResult < 0) {
			return search(node.leftChild, element);
		} else if (compareResult > 0) {
			return search(node.rightChild, element);
		} else
			return node;
	}

	private Node<T> iterativeSearch(Node<T> node, T element) {
		while (node != null) {
			int compareResult = element.compareTo(node.element);
			if (compareResult < 0) {
				node = node.leftChild;
			} else if (compareResult > 0) {
				node = node.rightChild;
			} else {
				return node;
			}
		}
		return node;
	}

	private Node<T> min(Node<T> node) {
		if (node == null) {
			return null;
		}

		while (node.leftChild != null) {
			node = node.leftChild;
		}
		return node;
	}

	/**
	 * 查找以node为根结点的二叉树的最大结点
	 *
	 * @param node node为所要查找的二叉树的根结点
	 * @return 返回以node为根结点的二叉树的最大结点
	 */
	private Node<T> max(Node<T> node) {
		if (node == null) {
			return null;
		}

		while (node.rightChild != null) {
			node = node.rightChild;
		}
		return node;
	}

	/**
	 * @param binarySortTree 所要插入新结点的搜索二叉树
	 * @param newNode    所要插入的新结点
	 */
	private void insert(BinarySortTree<T> binarySortTree, Node<T> newNode) {
		int compareResult;
		Node<T> newNodeParent = null;  // 这个结点就是新结点的父结点
		Node<T> subRoot = binarySortTree.root;  // 子树的根，初始值为搜索二叉树的根结点

		// 查找新结点newNode要插入的位置，即寻找出新结点"正确、合适"的父结点
		while (subRoot != null) {
			newNodeParent = subRoot;
			compareResult = newNode.element.compareTo(subRoot.element);

			if (compareResult < 0) {
				subRoot = subRoot.leftChild;
			} else {
				subRoot = subRoot.rightChild;
			}
		}

		newNode.parent = newNodeParent;
		// 搜索二叉树是空树时，插入的新结点就是根结点
		if (newNodeParent == null) {
			binarySortTree.root = newNode;
		} else {
			compareResult = newNode.element.compareTo(newNodeParent.element);
			// 判断新结点是插入到它父结点的左边还是右边
			if (compareResult < 0) {
				newNodeParent.leftChild = newNode;
			} else {
				newNodeParent.rightChild = newNode;
			}
		}
	}

	/**
	 * 删除二叉树查找树的节点，总共有三种情况：
	 * 1. 被删除的节点是叶子节点，这时候只要把这个节点删除，再把指向这个节点的父节点指针置为空就行
	 * 2. 被删除的节点有左子树，或者有右子树，而且只有其中一个，那么只要把当前删除节点的父节点指向被删除节点的左子树或者右子树就行。
	 * 3. 被删除的节点既有左子树又有右子树，需要把左子树的最右边的节点或者右子树最左边的节点提到被删除节点的位置。
	 * 3.1 根据二叉查找树的性质，父节点的指针一定比所有左子树的节点值大而且比右子树的节点的值小，为了删除父节点不破坏二叉查找树的平衡性，应当把左子树最大的节点或者右子树最小的节点放在父节点的位置（找的是右子树的最小节点）
	 * <p>
	 * 二叉树的删除可以算是二叉树最为复杂的操作，删除的时候要考虑到很多种情况：
	 * 1. 被删除的节点是叶子节点
	 * 2. 被删除的节点只有左孩子节点
	 * 3. 被删除的节点只有右孩子节点
	 * 4. 被删除的有两个孩子节点
	 * 所以在删除的时候，这4种情况都必须考虑进去，并且这4中情况之下，还会有细的划分
	 *
	 * @param toDeleteNode 待删除的结点
	 * @return 返回待删除的结点
	 */
	private Node<T> delete(Node<T> toDeleteNode) {
		// 若同时存在左右结点
		if (toDeleteNode.leftChild != null && toDeleteNode.rightChild != null) {
			// 获取带删除结点的后继结点
			Node<T> successor = successor(toDeleteNode);
			// 转移后继结点的element域值到当前待删除结点
			toDeleteNode.element = successor.element;
			// 把当前要删除的结点设置为原来待删除结点的后继结点
			toDeleteNode = successor;
		}
		// 经过上面的处理，下面只剩下两种情况：
		// 待删除的结点，只有一个子结点（而且如果原先待删除的结点有左右两个儿子的话，那么现在的待删除结点如果有一个子结点，那么该子结点必定是右儿子，
		// 否则位于原先待删除结点的右子树重的sucessor还可以继续往下走一层，因为我们要找的就是待删除结点的右子树中最左边的结点）、
		// 或是没有结点（即sucessor是就是一个叶子结点）
		// 不管待删除的结点是否有子结点，都获取其子结点
		Node<T> childNode;
		if (toDeleteNode.leftChild != null) {
			childNode = toDeleteNode.leftChild;
		} else {
			childNode = toDeleteNode.rightChild;  // 如果待删除的结点没有左结点，就获取其右结点
		}

		// 如果childNode不是null，就说明是有一个结点的情况
		// 若childNode是null，即待删除的结点是叶子结点，那么就不需要进行关联
		if (childNode != null) {
			// 将子结点和父结点关联上
			childNode.parent = toDeleteNode.parent;
		}
		// 如果当前待删除的结点没有父结点（后继情况到这儿时，一定有父结点），说明待删除的结点就是根结点
		if (toDeleteNode.parent == null) {
			// 根结点设置为子结点
			// 按照前面的逻辑，根只有一个或者没有结点，所以直接赋值childNode即可
			this.root = childNode;
		} else if (toDeleteNode == toDeleteNode.parent.leftChild) {
			// 如果存在父结点，并且当前结点是左结点时，将父结点的左结点设置为childNode
			// 实际上这里把toDeleteNode是叶子结点的情况也包含了进去，此时的childNode=null
			toDeleteNode.parent.leftChild = childNode;
		} else {
			// 如果存在父结点，并且当前结点是右结点时，将父结点的右结点设置为childNode
			// 实际上这里把toDeleteNode是叶子结点的情况也包含了进去，此时的childNode=null
			toDeleteNode.parent.rightChild = childNode;
		}
		return toDeleteNode;
	}

	/**
	 * 这个方法和delete()方法作用是一样的，但是在实现上略有区别
	 * @param binarySortTree
	 * @param toDeleteNode
	 * @return
	 */
	private Node<T> remove(BinarySortTree<T> binarySortTree, Node<T> toDeleteNode) {
		Node<T> childNode=null;
		Node<T> tempNode=null;

		// 如果待删除结点只有一个子结点或是没有结点
		if (toDeleteNode.leftChild == null || toDeleteNode.rightChild == null) {
			tempNode = toDeleteNode;
		} else {
			// 如果待删除结点有两个儿子，那么这里选择删除其后继结点（选择前驱结点也是可以的）
			// 在后面我们会令待被删除的结点的element域值被赋值为其sucessor的element域值，
			// 这样在删除结点的时候，就只要把sucessor、也即tempNode删除即可，实现一个"统一"
			tempNode = successor(toDeleteNode);
		}

		// 获取子结点，不管是左结点还是右结点
		if (tempNode.leftChild != null) {
			childNode = tempNode.leftChild;  // childNode有可能为null
		} else {
			childNode = tempNode.rightChild;  // childNode有可能为null
		}

		// 如果存在子结点，就关联待删除结点的父结点
		if (childNode != null) {
			childNode.parent = tempNode.parent;
		}
		// 如果要删除的tempNode的父结点是空，说明要删除的tempNode是根结点
		if (tempNode.parent == null) {
			// 设置根结点为childNode（此时根只有一个结点、或是没有结点
			binarySortTree.root = childNode;
		} else if (tempNode == tempNode.parent.leftChild) {
			// 如果要删除的结点是一个左结点
			tempNode.parent.leftChild = childNode;
		} else {
			// 如果要删除的结点是一个右结点
			tempNode.parent.rightChild = childNode;
		}

		// 如果要删除的结点和一开始传入的芥蒂娜不一样，那就是后继的情况（即原先待被删除的结点有两个儿子，我们取tempNode为原先待删除结点的直接后继
		if (tempNode != toDeleteNode) {
			// 后继的值传给本来要删除的结点
			// 实际上这个算法，先把待删除结点的直接后继删除，然后把直接后继的值赋给原先待删除的结点
			toDeleteNode.element = tempNode.element;
		}
		// 返回被删除的结点
		return tempNode;
	}

	private void destory(Node<T> root) {
		if (root == null) {
			return;
		}

		if (root.leftChild != null) {
			destory(root.leftChild);
		}
		if (root.rightChild != null) {
			destory(root.rightChild);
		}
	}

	private void print(Node<T> root, T element, int direction) {
		if (root != null) {
			if (direction == 0)  // root是根结点
				System.out.printf("%2d is root\n", root.element);
			else
				System.out.printf("%2d is %2d's %6s child\n", root.element, element, direction == 1 ? "right" : "left");
		}
		print(root.leftChild, root.element, -1);
		print(root.rightChild, root.element, 1);
	}

	public static void main(String[] args) {

	}


}
