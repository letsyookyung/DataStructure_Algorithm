package com.kotlin.sorting


fun main(args: Array<String>) {
    val arr = IntArray(10)
    arr[0] = 7
    arr[1] = 4
    arr[2] = 6
    arr[3] = 1
    arr[4] = 8
    arr[5] = 9
    arr[6] = 2
    arr[7] = 3
    arr[8] = 5

    val ms = AdvancedSorting(arr)

//    println(ms.mergeSort())
//    for (i in 0 .. arr.size) {
//        print(" ${arr[i]}")
//    }


//    ms.quickSort()
//    for (i in 0 .. arr.size) {
//        print(" ${arr[i]}")
//    }

    ms.heapSort()
    for (i in 0 .. arr.size) {
        print(" ${arr[i]}")
    }


}