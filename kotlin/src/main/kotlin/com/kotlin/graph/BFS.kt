package com.kotlin.graph


class BFS (graph: HashMap<Int, GraphPoint>)  {
    private val graph: HashMap<Int, GraphPoint>
    private var queue = emptyArray<Int>()
    private val visited = emptyArray<Int>()
    private var vertex: Int = 0

    init {
        this.graph = graph
    }

    fun doBFS(startVertex: Int) {
        enqueue(startVertex)
        print("시작")

        while (queue.isNotEmpty()) {
            vertex = dequeue()
            for (i in 0 until graph[vertex]!!.contactingPoints.size) {
                val cpt = graph[vertex]!!.contactingPoints[i]
                if (!graph[cpt]!!.visited && !queue.contains(cpt))  {
                    enqueue(cpt)
                }
            }
            visited.plus(vertex)
            graph[vertex]!!.visited = true
            print("->$vertex")
        }

    }


    private fun enqueue(q: Int) {
        queue = queue.plus(q)
    }


    private fun dequeue(): Int {
        val rq = queue[0]
        queue = queue.sliceArray(1 until queue.size-1)
        return rq
    }


}