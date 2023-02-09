package com.kotlin.heap

fun main(args: Array<String>) {

    val heap1 = Heap(15)

    heap1.buildHeap()
    heap1.insert(1)
    heap1.insert(9)
    heap1.insert(7)
    heap1.insert(8)
    heap1.insert(2)
    heap1.insert(3)
    heap1.insert(3)
    heap1.insert(4)
    heap1.insert(5)
//    heap1.buildHeap()

    println(heap1.deleteMax())
    println(heap1.deleteMax())
    println(heap1.deleteMax())
    println(heap1.deleteMax())
    println(heap1.deleteMax())
    println(heap1.deleteMax())
    println(heap1.deleteMax())
    println(heap1.deleteMax())
    println(heap1.deleteMax())
    println(heap1.deleteMax())
//    println(heap1.deleteMax())
//    println(heap1.deleteMax())





}