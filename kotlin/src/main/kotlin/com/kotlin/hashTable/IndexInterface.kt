package com.kotlin.hashTable

interface IndexInterface {

    fun insert(x: Int)

    fun search(x: Int): Int

    fun delete(x: Int): Int

    fun isEmpty()

    fun clear()

}