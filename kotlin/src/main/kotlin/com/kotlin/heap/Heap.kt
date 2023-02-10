package com.kotlin.heap


class Heap(sizeOfArray: Int = 6) : PQInterface {
    private var arr: IntArray
    private var numItems: Int
    private var sizeOfArray = 6

    // 초기 생성자
    init {
        arr = IntArray(sizeOfArray)
        numItems = 0
        this.sizeOfArray = sizeOfArray
    }

    // 보조 생성자 : 바깥에서 배열을 받은 경우
    constructor(arr: IntArray, numItems:Int): this() {
        this.arr = arr
        this.numItems = numItems
        this.sizeOfArray = numItems
    }

    // 삽입
    override fun insert(newItem: Int) {
        if (numItems < sizeOfArray) {
            arr[numItems] = newItem
            percolateUp(numItems)
            numItems++
        } else throw PQException("HeapErr: Insert()-Overflow!")

    }

    // 후 스며오르기
    private fun percolateUp(i: Int) {
        var tmp = 0
        val parent = (i - 1) / 2

        if ((parent >= 0) && (arr[i] > arr[parent])) {
            tmp = arr[i]
            arr[i] = arr[parent]
            arr[parent] = tmp
            percolateUp(parent)
        }
    }


    override fun deleteMax(): Int {
        if (!isEmpty()) {
            val maxElement = arr[0]
            arr[0] = arr[numItems-1]
            numItems--
            percolateDown(0)
            return maxElement
        } else throw PQException("HeapErr: DeleteMax()-Underflow")
    }


    fun percolateDown(i: Int) {
        var tmp = 0
        var child = (2 * i )+ 1
        val rightChild = (2 * i) + 2

        if (child <= numItems - 1) {
            if (rightChild <= numItems -1 && arr[child] < arr[rightChild]) {
                child = rightChild
            }
            if (arr[i] < arr[child]) {
                tmp = arr[i]
                arr[i] = arr[child]
                arr[child] = tmp
                percolateDown(child)
            }
        }
    }


    override fun max(): Int {
        if (!isEmpty()) return arr[0]
        else throw PQException("HeapErr: Max()-empty")
    }


    // 무조건 루트부터 시작, i=0으로 시작하게끔
    override fun buildHeap() {
        if (numItems >= 2) { // 노드가 2개 이상부터 되야
            for (i in 0 until (numItems - 2) / 2 step 1) { // 이거 잘보기
                percolateDown(i)
            }
        }
    }


    override fun isEmpty(): Boolean {
        return (numItems == 0)
    }


    override fun clear() {
        arr = IntArray(numItems)
        numItems = 0
    }


}