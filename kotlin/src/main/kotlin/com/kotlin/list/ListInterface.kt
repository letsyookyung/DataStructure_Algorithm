package com.kotlin.list

interface ListInterface<T>  {

    fun <T> add(i: Int, x: T)

    fun <T> append(x: T)

    fun <T> remove(i: Int) : T

    fun <T> removeItem(x: T) : Boolean

    fun <T> get(i: Int) : T

    fun <T> set(i: Int, x: T)

    fun <T> indexOf(x: T) : Int

    fun len() : Int

    fun isEmpty() : Boolean

    fun clear()

}