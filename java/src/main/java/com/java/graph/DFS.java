package com.java.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DFS {
	private HashMap<Integer, GraphPoint> graph;
	List<Integer> stack = new ArrayList<>();
	private List<Integer> visited = new ArrayList<>();
	private int vertex;

	public DFS(HashMap<Integer, GraphPoint> graph) {
		this.graph = graph;
	}


	public static void main(String[] args) {
		HashMap<Integer, GraphPoint> graph = new HashMap<>();
		graph.put(1, new GraphPoint(new int[]{2, 3, 4}, false));
		graph.put(2, new GraphPoint(new int[]{1, 3, 5}, false));
		graph.put(3, new GraphPoint(new int[]{2, 1, 4}, false));
		graph.put(4, new GraphPoint(new int[]{1, 3, 6}, false));
		graph.put(5, new GraphPoint(new int[]{2, 6, 7}, false));
		graph.put(6, new GraphPoint(new int[]{4, 5}, false));
		graph.put(7, new GraphPoint(new int[]{5}, false));

		DFS dfs = new DFS(graph);
		dfs.doDfs(1);
	}


	public void doDfs(int vertex) {

		while (visited.size() <= graph.size()) {
			if (!visited.contains(vertex)) {
				System.out.printf("-> %d ", vertex);
				stack.add(vertex);
				graph.get(vertex).visited = true;
				visited.add(vertex);

				for (int i = 0; i <= graph.get(vertex).contactingPoints.length - 1; i++) {
					int ctp = graph.get(vertex).contactingPoints[i];
					if (!visited.contains(ctp)) {
						doDfs(ctp);
					}
				}
			}

		}
	}

}

