package Graphics;

import java.util.ArrayList;

public class BetterArith {
	static private final int POINT_NUM = 9;
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
	static ArrayList<Integer> trace = new ArrayList<Integer>();
	static boolean hasCycle = false;
	static int j;

	public static void main(String[] args) {
		findCycle(0);
		if (!hasCycle)
			System.out.println("No Cycle.");
	}

	static void findCycle(int v) {
		if ((j = trace.indexOf(v)) != -1) {
			// 如果当前被访问的结点已经在递归调用栈中，即trace路径中，就说明当前的递归调用栈中，从结点v开始再回到结点v的路径可以构成一个环
			hasCycle = true;
			System.out.print("Cycle:");
			while (j < trace.size()) {  // 打印环
				System.out.print(trace.get(j) + " ");
				j++;
			}
			System.out.print("\n");
			return;
		}
		trace.add(v);  // 模拟递归调用栈的入栈

		// 深度优先搜索
		for (int i = 0; i < POINT_NUM; i++) {
			if (e[v][i] == 1)
				findCycle(i);
		}
		trace.remove(trace.size() - 1);  // 模拟递归调用栈的出栈
	}
}

