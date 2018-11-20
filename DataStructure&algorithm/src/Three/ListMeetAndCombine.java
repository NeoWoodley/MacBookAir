package Three;

import java.util.Iterator;
import java.util.LinkedList;

public class ListMeetAndCombine<T extends Comparable<? super T>> {
	LinkedList listA;
	LinkedList listB;
	LinkedList newMeetList;
	LinkedList newCombineList;

	public ListMeetAndCombine(LinkedList listA, LinkedList listB) {
		this.listA = listA;
		this.listB = listB;
		newMeetList = new LinkedList<T>();
	}

// TODO: 2018/9/22 迭代器怎么使用？类型转换？？？

	/**
	 * 链表的交运算
	 *
	 * @return
	 */
	public LinkedList meet() {
		Iterator iteratorA = listA.iterator();
		Iterator iteratorB = listB.iterator();
		T elementA = (T) iteratorA.next();
		T elementB = (T) iteratorB.next();
		do {
			if (elementA==elementB) {
				this.newMeetList.add(elementA);
				elementA = (T) iteratorA.next();
			} else if (elementA.compareTo(elementB) > 0) {
				this.newMeetList.add(elementB);
				elementB = (T) iteratorB.next();
			} else {
				this.newMeetList.add(elementA);
				elementA = (T) iteratorA.next();
				elementB = (T) iteratorB.next();
			}
		} while (iteratorA.hasNext() && iteratorB.hasNext());

		System.out.println(elementA + " " + elementB);
		if (!iteratorA.hasNext()&&!iteratorB.hasNext()) {
			return newMeetList;
		}

		// A已经全部加入，但B没有
		while (!iteratorB.hasNext()) {
			this.newMeetList.add(elementA);
			elementA=(T)iteratorA.next();
		}
		print();
		return newMeetList;
	}

	/**
	 * 链表的并运算
	 *
	 * @return
	 */
	public LinkedList combine() {
		return newCombineList;
	}

	public void print() {
		Iterator iterator = newMeetList.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}
	public static void main(String[] args) {
		LinkedList listA = new LinkedList();
		LinkedList listB = new LinkedList();
		listA.add(1);
		listA.add(3);
		listA.add(5);
		listA.add(7);
		listB.add(2);
		listB.add(4);
		listB.add(6);
		listB.add(8);
		listB.add(10);
		listB.add(12);
		LinkedList linkedList = new ListMeetAndCombine(listA, listB).meet();

//		new ListMeetAndCombine(listA, listB).combine();
	}
}
