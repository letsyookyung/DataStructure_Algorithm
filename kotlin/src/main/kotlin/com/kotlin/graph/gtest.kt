package com.kotlin.graph

fun main(args: Array<String>) {

    val graph = HashMap<Int, GraphPoint>()
    graph[1] = GraphPoint(arrayListOf(2,3,4))
    graph[2] = GraphPoint(arrayListOf(1,3,5))
    graph[3] = GraphPoint(arrayListOf(2,1,4))
    graph[4] = GraphPoint(arrayListOf(1,3,6))
    graph[5] = GraphPoint(arrayListOf(2,6,7))
    graph[6] = GraphPoint(arrayListOf(4,5))
    graph[7] = GraphPoint(arrayListOf(5))

//    val bfs = BFS(graph)
    val dfs = DFS(graph)

//    bfs.doBFS(1)

    dfs.doDFS(1)

}