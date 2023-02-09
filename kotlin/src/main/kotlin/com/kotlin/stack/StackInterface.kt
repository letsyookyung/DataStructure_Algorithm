package com.kotlin.stack

interface StackInterface {

    fun push(newItem: Int)

    fun pop() : Int?

    fun top(): Int?

    fun isEmpty() : Boolean

    fun popAll()

}