package com.kotlin.hashTable

import com.kotlin.list.Node

interface ChainedIndexInterface {

    fun insert(x: String)

    fun search(x: String): Node?

    fun delete(x: String)

    fun isEmpty(): Boolean

    fun clear()

}