package com.kotlin.heap

interface PQInterface {

    fun insert(newItem: Int)

    fun deleteMax(): Int

    fun max(): Int

    fun buildHeap()

    fun isEmpty(): Boolean

    fun clear()
}