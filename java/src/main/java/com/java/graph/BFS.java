package com.java.graph;


import java.util.*;

public class BFS {
	private HashMap<Integer, GraphPoint> graph;
	List<Integer> queue = new ArrayList<>();
	private List<Integer> visited = new ArrayList<>();

	public BFS(HashMap<Integer, GraphPoint> graph) {
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

		BFS bfs = new BFS(graph);
		bfs.doBfs(1);
	}


	public void doBfs(int startVertex) {
		queue.add(startVertex); // 시작 vertex  enqueue
		System.out.print("시작 ");

		while (!queue.isEmpty()) { // visited list가 전체 vertex 개수와 같아질 때 까지
			int vertex = queue.get(0); // dequeue 꺼내서 작업 진행할 vertex 지정

			if (!graph.get(vertex).visited) {
				for (int i = 0; i <= graph.get(vertex).contactingPoints.length - 1; i++) { // 지금 vertex와 접해있는 간선들
					int ctp = graph.get(vertex).contactingPoints[i];
					if (!visited.contains(ctp) && !queue.contains(ctp)) {
						queue.add(graph.get(vertex).contactingPoints[i]); // enqueue
					}
				}
				graph.get(vertex).visited = true;
				visited.add(vertex);
				queue.remove(0); // queue에서는 없앰
				System.out.printf("-> %d ", vertex);
			}

		}
	}

}





