package com.kotlin.stack


class LinkedStack : StackInterface {
    private var topNode: Node? = null
    private val error = -12345

    override fun push(newItem: Int) {
        topNode = Node(newItem, topNode) // 현재의 topNode가 새로운 topNode의 next로 연결되도록

    }

    override fun pop(): Int? {
        if (isEmpty()) {
            return error
        } else {
            val poppedNode = topNode
            topNode = topNode?.next
            if (poppedNode != null) {
                return poppedNode.item
            }
        }
        return error
    }

    override fun top(): Int? {
        if (isEmpty()) {
            return error
        }
        return topNode?.item
    }

    override fun isEmpty(): Boolean {
        return topNode == null
    }

    override fun popAll() {
        topNode = null
    }

}