package com.kotlin.queue

interface QueueInterface {

    fun enqueue(x: String)

    fun dequeue(): String?

    fun front(): String?

    fun isEmpty(): Boolean

    fun dequeueAll()
}