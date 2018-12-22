package Graphics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnyCycle {
	private int n;
	private int[] visited;  // 记录结点状态，值为0表示尚未被访问
	private int[][] e;  // 有向图的邻接矩阵
	private List<Integer> trace = new ArrayList<>();  // 从出发点到当前结点的轨迹
	private boolean hasCycle = false;

	public FindAnyCycle(int n, int[][] e) {
		this.n = n;
		this.e = e;
		visited = new int[n];
		Arrays.fill(visited, 0);  // 将数组中的元素全部初始化为0
	}

	/**
	 * 使用深度优先搜索来遍历图中的结点
	 *
	 * @param v 结点所在的索引位置
	 */
	public void findCycle(int v) {
		if (visited[v] == 1) {
			int j;
			if ((j = trace.indexOf(v)) != -1) {  // 如果v结点已经被访问过了，并且在trace中，即代表有环路
				hasCycle = true;
				System.out.println("Yes");
				while (j < trace.size()) {
					System.out.print(trace.get(j++) + "->");  // 输出环路
				}
				System.out.println();
				return;
			}
			return;
		}

		visited[v] = 1;
		trace.add(v);

		for (int i = 0; i < n; i++) {
			if (e[v][i] == 1) {
				findCycle(i);
			}
		}

		trace.remove(trace.size() - 1);
	}

	public static void main(String[] args) {
		int n = 9;
		int[][] e = {
				{0, 1, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 1, 1, 0, 0, 0, 0},
				{0, 0, 0, 0, 1, 0, 0, 0, 0},
				{0, 1, 0, 0, 0, 1, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 1, 1, 0},
				{0, 1, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 1},
				{0, 0, 0, 0, 0, 0, 0, 0, 0}
		};
		FindAnyCycle findAnyCycle = new FindAnyCycle(n, e);
		findAnyCycle.findCycle(0);
		if (!findAnyCycle.hasCycle) {
			System.out.println("No");
		}
	}
}
