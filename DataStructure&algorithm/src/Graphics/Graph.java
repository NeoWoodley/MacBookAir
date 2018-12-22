package Graphics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 这是我自己写的
 */
public class Graph {
	private final int V = 100;  // 顶点的数目，假定有100，实际可能并没有这么多
	private int[][] adj;  // 邻接矩阵
	private List<Integer> vertex = new ArrayList<>();  // 记录无重复的顶点的值，vertex.get(i)=邻接矩阵第i行、第i列代表的顶点的值
	private List<List<Integer>> paths = new ArrayList<>();  // 记录从起始结点到当前结点的路径（保存的是结点的索引值），如果构成一个环路则保留；否则就丢弃
	private boolean hasCycle;
	/**
	 * 0：表示结点没有被访问过，是一个新结点==>不作处理
	 * -1：表示该结点至少被访问过一次==>有环
	 * 1：表示该结点的后代结点都已经被访问过了==>无环
	 */

	private int[] visited = new int[V];  // 记录结点是否被访问过
	private boolean[] DFSvisited;
	private List<Integer> DFSpath = new ArrayList<>();


	public Graph() {
		adj = new int[V][V];
		paths.add(new ArrayList<>());
	}

	/**
	 * @param string 格式：23,56
	 */
	public void addEdge(String string) {
		int v, w;
		v = Integer.valueOf(string.substring(0, string.indexOf(",")));
		w = Integer.valueOf(string.substring(string.indexOf(",") + 1));
		addEdge(v, w);
//		System.out.println(v + "->" + w);
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
		findCycle(1);

	}

	private void findCycle(int startIndex) {
		if (visited[startIndex] == 0) {  // 如果遇到的结点是新结点、之前没有被访问过
			visited[startIndex] = -1;
			paths.get(paths.size() - 1).add(startIndex);
		} else if (visited[startIndex] == 1) {  // 如果遇到的结点的后代结点都已经被访问过了，说明没有环
			paths.remove(paths.size() - 1);
			return;
		} else if (visited[startIndex] == -1) {  // 如果遇到的结点被访问过至少一次了，说明有环
			hasCycle = true;
			paths.add(new ArrayList<>());
//			findCycle(startIndex);
			return;
		}

		for (int i = 0; i < vertex.size(); i++) {
			if (adj[startIndex][i] == 1) {
				findCycle(i);
			}
		}
		visited[startIndex] = 1;
	}

	/**
	 * 深度优先搜索图
	 */
	public void DFS() {
		DFSvisited = new boolean[vertex.size()];
		Arrays.fill(DFSvisited, false);
		for (int i = 0; i < vertex.size(); i++) {
			if (!DFSvisited[i]) {  // 如果这个结点还没有被访问过，就对其进行深度优先搜索
				DFS(i);
			}
		}
	}

	/**
	 * 深度优先搜索图的递归实现
	 *
	 * @param i
	 */
	private void DFS(int i) {
		DFSvisited[i] = true;
		DFSpath.add(vertex.get(i));  // 加入到DBS访问路径中
		// 遍历该顶点的所有邻接顶点。若是没有访问过，那么就继续往下走
		for (int w = firstVertex(i); w >= 0; w = nextVertex(i, w)) {
			if (!DFSvisited[w]) {
				DFS(w);
			}
		}
	}

	/**
	 * 返回索引为index的顶点的第一个邻接顶点的索引
	 * 如果失败则返回-1
	 *
	 * @param index
	 * @return
	 */
	private int firstVertex(int index) {
		// 检查index范围的规范性
		if (index < 0 || index > vertex.size() - 1) {
			return -1;
		}
		for (int i = 0; i < vertex.size(); i++) {
			if (adj[index][i] == 1) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 返回索引为v的顶点相对于索引为w的顶点的下一个邻接顶点的索引
	 * 如果失败则返回-1
	 *
	 * @param v
	 * @param w
	 * @return
	 */
	private int nextVertex(int v, int w) {
		// 检查索引值v、w规范性
		if (v < 0 || v > vertex.size() - 1 || w < 0 || w > vertex.size() - 1) {
			return -1;
		}
		// 从索引值为w+1处开始搜索邻接顶点
		for (int i = w + 1; i < vertex.size(); i++) {
			if (adj[v][i] == 1) {
				return i;
			}
		}
		return -1;
	}

	public void printAdj() {
		for (int i = 0; i < vertex.size(); i++) {
			for (int j = 0; j < vertex.size(); j++) {
				System.out.print(adj[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void printCycle() {
		if (!hasCycle) {
			System.out.println("No");
			return;
		}

		System.out.println("Yes");
		for (List<Integer> path : paths) {
			for (Integer index : path) {
				System.out.print(vertex.get(index) + "->");
			}
			System.out.println();
		}
	}

	/**
	 * 在文件中读取图的信息
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		Graph graph = new Graph();
		Path paths = Paths.get("/Users/neowoodley/egdes.txt");
		try {
			BufferedReader reader = Files.newBufferedReader(paths);
			String string;
			while ((string = reader.readLine()) != null) {
				graph.addEdge(string);
			}
			graph.findCycle();
			graph.printCycle();
			graph.printAdj();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
	}
}
