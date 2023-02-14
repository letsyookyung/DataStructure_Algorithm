package com.kotlin.index

interface IndexInterface {

    fun insert(x: Int)

    fun search(x: Int): TreeNode?

    fun delete(x: Int)

    fun isEmpty(): Boolean

    fun clear()

}