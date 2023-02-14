package com.kotlin.graph

class DFS (graph: HashMap<Int, GraphPoint>)  {
    private val graph: HashMap<Int, GraphPoint>
    private var stack = emptyArray<Int>()
    private val visited = emptyArray<Int>()
    private var vertex: Int = 0

    init {
        this.graph = graph
    }

    fun doDFS(vertex: Int) {
        while (visited.size <= graph.size) {
            if (!graph[vertex]!!.visited) {
                print("$vertex -> ")
                stack.plus(vertex)
                graph[vertex]!!.visited = true
                visited.plus(vertex)

                for (i in 0 until graph[vertex]!!.contactingPoints.size) {
                    val cpt = graph[vertex]!!.contactingPoints[i]
                    if (!graph[cpt]!!.visited && !stack.contains(cpt)) {
                        doDFS(cpt)
                    }
                }
            }
        }


    }


}
