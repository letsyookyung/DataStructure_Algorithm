package com.kotlin.list


class ArrayList( //생성자
    n: Int = 64
) : ListInterface<T> {

    var numItems = 0
    var item = arrayOfNulls<T>(n)


    fun main() {
        var list = ArrayList()
        println(list)

    }

    // 배열 리스트의 k번째 자리에 원소 x 삽입하기
    override fun <T> add(index: Int, x: T) {
        if (numItems >= item.size || index < 0 || index > numItems) {
            println("wrong input or array full")
        } else {
            var i = numItems -1;
            for (i in index..i) {
                item[i+1] = item[i]
            }
            item[index] = x
            numItems++
        }

    }


    // 배열 리스트의 맨 뒤에 원소 추가하기
    override fun <T> append(x: T) {
        if (numItems >= item.size) {
            /*에러처리*/
        } else {
            item[numItems++] = x;
        }

    }

    override fun <T> remove(i: Int) : T {

    }

    override fun <T> removeItem(x: T) : Boolean {

    }

    override fun <T> get(i: Int) : T {

    }

    override fun <T> set(i: Int, x: T) {

    }

    override fun <T> indexOf(x: T) : Int {

    }

    override fun len() : Int {
        return item.size()
    }

    override fun isEmpty() : Boolean {
        return item.size == 0
    }

    override fun clear() {

    }






}