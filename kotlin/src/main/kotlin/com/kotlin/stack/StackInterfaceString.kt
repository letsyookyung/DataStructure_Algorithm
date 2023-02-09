package com.kotlin.stack

interface StackInterfaceString {

    fun push(newItem: String)

    fun pop() : String?

    fun top(): String?

    fun isEmpty() : Boolean

    fun popAll()

}