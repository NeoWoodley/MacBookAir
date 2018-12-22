package Graphics;

import java.util.ArrayList;

public class test {
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
	static private int[][] e2={
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
			hasCycle = true;
			System.out.print("Cycle:");
			while (j < trace.size()) {
				System.out.print(trace.get(j) + " ");
				j++;
			}
			System.out.print("\n");
			return;
		}
		trace.add(v);

		for (int i = 0; i < POINT_NUM; i++) {
			if (e2[v][i] == 1)
				findCycle(i);
		}
		trace.remove(trace.size() - 1);
	}
}
