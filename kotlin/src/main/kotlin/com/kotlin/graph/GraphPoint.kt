package com.kotlin.graph

class GraphPoint(
    contactingPoints: ArrayList<Int> = arrayListOf(0)
) {
    var contactingPoints: ArrayList<Int>
    var visited: Boolean

    init {
        this.contactingPoints = contactingPoints
        this.visited = false
    }

}