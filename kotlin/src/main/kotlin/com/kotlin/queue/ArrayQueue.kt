package com.kotlin.queue


class ArrayQueue (
    sizeOfArray: Int = 6
) : QueueInterface {
    private var queue: Array<String?>
    private var front: Int
    private var tail: Int
    private var numItems: Int
    private val error = -12345
    private var sizeOfArray = 6

    // 생성자
    init {
        this.sizeOfArray = sizeOfArray
        queue = arrayOfNulls(sizeOfArray)
        front = 0
        tail = sizeOfArray - 1
        numItems = 0
    }

    override fun enqueue(x: String) { // tail만 움직임
        if (isFull()) {
            println("queue full~")
        } else {
            tail = (tail + 1) % queue.size
            queue[tail] = x
            ++numItems

        }
    }

    private fun isFull(): Boolean {
        return numItems == queue.size
    }

    override fun dequeue(): String? {
        if (isEmpty()) {
            println("queue empty")
        }
        var queueFront = queue[front]
        front = (front+1) % queue.size
        --numItems
        return queueFront
    }

    override fun front(): String? {
        if (isEmpty()) {
            return null
        }
        return queue[front]
    }

    override fun isEmpty(): Boolean {
        return numItems == 0
    }

    override fun dequeueAll() {
        queue = arrayOfNulls(sizeOfArray)
        front = 0
        tail = sizeOfArray - 1
        numItems = 0
    }


}



