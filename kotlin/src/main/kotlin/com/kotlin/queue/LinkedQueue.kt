package com.kotlin.queue

import com.kotlin.list.Node

class LinkedQueue : QueueInterface {
    private var tail: Node? = null
    private lateinit var newNode: Node

    override fun enqueue(x: String) {
        newNode = Node(x, null)
        if (isEmpty()) {
            newNode.next = newNode
            tail = newNode
        } else {
            newNode.next = tail?.next
            tail?.next = newNode
            tail = newNode
        }
    }

    override fun dequeue(): String? {
        return if (isEmpty()) {
            null
        } else {
            val front = tail?.next
            if (front == tail) { // 하나일 때 뺏을 때
                tail = null
            } else {
                tail?.next = tail?.next?.next
            }
            front!!.item
        }
    }

    override fun front(): String? {
        return if (isEmpty()) {
            null
        } else {
            tail!!.next!!.item
        }
    }

    override fun isEmpty(): Boolean {
        return tail == null
    }

    override fun dequeueAll() {
        tail = null
    }






}