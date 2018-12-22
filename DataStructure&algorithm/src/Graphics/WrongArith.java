package Graphics;

import java.util.ArrayList;

public class WrongArith {
	static private final int POINT_NUM = 5;
	static private int[] visited = {0, 0, 0, 0, 0, 0, 0, 0, 0};
	static private int[][] e = {
			{0, 0, 0, 0, 0, 0, 0, 0, 1},
			{0, 0, 0, 1, 1, 0, 0, 0, 0},
			{1, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1, 0},
			{0, 0, 0, 0, 0, 0, 0, 1, 0},
			{0, 1, 0, 0, 0, 0, 0, 0, 0},
			{1, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 1, 0, 0, 0, 1, 0, 0},
			{0, 0, 0, 0, 0, 1, 0, 0, 0}};
	static private int[][] e2 = {
			{0, 1, 0, 0, 0},
			{0, 0, 1, 0, 0},
			{0, 0, 0, 1, 1},
			{0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0}};
	static ArrayList<Integer> trace = new ArrayList<Integer>();
	static boolean hasCycle = false;
	static int j;

	public static void main(String[] args) {
		findCycle(0);
		if (!hasCycle)
			System.out.println("No Cycle.");
	}

	static void findCycle(int v) {
		if (visited[v] == 1) {
			if ((j = trace.indexOf(v)) != -1) {  // 如果该结点已经被访问过了，并且已经被添加到trace路径中了，就说明存在环路
				hasCycle = true;
				System.out.print("Cycle:");
				while (j < trace.size()) {  // 打印环路
					System.out.print(trace.get(j) + " ");
					j++;
				}
				System.out.print("\n");
				return;  // 出栈
			}
			return;  // 出栈
		}
		// 如果该结点还没有被访问过，就修改该结点的isVisited值，并将这个结点添加到trace路径中
		visited[v] = 1;
		trace.add(v);

		// 采用深度优先搜索算法
		for (int i = 0; i < POINT_NUM; i++) {
			if (e2[v][i] == 1)
				findCycle(i);
		}
		trace.remove(trace.size() - 1);
	}

}
