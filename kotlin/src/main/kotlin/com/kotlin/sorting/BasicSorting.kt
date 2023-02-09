package com.kotlin.sorting

class BasicSorting(private val arr: IntArray) {

    // 삽입 정렬
    fun selectionSort(): IntArray{
        var largestIndex: Int
        var tmp: Int

        for (last in arr.size - 1 downTo 1) {
            largestIndex = theLargest(last)
            tmp = arr[largestIndex]
            arr[largestIndex] = arr[last]
            arr[last] = tmp
        }

        return arr

    }


    private fun theLargest(lastIndex: Int): Int {
        var largestIndex: Int = 0
        for (i in 0 .. lastIndex step 1) {
            if (arr[i] > arr[largestIndex]) {
                largestIndex = i
            }
        }
        return largestIndex
    }


    // 버블 정렬
    fun bubbleSort(): IntArray {
        var tmp: Int
        var last = arr.size

        for (k in 0 ..  arr.size) {
            for (i in 0 ..  last - 2 step 1) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i]
                    arr[i] = arr[i + 1]
                    arr[i + 1] = tmp
                }
            }
            last--
        }
        return arr
    }


    // 삽입 정렬
    fun insertSort(): IntArray {
        for (i in 1 until arr.size step 1) {
            var k = i - 1
            var newItem = arr[i]
            while (k >= 0 && arr[k] > newItem ) {
                arr[k+1] = arr[k]
                k--
            }
            arr[k+1] = newItem
        }
    }


}