package com.kotlin.index


fun main(args: Array<String>) {
//    val bs = BinarySearchTree()
//
//    bs.insert(10)
//    bs.insert(5)
//    bs.insert(2)
//    bs.insert(6)
//    bs.insert(15)
//    bs.insert(7)
//    bs.insert(13)
//    bs.insert(20)
//    bs.insert(17)
//    bs.insert(16)
//    bs.insert(18)
//
////    println(bs.search(16))
////    println(bs.search(5))
//
//    bs.delete(15)


    val avltree = AVLTree()

    avltree.insert(12)
    avltree.insert(10)
    avltree.insert(13)
    avltree.insert(8)
    avltree.insert(4)
    avltree.insert(9)
    avltree.insert(5)
    avltree.insert(6)
    avltree.insert(7)

    avltree.delete(10)

    avltree.delete(8)

}