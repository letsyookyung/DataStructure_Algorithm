package com.kotlin.stack

class ArrayStack (
    sizeOfArray: Int = 6
) : StackInterface {
    private var stack: Array<Int?>
    private var topIndex: Int
    private val error = -12345
    private var sizeOfArray = 6

    // 생성자
    init {
        stack = arrayOfNulls(sizeOfArray)
        topIndex = -1
        this.sizeOfArray = sizeOfArray
    }


    // push : 배열 마지막에 아이템 추가
    override fun push(newItem: Int) {
        if (isFull()) {
            println("array is full")
        } else {
            stack[++topIndex] = newItem
        }

    }

    // pop : 배열 마지막 아이템 return 후 삭제
    override fun pop(): Int? {
        if (isEmpty()) {
            println("array is empty")
        } else {
            return stack[topIndex--]
        }
        return error
    }

    // top : 배열 마지막 아이템 return만
    override fun top(): Int? {
        if (isEmpty()) {
            println("array is empty")
        } else {
            return stack[topIndex]
        }
        return error
    }

    // isEmpty
    override fun isEmpty(): Boolean {
        return topIndex < 0
    }

    // isFull
    private fun isFull(): Boolean {
        return topIndex >= stack.size-1
    }

    // popAll
    override fun popAll() {
        topIndex = -1
        stack = arrayOfNulls(stack.size)
    }




}