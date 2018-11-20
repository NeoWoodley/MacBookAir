package JosephusQuestionLinkedList;

/**
 * 约瑟夫问题
 * <p>
 * Josephus问题是下面的游戏：N个人编号从1到N，围坐成一个圆圈。从1号开始传递一个热土豆。
 * 经过M次传递后拿着热土豆的人被清除离座，围坐的圆圈紧缩，由坐在被清除的人后面的人拿起热土豆继续进行游戏。
 * 最后剩下的人取胜。
 * 因此，如果M=0和N=5，则游戏人依序被清除，5号游戏人获胜。
 * 如果M=1和N=5，那么被清除的人的顺序是2，4，1，5，3号人获胜。
 */
public class Solution {
	LinkedList<Integer> linkedList;

	/**
	 * @param N        总人数
	 * @param distance 距离，从1开始报数，报到（distance+1）的人就移出去
	 */
	public Solution(int N, int distance) {
		initLinkedList(N);
		solution(distance);
	}

	/**
	 * 初始化链表
	 *
	 * @param N 链表的总结点数
	 */
	private void initLinkedList(int N) {
		this.linkedList = new LinkedList();
		for (int i = 1; i <= N; i++) {
			this.linkedList.add(i);
		}

//		linkedList.printWinner();
	}

	/**
	 * @param distance 距离
	 */
	private void solution(int distance) {
		int index = 0;
		// 以此循环删除一个元素，直到链表中只剩下一个元素
		while (this.linkedList.size > 1) {
			for (int i = 0; i < distance; i++) {
				index++;
			}
			// 取模更简洁
//			while (index >= this.linkedList.size) {
//				index-=this.linkedList.size;
//			}
			index = index % this.linkedList.size;
			this.linkedList.remove(index);
//			int element=this.linkedList.remove(index);
//			System.out.println(element);
		}
		this.linkedList.printWinner();

	}

	public static void main(String[] args) {
		new Solution(10, 3);
	}
}
