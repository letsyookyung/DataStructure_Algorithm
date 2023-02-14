package com.kotlin.graph

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (vertexs, edge, start) = readLine().split(" ").map { it.toInt() }
    val graph = HashMap<Int, ArrayList<Int>>()


    repeat(edge) {
        val edgesList = ArrayList<Int>()
        val (k, v) = readLine().split(" ").map { it.toInt() }
        if (graph.contains(k)) {
            graph[k]?.add(v)
        } else {
            edgesList.add(v)
            graph[k] = edgesList
        }
    }
    println(graph)

    // 맵 돌려서 value sorting
    graph.forEach { (k, v) -> v.sort() }

    // bfs
    bfs(graph, start, vertexs)

    // dfs

}


fun bfs(graph: HashMap<Int, ArrayList<Int>>, start: Int, vertexs: Int): Array<Int> {
    var queue = emptyArray<Int>()
    val visited = emptyArray<Int>()

    // 1.큐의 start 넣기
    queue.plus(start)

    // 2.모든 vertex들을 visiting 할 때 까지 최대가
    while (visited.size < vertexs) {
        val vertex = queue[0]
        queue = queue.sliceArray(1 ..queue.lastIndex-1)

        for (i in 0 until (graph[vertex]!!.size)) {
            val now = graph[vertex]!![i]
            if (!visited.contains(now) && !queue.contains(now)) {
                queue.plus(now)
            }
        }
        visited.plus(vertex)
    }

    return visited
    // 3.dequeue 꺼낸 것 = 현재 vertex

    // 4.이미 visit했거나, 이미 queue에 쌓여 있는 것 빼고, 큐의 쌓기

    // 5.현재 vertex visited[]에 추가하기

}