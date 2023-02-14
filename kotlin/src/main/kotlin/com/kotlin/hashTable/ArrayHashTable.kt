package com.kotlin.hashTable

class ArrayHashTable(
    arraySize: Int = 6
): IndexInterface {
    private var table: IntArray = IntArray(arraySize)
    private var numItems = 0
    private val NIL = 333
    private val DELETED = -12345
    private val NOT_FOUND = -1


    private fun hash(i: Int, x: Int): Int {
//        return ((x + i) % table.size)
        return i
    }


    override fun insert(x: Int) {
        if (numItems == table.size) {
            println("table is full")
        } else {
            for (i in table.indices step 1) {
                val slot = hash(i, x)
                if (table[slot] == NIL || table[slot] == DELETED) {
                    table[slot] = x
                    numItems++
                    break
                }
            }
        }
    }


    override fun search(x: Int): Int {
        for (i in table.indices step 1) {
            val slot = hash(i, x)
            if (table[slot] == NIL) {
                return NOT_FOUND
            }
            if (table[slot] == x) {
                return slot
            }
        }
        return NOT_FOUND
    }


    override fun delete(x: Int): Int {
        for (i in table.indices) {
            val slot = hash(i, x)
            if (table[slot] == NIL) {
                return NOT_FOUND
            }
            if (table[slot] == x) {
                table[slot] = DELETED
                numItems--
                break
            }
        }
        return NOT_FOUND
    }


    fun getItem(i: Int): Int {
        return table[i]
    }


    override fun isEmpty() {
        numItems = 0
    }


    override fun clear() {
        table = IntArray(table.size)
        numItems = 0
    }

}