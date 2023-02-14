package com.kotlin.index

class AVLNode(
    var item: Int?,
    var left: AVLNode? = AVLTree.NIL,
    var right: AVLNode? = AVLTree.NIL,
    var height: Int = 1,
)


