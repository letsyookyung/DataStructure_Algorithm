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

    graph.forEach { (k, v) -> v.sort() }
    println(graph)

    // dfs
    val stack = mutableListOf<Int>()
    val visited = mutableListOf<Int>()
    println(dfs(graph, start, stack, visited, vertexs))

    // bfs
    println(bfs(graph, start, vertexs))



}


fun dfs(graph: HashMap<Int, ArrayList<Int>>, vertex: Int, stack: MutableList<Int>, visited: MutableList<Int>, vertexs: Int): MutableList<Int> {
    stack.add(vertex)

    while (visited.size < vertexs) {

        val popped = stack[stack.lastIndex]
        stack.removeAt(stack.lastIndex)
        visited.add(popped)

        if (graph.contains(vertex)) {
            for (i in 0 until (graph[popped]!!.size)) {
                val nowVertex = graph[popped]!![i]
                if (!visited.contains(nowVertex) && !stack.contains(nowVertex)) {
                    dfs(graph, nowVertex, stack, visited, vertexs)
                }
            }
        }
    }
    return visited
}


fun bfs(graph: HashMap<Int, ArrayList<Int>>, start: Int, vertexs: Int): MutableList<Int> {
    val queue = mutableListOf<Int>()
    val visited = mutableListOf<Int>()
    var vertex: Int

    queue.add(start)

    while (visited.size < vertexs ) {
        vertex = queue[0]
        queue.removeAt(0)
        if (graph.contains(vertex)) {
            for (i in 0 until (graph[vertex]!!.size)) {
                val nowVertex = graph[vertex]!![i]
                if (!visited.contains(nowVertex) && !queue.contains(nowVertex)) {
                    queue.add(nowVertex)
                }
            }
        }
        visited.add(vertex)
    }
    return visited
}



