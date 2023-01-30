package com.kotlin.list

class LinkedList : ListInterface {
    private var numItems: Int = 0
    private var head: Node
    private lateinit var prevNode: Node
    private lateinit var currNode: Node
    private lateinit var newNode: Node

    
    init {
        numItems = 0
        head = Node(null, null)
    }


    // 연결 리스트의 k번째 자리에 원소 x 삽입하기
    override fun add(index: Int, x: String) {
        if (index in 0..numItems) {
            prevNode = getNode(index-1)!!
            newNode = Node(x, prevNode.next)
            prevNode.next = newNode
            numItems++
        }
    }


    // 연결 리스트의 맨 뒤에 원소 추가하기
    override fun append(x: String) {
        prevNode = head
        while (prevNode.next != null) {
            prevNode = prevNode.next!!
        }

//            prevNode = getNode(numItems) // 이렇게 찾으면?
        newNode = Node(x, null)
        prevNode.next = newNode
        numItems++
    }


    // 연결 리스트의 k번째 원소 삭제하기
    override fun remove(index: Int): String? {
        if (index in 0 .. numItems) {
            prevNode = getNode(index-1)!!
            val removedNode = prevNode.next!!
            prevNode.next = prevNode.next!!.next
            numItems--
            return removedNode.item
            }
        return null

    }


    // 연결 리스트에서 원소 x 삭제하기
    override fun removeItem(x: String) : Boolean {
        prevNode = head
        whileloop@ while (prevNode.next != null) {
            currNode = prevNode.next!!
            if (currNode.item.equals(x)) break@whileloop
            prevNode = currNode
        }
        prevNode.next = prevNode.next!!.next
        numItems--
        return true
        
    }


    // k번째 노드의 값 구하기
    override fun get(index: Int) : String? {
        if (index in 0 until numItems) {
            return getNode(index)?.item
        }
        return null
    }
    
    private fun getNode(index: Int) : Node? {
        if (index in -1 until numItems) {
            currNode = head
            for (i in 0 .. index step 1) {
                currNode = currNode.next!!
            }
            return currNode
        }
        return null
    }
 

    // 배열 리스트의 i번째 원소를 x로 대체하기
    override fun set(index: Int, x: String) {
        getNode(index)?.item = x
    }


    // 원소x가 배열 리스트의 몇 번째 원소인지 알려주기
    private val NOT_FOUND = -12345
    override fun indexOf(x: String) : Int {
        currNode = head
        for (i in 0 until numItems step 1) {
            currNode = currNode.next!!
            if (currNode.item.equals(x)) return i
        }
        return NOT_FOUND
    }


    // 리스트의 총 원소 수 알려주기
    override fun len() : Int {
        return numItems
    }


    // 리스트가 비었는지 알려주기
    override fun isEmpty() : Boolean {
        return numItems == 0
    }


    // 리스트 깨끗이 청소하기
    override fun clear() {
        head = Node(null, null)
        numItems = 0
    }


}