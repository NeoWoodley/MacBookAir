package Tree;

public class BinaryNode<AnyType> {
	AnyType element;
	BinaryNode<AnyType> left;
	BinaryNode<AnyType> right;

	// 构造器
	BinaryNode(AnyType element) {
		this(element, null, null);
	}

	BinaryNode(AnyType element, BinaryNode<AnyType> left, BinaryNode<AnyType> right) {
		this.element=element;  // 结点中的数据
		this.left=left;  // 左儿子
		this.right=right;  // 右儿子
	}
}
