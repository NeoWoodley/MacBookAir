package Sort;

/**
 * 优先队列是一种抽象数据类型，它表示了一组值和对这些值的操作，
 * 它的抽象层使我们能够方便地将应用程序（用例）和我们将在本节中学习的各种具体实现隔离开来
 * <p>
 * 为了保证灵活性，我们在实现中使用了泛型，将实现了Comparable接口的数据的类型作为参数Key，这使得我们可以不必再区别元素和元素的键，对数据类型和算法的描述也将更加清晰和简洁
 */
public class MaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;  // 基于堆的完全二叉树
	private int N = 0;  // 存储于pa[1..N]中，pq[0]没有使用

	public MaxPQ(int maxN) {
		pq = (Key[]) new Comparable[maxN];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void insert(Key v) {
		pq[++N] = v;
		swim(N);  // 将新添加的元素看看是否需要上浮
	}

	public Key delMax() {
		Key max = pq[1];  // 从根结点得到最大元素
		exch(1, N--);  // 将其和最后一个结点交换
		pq[N + 1] = null;  // 防止对象游离，使得Java垃圾回收机制能够顺利回收"垃圾"
		sink(1);  // 恢复堆的有序性
		return max;
	}

	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}

	private void exch(int i, int j) {
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}

	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k / 2, k);
			k = k / 2;
		}
	}

	private void sink(int k) {
		while (2 * k <= N) {
			int j = 2 * k;  // 左子结点
			if (j < N && less(j, j + 1))
				j++;  // 保证交换时，是将两个子结点中较大的那个和指定元素交换
			if (!less(k, j))
				break;
			exch(k, j);
			k = j;
		}
	}

	// TODO: 2018/8/26 动态调整数组大小省略了
}

