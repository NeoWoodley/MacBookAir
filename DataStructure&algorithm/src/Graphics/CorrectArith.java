package Graphics;

import java.util.ArrayList;

public class CorrectArith {
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
	static ArrayList<Integer> trace = new ArrayList<Integer>();  // 记录查找换的路径，等价于递归的调用栈
	static boolean hasCycle = false;
	static int j;

	public static void main(String[] args) {
		findCycle(0);
		if (!hasCycle)
			System.out.println("No Cycle.");
	}

	static void findCycle(int v) {
		if (!trace.contains(v) && visited[v] == 1) {
			// 如果该结点在之前的查找环路中已经被访问过了，但在本次查找的trace路径中没有这个结点
			// 说明这可能是一个新的环路，因为这个在先前已经被访问过的结点v，现在又有了一条新的路径可以到达它
			visited[v] = 0;
		}
		if (visited[v] == 1) {
			if ((j = trace.indexOf(v)) != -1) {
				hasCycle = true;
				System.out.print("Cycle:");
				while (j < trace.size()) {
					System.out.print(trace.get(j) + " ");
					j++;
				}
				System.out.print("\n");
				return;  // 真正的递归调用栈出栈
			}
			return;  // 真正的递归调用栈出栈
		}
		visited[v] = 1;
		trace.add(v);

		for (int i = 0; i < POINT_NUM; i++) {
			if (e2[v][i] == 1)
				findCycle(i);
		}
		trace.remove(trace.size() - 1);  // 模拟递归调用栈的出栈
	}
}
