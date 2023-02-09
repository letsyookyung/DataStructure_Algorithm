package com.kotlin.sorting

fun main(args: Array<String>) {
    val arr = IntArray(9)
    arr[0] = 2
    arr[1] = 10
    arr[2] = 3
    arr[3] = 6
    arr[4] = 7
    arr[5] = 1
    arr[6] = 23
    arr[7] = 11
    arr[8] = 0

    val s = BasicSorting(arr)

//    println(s.selectionSort())
    println(s.bubbleSort())

}