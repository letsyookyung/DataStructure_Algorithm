package com.kotlin.list

interface ListInterface {

    fun add(index: Int, x: String)

    fun append(x: String)

    fun remove(index: Int) : String?

    fun removeItem(x: String) : Boolean

    fun get(index: Int) : String?

    fun set(index: Int, x: String)

    fun indexOf(x: String) : Int

    fun len() : Int

    fun isEmpty() : Boolean

    fun clear()

}