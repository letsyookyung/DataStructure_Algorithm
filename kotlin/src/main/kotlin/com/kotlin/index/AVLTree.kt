package com.kotlin.index

import kotlin.math.max

class AVLTree(private var root: AVLNode = NIL): AVLIndexInterface {

    companion object {
        val NIL: AVLNode = AVLNode(null, null, null, height = 0)
    }

    override fun search(x: Int): AVLNode {
        return searchItem(root, x)
    }


    private fun searchItem(tNode: AVLNode, searchItem: Int): AVLNode {
        return if (tNode == NIL) {
            NIL
        } else if (searchItem == tNode.item) {
            tNode
        } else if (searchItem < tNode.item!!) {
            searchItem(tNode.left!!, searchItem)
        } else {
            searchItem(tNode.right!!, searchItem)
        }
    }


    override fun insert(x: Int) {
        root = insertItem(root, x)
    }


    private fun insertItem(tNode: AVLNode, newItem: Int): AVLNode {
        if (tNode == NIL) {
            return AVLNode(newItem)
        } else if (newItem < tNode.item!!) {
            tNode.left = insertItem(tNode.left!!, newItem)
            tNode.height = 1 + max(tNode.right!!.height, tNode.left!!.height)
            val type = needBalance(tNode)
            if (type != NO_NEED) {
                return balanceAVL(tNode, type)
            }
        } else {
            tNode.right = insertItem(tNode.right!!, newItem)
            tNode.height = 1 + max(tNode.right!!.height, tNode.left!!.height)
            val type = needBalance(tNode)
            if (type != NO_NEED) {
                return balanceAVL(tNode, type)
            }
        }
        return tNode
    }


    private val LL = 1
    private val LR = 2
    private val RR = 3
    private val RL = 4
    private val NO_NEED = 0
    private fun needBalance(t: AVLNode): Int {
        return if (t.left!!.height + 2 <= t.right!!.height) {
            if ((t.right!!.left!!.height) <= (t.right!!.right!!.height)) RR
            else RL
        } else if ((t.left!!.height) >= (t.right!!.height + 2)) {
            if ((t.left!!.left!!.height) >= (t.left!!.right!!.height)) LL
            else LR
        } else NO_NEED

    }


    private fun balanceAVL(tNode: AVLNode, type: Int): AVLNode {
        var returnNode: AVLNode = NIL
        when (type) {
            LL -> returnNode = rightRotate(tNode)
            LR -> {
                tNode.left = leftRotate(tNode.left!!)
                returnNode = rightRotate(tNode)
            }
            RR -> returnNode = leftRotate(tNode)
            RL -> {
                tNode.right = rightRotate(tNode.right!!)
                returnNode = leftRotate(tNode)
            }
        }
        return returnNode
    }


    private fun leftRotate(t: AVLNode): AVLNode {
        val RChild = t.right
        if (RChild == NIL) {
            println("${t.item}'s RChild shouldn't be NIL!")
        }
        val RLChild = RChild!!.left
        RChild!!.left = t
        t.right = RLChild
        t.height = 1 + max(t.left!!.height, t.right!!.height)
        RChild.height = 1 + max(RChild.left!!.height, RChild.right!!.height)
        return RChild
    }


    private fun rightRotate(t: AVLNode): AVLNode {
        val LChild = t.left
        if (LChild == NIL) {
            println("${t.item}'s RChild shouldn't be NIL!")
        }
        val LRChild = LChild!!.right
        LChild!!.right = t
        t.left = LRChild
        t.height = 1 + max(t.left!!.height, t.right!!.height)
        LChild.height = 1 + max(LChild.left!!.height, LChild.right!!.height)
        return LChild
    }


    override fun delete(x: Int) {
        root = deleteItem(root, x)
        println("끝")
    }


    private fun deleteItem(tNode: AVLNode, deleteItem: Int): AVLNode {
        if (tNode == NIL) {
            return NIL
        } else if (deleteItem == tNode.item) {
            return deleteNode(tNode)
        } else if (deleteItem < 0) {
            tNode.left = deleteItem(tNode.left!!, deleteItem)
            tNode.height = 1 + max(tNode.right!!.height, tNode.left!!.height)
            val type = needBalance(tNode)
            if (type != NO_NEED) {
                return balanceAVL(tNode, type)
            }
        } else {
            tNode.height = 1 + max(tNode.right!!.height, tNode.left!!.height)
            val type = needBalance(tNode)
            if (type != NO_NEED) {
                return balanceAVL(tNode, type)
            }
        }
        return tNode
    }

    private fun deleteNode(tNode: AVLNode): AVLNode {
        /*
        3가지 case
        1. tNode이 리프 노드 (자식 0개)
        2. tNode의 자식 1개
        3. tNode의 자식 2개
         */
        if ((tNode.right == NIL) && (tNode.left == NIL)) {
            return NIL
        } else if (tNode.left == NIL) {
            return tNode.right!!
        } else if (tNode.right == NIL) {
            return tNode.left!!
        } else {
            val rPair: ReturnPair = deleteMinItem(tNode.right!!)
            tNode.item = rPair.item
            tNode.right = rPair.node
            tNode.height = 1 + max(tNode.right!!.height, tNode.left!!.height)
            val type = needBalance(tNode)
            if (type != NO_NEED) {
                return balanceAVL(tNode, type)
            }
            return tNode
        }
    }


    private fun deleteMinItem(tNode: AVLNode): ReturnPair {
        if (tNode.left == NIL) {
            return ReturnPair(tNode.item!!, tNode.right!!)
        } else {
            val rPair: ReturnPair = deleteMinItem(tNode.right!!)
            tNode.item = rPair.item
            tNode.right = rPair.node
            tNode.height = 1 + max(tNode.right!!.height, tNode.left!!.height)
            val type = needBalance(tNode)
            if (type != NO_NEED) {
                rPair.node= balanceAVL(tNode, type)
            }
            return rPair
        }
    }


    private class ReturnPair(val item: Int, var node: AVLNode)


    override fun isEmpty(): Boolean {
        return root == NIL
    }


    override fun clear() {
        root = NIL
    }



}