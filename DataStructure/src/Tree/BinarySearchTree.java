package Tree;

import java.awt.*;
import java.nio.BufferUnderflowException;

/**
 * 由于数的递归定义，通常是递归地编写这些操作的例程
 *
 * @param <AnyType>
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {
	//private static class BinaryNode<AnyType> {}  可以作为内部类

	private BinaryNode<AnyType> root;

	// 以下是供外部调用的公有方法
	public BinarySearchTree() {
		root = null;
	}

	public void makeEmpty() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public boolean contains(AnyType x) {
		return contains(x, root);
	}

	public AnyType findMin() {
		if (isEmpty())
			throw new BufferUnderflowException();  // ?????
		return findMin(root).element;
	}

	public AnyType findMax() {
		if (isEmpty())
			throw new BufferUnderflowException();  // ?????
		return findMax(root).element;
	}

	public void insert(AnyType x) {
		root = insert(x, root);
	}

	public void remove(AnyType x) {
		root = remove(x, root);
	}

	public void printTree() {
		if (isEmpty())
			System.out.println("Empty tree.");
		else
			printTree(root);
	}

	// 以下是重载的私有方法
	private boolean contains(AnyType x, BinaryNode<AnyType> t) {
		if (t == null)  // 对是否空树进行测试，否则会生成一个通过null引用访问数据域的NullPointerException异常
			return false;
		int compareResult = x.compareTo(t.element);
		if (compareResult < 0)
			return contains(x, t.left);  // 尾递归，可以用while代替
		else if (compareResult > 0)
			return contains(x, t.right);  // 尾递归，可以用while代替
		else return true;
		// 这里的尾递归调用是合理的，因为算法表达式的简明性是以速度的降低为代价的，所使用的栈空间量只不过是O(logN)
	}

	/**
	 * 用递归编写findMin()
	 * @param t
	 * @return
	 */
	private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
		if (t == null)
			return null;
		else if (t.left == null)
			return t;
		return findMin(t.left);
	}

	/**
	 * 用非递归编写findMax()
	 * @param t
	 * @return
	 */
	private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
		if(t!=null)
			while(t.right!=null)
				t=t.right;
		return t;
	}

	/**
	 * 返回对新树根的引用
	 * @param x
	 * @param t
	 * @return
	 */
	private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
		if(t==null)
			return new BinaryNode<>(x, null, null);  // 递归的基础条件
		int compareResult = x.compareTo(t.element);
		if (compareResult<0)
			t.left = insert(x, t.left);
		else if (compareResult>0)
			t.right = insert(x, t.right);
		else
			;  // Duplicate;do nothing
		return t;  // 相等的情况？？？
	}

	private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
		if(t==null)
			return t;
		int compareResult = x.compareTo(t.element);
		if (compareResult<0)
			t.left = remove(x, t.left);  // 左儿子被赋值为删除指定节点后的子树的根节点
		else if(compareResult>0)
			t.right = remove(x, t.right);  // 右儿子被赋值为删除指定节点后的子树的根节点
		else if (t.left != null && t.right != null) {  // 如果该节点恰好为要删除的节点，并且该节点有两个儿子
			t.element=findMin(t.right).element;  // 寻找该节点右子树中最小的节点，并用该最小节点的数据代替要删除的节点的数据，因为该最小节点必定没有左儿子
			t.right = remove(t.element, t.right);  // 递归地删除已被删除的节点的右子树中用来代替被删除节点的数据的那个最小节点
		} else
			t=(t.left!=null)?t.left:t.right;  // 如果该节点恰好为要删除的节点，并且该节点最多只有一个儿子。若被删除的节点为树叶，则返回t=null，导致倒数第二次的调用t.left=remove(x, t.left);或是t.right = remove(x, t.right);的等于号右边的值为null，即完成了树叶的删除
		return t;  // 最后一次返回的是删除指定节点后的新"根节点"
	}

	private void printTree(BinaryNode<AnyType> t) {
		if (t != null) {
			printTree(t.left);
			System.out.println(t.element);
			printTree(t.right);
		}
	}

	public AnyType rootElement() {
		return root.element;
	}

	public static void main(String[] args) {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
		binarySearchTree.insert(6);
		binarySearchTree.insert(2);
		binarySearchTree.insert(8);
		binarySearchTree.insert(1);
		binarySearchTree.insert(4);
		binarySearchTree.insert(3);
//		System.out.println(binarySearchTree.rootElement());
		binarySearchTree.remove(3);
		binarySearchTree.printTree();

		// TODO: 2018/9/8  这里不对了，有大问题啊。根节点就错了！！！还是说，插入顺序会影响根节点、整棵树的排列？？？
	}
}
