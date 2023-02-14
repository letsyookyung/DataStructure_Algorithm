package com.kotlin.index


class BinarySearchTree : IndexInterface {
    private var root: TreeNode?

    init {
        root = null
    }

    override fun search(x: Int): TreeNode? {
        return searchItem(root, x)
    }


    private fun searchItem(tNode: TreeNode?, searchKey: Int): TreeNode? {
        if (tNode == null) {
            return null
        } else if (searchKey == tNode.key) {
            return tNode
        } else if (searchKey < tNode.key) {
            tNode.left = searchItem(tNode.left, searchKey)
        } else {
            tNode.right = searchItem(tNode.right, searchKey)
        }
        return tNode// return안하면 tnode인 root는 계속 null인 상태
    }


    override fun insert(x: Int) {
        root = insertItem(root, x) // 여기 부분 확인
        println("insert 끝")
    }


   private fun insertItem(tNode: TreeNode?, newKey: Int): TreeNode {
        if (tNode == null) {
            return TreeNode(newKey, null, null)
        } else if (newKey < tNode.key) {
            tNode.left = insertItem(tNode.left, newKey)
            println("dd")
        } else {
            tNode.right = insertItem(tNode.right, newKey)
            println("kk")
        }
       return tNode
    }


    override fun delete(x: Int) {
        root = deleteItem(root, x)
    }


    private fun deleteItem(tNode: TreeNode?, deleteKey: Int): TreeNode? {
        if (tNode == null) {
            println("it is empty!")
            return null
        } else if (deleteKey == tNode.key) {
            return deleteNode(tNode)
        } else if (deleteKey < tNode.key) {
            tNode.left = deleteItem(tNode.left, deleteKey)
        } else {
            tNode.right = deleteItem(tNode.right, deleteKey)
        }
        return tNode
    }


    private fun deleteNode(tNode: TreeNode): TreeNode? {
        /*
        3가지 case
        1. tNode이 리프 노드 (자식 0개)
        2. tNode의 자식 1개
        3. tNode의 자식 2개
         */
        return if ((tNode.right == null) && tNode.left == null) {
            null
        } else if (tNode.left == null) {
            tNode.right
        } else if (tNode.right == null) {
            tNode.left
        } else {
            val rPair: ReturnPair = deleteMinItem(tNode.right!!)
            tNode.key = rPair.key
            tNode.right = rPair.node
            tNode
        }

    }


    private fun deleteMinItem(tNode: TreeNode): ReturnPair {
        return if (tNode.left == null) {
            ReturnPair(tNode.key, tNode.right)
        } else {
            val rPair: ReturnPair = deleteMinItem(tNode.left!!)
            tNode.left = rPair.node
            rPair.node = tNode
            rPair
        }
    }


    private class ReturnPair(val key: Int, var node: TreeNode?)


    override fun isEmpty(): Boolean {
        return root == null
    }


    override fun clear() {
        root = null
    }

}