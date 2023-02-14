package com.kotlin.index

interface AVLIndexInterface {

    fun insert(x: Int)

    fun search(x: Int): AVLNode?

    fun delete(x: Int)

    fun isEmpty(): Boolean

    fun clear()

}