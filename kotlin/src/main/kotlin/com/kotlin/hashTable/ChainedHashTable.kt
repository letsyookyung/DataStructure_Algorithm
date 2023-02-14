package com.kotlin.hashTable


import com.kotlin.list.LinkedList
import com.kotlin.list.Node

class ChainedHashTable (
    sizeOfArray: Int = 6
) : ChainedIndexInterface {
    private var table = Array(sizeOfArray) { LinkedList() }
    private var numItems =  0


    private fun hash(x: String): Int {
        return (x.toInt() % table.size)
    }


    override fun insert(x: String) {
        val slot = hash(x)
        table[slot].add(0, x)
        numItems++
    }


    override fun search(x: String): Node? {
        val slot = hash(x)
        return if (table[slot].isEmpty()) {
            null
        } else {
            val idx = table[slot].indexOf(x)
            if (idx == LinkedList.NOT_FOUND) {
                null
            } else {
                table[slot].getNode(idx)
            }
        }
    }


    override fun delete(x: String) {
        if (isEmpty()) {
            /* 에러처리 */
        } else {
            val slot = hash(x)
            table[slot].removeItem(x)
            numItems--
        }
    }


    override fun isEmpty(): Boolean {
        return numItems == 0
    }


    override fun clear() {
        numItems = 0
        table = Array(table.size) { LinkedList() }
    }

}