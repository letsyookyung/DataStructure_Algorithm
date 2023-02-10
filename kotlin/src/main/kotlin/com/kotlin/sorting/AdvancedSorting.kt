package com.kotlin.sorting



class AdvancedSorting(private val arr: IntArray) {

    // merge sort 병합 정렬
    fun mergeSort() {
        val temp: IntArray = arr.copyOf()
        mSort(0, arr.size - 1, temp)

    }


    private fun mSort(p: Int, r: Int, temp: IntArray) {
        if (p < r) {
            val q = (p + r) / 2
            mSort(p, q, temp)
            mSort(q + 1, r, temp)
            merge(p, q, r, temp)
        }
    }


    private fun merge(p: Int, q: Int, r: Int, temp: IntArray) {
        var i = p
        var k = q + 1
        var t = 0

        while (i <= q && k <= r) {
            if (arr[i] > arr[k]) {
                temp[t++] = arr[k++]
            } else {
                temp[t++] = arr[i++]
            }
        }

        while (i <= q) {
            temp[t++] = arr[i++]
        }

        while (k <= r) {
            temp[t++] = arr[k++]
        }

        i = p
        t = 0
        while (i <= r) {
            arr[i++] = temp[t++]
        }

    }


    // 퀵 정렬 quick sort
    fun quickSort() {
        qSort(0, arr.size - 1)
    }


    private fun qSort(p: Int, r: Int) {
        if (p < r) run {
            val q = partition(p, r)
            qSort(p, q - 1)
            qSort(q + 1, r)
        }
    }


    private fun partition(p: Int, r: Int): Int { // 가장 마지막 자리의 원소부터 시작
        val pivot: Int = arr[r] // 가장 마지막 자리가 피봇(비교값)
        var i = p - 1 // 시작하는 맨 왼쪽자리
        var tmp = 0

        for (j in p until r step 1) { // 피봇자리까지 쭉 돌기
            if (arr[j] < pivot) { // 피봇보다 작은 수면
                i++
                tmp = arr[i] // 왼쪽자리에 배치
                arr[i] = arr[j]
                arr[j] = tmp
            }
        }
        // 피봇 기준 작은 수 왼쪽/오른쪽 나뉘었으면
        tmp = arr[i + 1] // 그 중간에(작은 수 모음 끝 +1 자리) 피봇 값 껴넣기
        arr[i + 1] = arr[r]
        arr[r] = tmp

        return i + 1 // 피봇이 현재 있는 인덱스 = 다음 partition한 가장 마지막 자리
    }


    // 힙정렬
    fun heapSort() {
        buildHeap()
        var tmp: Int
        for (i in arr.size - 1 downTo 1) {
            tmp = arr[0]
            arr[0] = arr[i]
            arr[i] = tmp
            percolateDown(0, i - 1) // 기존 힙구조에서 대상으로하는 배열의 개수가 하나씩 줄어드는것만 다름
        }
    }


    private fun buildHeap() {
        if (arr.size >= 2) {
            for (i in (arr.size - 2) / 2 downTo 0 step 1) {
                percolateDown(i, arr.size - 1)
            }
        }
    }


    private fun percolateDown(i: Int, n: Int) {
        var child = 2 * i + 1
        val rightChild = 2 * i + 2
        val tmp: Int

        if (child <= n) {
            if ((rightChild <= n) && (arr[child] < arr[rightChild])) {  // 기존 힙구조에서 대상으로하는 배열의 개수가 하나씩 줄어드는것만 다름
                child = rightChild
            }

            if (arr[i] < arr[child]) {
                tmp = arr[i]
                arr[i] = arr[child]
                arr[child] = tmp
                percolateDown(child, n)
            }

        }

    }
}