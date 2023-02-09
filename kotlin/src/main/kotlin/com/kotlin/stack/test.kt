package com.kotlin.stack

fun main(args: Array<String>) {

//    val ars = ArrayStack()
//     val lks = LinkedStack()
    val ihs = InheritedStack()
    val ls = ListStack()

//    ars.push(3)
//    ars.push(4)
//    ars.push(2)
//    println(ars.pop())
//    ars.top()
//    ars.isEmpty()
//    ars.popAll()

//    lks.push(3)
//    lks.push(4)
//    lks.push(2)
//    println(lks.pop())
//    println(lks.top())
//    println(lks.isEmpty())
//    lks.popAll()
//    println(lks.isEmpty())

//
    ihs.push("3")
    ihs.push("4")
    ihs.push("2")
    println(ihs.pop())
    println(ihs.top())
    println(ihs.isEmpty())
    ihs.popAll()
    println(ihs.isEmpty())

//    ls.push("3")
//    ls.push("4")
//    ls.push("2")
//    println(ls.pop())
//    println(ls.top())
//    println(ls.isEmpty())
//    ls.popAll()
//    println(ls.isEmpty())

}