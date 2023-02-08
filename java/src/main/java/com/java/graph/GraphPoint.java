package com.java.graph;


public class GraphPoint {
	public int[] contactingPoints;
	public boolean visited;

	public GraphPoint(int[] contactingPoints, boolean visited) {
		this.contactingPoints = contactingPoints;
		this.visited = visited;
	}

}
