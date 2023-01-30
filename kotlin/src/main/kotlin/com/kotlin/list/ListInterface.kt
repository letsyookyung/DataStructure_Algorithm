package com.kotlin.list

interface ListInterface<T>  {

    fun <T> add(index: Int, x: T)

    fun <T> append(x: T)

    fun <T> remove(index: Int) : T?

    fun <T> removeItem(x: T) : Boolean

    fun <T> get(index: Int) : T?

    fun <T> set(index: Int, x: T)

    fun <T> indexOf(x: T) : Int

    fun len() : Int

    fun isEmpty() : Boolean

    fun clear()

}