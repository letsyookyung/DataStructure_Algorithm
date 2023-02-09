package com.kotlin.queue

import com.kotlin.list.LinkedList

class InheritedQueue : LinkedList(), QueueInterface {

    override fun enqueue(x: String) {
        super.append(x)
    }

    override fun dequeue(): String? {
        return super.remove(0)
    }

    override fun front(): String? {
        return super.get(0)
    }

    override fun isEmpty(): Boolean {
        println("child isEmpty")
        return super.isEmpty()
    }

    override fun dequeueAll() {
        super.clear()
    }
}