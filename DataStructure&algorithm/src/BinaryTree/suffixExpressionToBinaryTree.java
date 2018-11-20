//package BinarySortTree;
//
//import java.util.Stack;
//
//public class suffixExpressionToBinaryTree {
//	// 内部类
//	public class BSTNode<T extends Comparable<T>> {
//		T key;                // 关键字(键值)
//		BSTNode<T> left;    // 左孩子
//		BSTNode<T> right;    // 右孩子
//		BSTNode<T> parent;    // 父结点
//
//		public BSTNode(T key, BSTNode<T> parent, BSTNode<T> left, BSTNode<T> right) {
//			this.key = key;
//			this.parent = parent;
//			this.left = left;
//			this.right = right;
//		}
//
//		public T getKey() {
//			return key;
//		}
//
//		public String toString() {
//			return "key:" + key;
//		}
//	}
//
//	/**
//	 * 后缀表达式转二叉表达式树
//	 * @param suffixStr
//	 */
//	public void suffixExpression2Tree(String suffixStr){
//		if(isEmpty(suffixStr)) return;
//
//		char[] string=suffixStr.toCharArray();
//		// 用于临时存储节点的栈
//		Stack<BSTNode> stack=new Stack<>();
//		// 遍历所有字符，不是运算符的入栈，是运算符的，将栈中两个节点取出，合成一颗树然后入栈
//		for(int i=0;i<string.length;i++)
//		{
//			if(isOperator(string[i]))
//			{
//				if(stack.isEmpty()||stack.size()<2)
//				{
//					System.err.println("输入的后缀表达式不正确");
//					return;
//				}
//				BSTNode root=new BSTNode<>(string[i]);
//				root.left=stack.pop();
//				root.right=stack.pop();
//				stack.push(root);
//			}
//			else
//			{
//				stack.push(new BSTNode<>(string[i]));
//			}
//		}
//		if(stack.isEmpty()||stack.size()>1)
//		{
//			System.err.println("输入的后缀表达式不正确");
//			return;
//		}
//		stack.pop().printAll();
//	}
////---------------------
////	作者：KesarChen
////	来源：CSDN
////	原文：https://blog.csdn.net/kesarchen/article/details/50685456
////	版权声明：本文为博主原创文章，转载请附上博文链接！
//}
//
