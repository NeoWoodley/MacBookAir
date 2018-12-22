package Graphics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private final int V = 1000;
	private int[][] adj;  // 邻接矩阵
	private List<Integer> vertex = new ArrayList<>();  // 存放结点对应的值的大小
	private List<List<Integer>> paths = new ArrayList<>();  // 存放所有的环
	private List<Integer> presentPath = new ArrayList<>();  // 递归栈
	private List<Integer> cycle = new ArrayList<>();  // 当前的环
	private boolean hasCycle;

	public Main() {
		adj = new int[V][V];
	}

	public void addEdge(String string) {
		int v, w;
		v = Integer.valueOf(string.substring(0, string.indexOf(",")));
		w = Integer.valueOf(string.substring(string.indexOf(",") + 1));
		addEdge(v, w);
	}

	private void addEdge(int v, int w) {
		if (!vertex.contains(v)) {
			vertex.add(v);
		}
		if (!vertex.contains(w)) {
			vertex.add(w);
		}
		int indexOfV = vertex.indexOf(v);
		int indexOfW = vertex.indexOf(w);
		adj[indexOfV][indexOfW] = 1;
	}

	public void findCycle() {
		for (int i = 0; i < vertex.size(); i++) {
			findCycle(i);
		}
	}

	public boolean isSameCycle(List<Integer> cycle) {
		for (List<Integer> path : paths) {
			if (equalList(cycle, path)) {
				return true;
			}
		}
		return false;
	}

	public void findCycle(int v) {
		if (presentPath.contains(v)) {
			int presentIndex = presentPath.indexOf(v);
			hasCycle = true;
			for (int i = presentIndex; i < presentPath.size(); i++) {
				cycle.add(vertex.get(presentPath.get(i)));  // cycle中存储的是结点的值的大小
			}
			if (!isSameCycle(cycle))
				paths.add(cycle);
			cycle = new ArrayList<>();
			return;
		}
		presentPath.add(v);

		for (int i = 0; i < vertex.size(); i++) {
			if (adj[v][i] == 1) {
				findCycle(i);
			}
		}
		presentPath.remove(presentPath.size() - 1);
	}

	public void printCycles() {
		if (hasCycle) {
			System.out.println(1);
			System.out.println(paths.size());
			// 重新排列paths中环的顺序，按环的大小排序
			for (int i = 0; i < paths.size(); i++) {
				for (int j = i + 1; j < paths.size(); j++) {
					if (paths.get(i).size() > paths.get(j).size()) {
						exchange(i, j);
					}
				}
			}
			for (int i = 0; i < paths.size(); i++) {
				printCycle(paths.get(i));
				if (i != paths.size() - 1) {
					System.out.println();
				}
			}
		} else {
			System.out.print(0);
		}
	}

	private void exchange(int i, int j) {
		List<Integer> temp = new ArrayList<>(paths.get(i));
		paths.set(i, paths.get(j));
		paths.set(j, temp);
	}

	public void printCycle(List<Integer> path) {
		int miniIndex = 0;  // 该环最小值的索引对应的在path索引值
		int count = 0;  // 记录已经打印的结点的数量
		for (int i = 0; i < path.size(); i++) {
			if (path.get(miniIndex) > path.get(i)) {
				miniIndex = i;
			}
		}
		for (int i = miniIndex; i < path.size(); i++) {
			System.out.print(path.get(i));
			count++;
			if (count != path.size()) {
				System.out.print(" ");
			}
		}
		for (int i = 0; i < miniIndex; i++) {
			System.out.print(path.get(i));
			count++;
			if (count != path.size()) {
				System.out.print(" ");
			}
		}
	}

	public void printAdj() {
		for (int i = 0; i < vertex.size(); i++) {
			for (int j = 0; j < vertex.size(); j++) {
				System.out.print(adj[i][j]);
			}
			System.out.println();
		}
	}

	private boolean equalList(List<Integer> list1, List<Integer> list2) {
		return (list1.size() == list2.size()) && list1.containsAll(list2);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Main main = new Main();
		String string;
		while ((scanner.hasNext())) {
			string = scanner.nextLine();
			if (string.equals("#"))
				break;
			main.addEdge(string);
		}
		main.findCycle();
		main.printCycles();
		scanner.close();
	}
}
