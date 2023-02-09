package com.kotlin.stack

import com.kotlin.list.LinkedList

class ListStack : StackInterfaceString {
    private val list = LinkedList()

    override fun push(newItem: String) {
        list.add(0, newItem)
    }

    override fun pop(): String? {
        if (!isEmpty()) {
            return list.remove(0)
        }
        return null
    }

    override fun top(): String? {
        if (!isEmpty()) {
            return list.get(0)
        }
        return null
    }

    override fun isEmpty(): Boolean {
        println("child isEmpty")
        return list.isEmpty()
    }

    override fun popAll() {
        list.clear()
    }


}