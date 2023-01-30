package com.kotlin.list


class ArrayList<T> (
    sizeOfArray: Int = 64
) : ListInterface<T> {

    private var item: Array<T?>
    private var numItems: Int

    init {
        item = arrayOfNulls<T?>(sizeOfArray)
        numItems = 0
    }


    // 배열 리스트의 k번째 자리에 원소 x 삽입하기
    override fun <T> add(index: Int, x: T) {
        if (numItems >= item.size || index < 0 || index > numItems) {
            println("wrong input or array full")
        } else {
            val i = numItems - 1
            for (i in index..i) {
                item[i + 1] = item[i]
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
            item[numItems++] = x
        }

    }


    // 배열 리스트의 k번째 원소 삭제하기
    override fun <T> remove(index: Int): T? {
        if (isEmpty() || index < 0 || index > numItems - 1) {
            return null
        } else {
            val tmp = item[index]
            for (i in index..numItems - 2) {
                item[i] = item[i + 1]
            }
            numItems--
            return tmp
        }
    }


    // 배열 리스트에서 원소 x 삭제하기
    override fun <T> removeItem(x: T) : Boolean {
        var removeIndex = 0
        while (removeIndex < numItems - 1 && !item[removeIndex].equals(x)) {
            removeIndex++
        }
        if (removeIndex == numItems) return false

        for (i in removeIndex .. numItems - 2) {
            item[i] = item[i+1]
        }
        numItems--
        return true

    }


    // 리스트 i번째 원소 알려주기
    override fun <T> get(index: Int) : T? {
        if (index >= 0 && index <= numItems - 1) {
            return item[index]
        }
        return null
    }


    // 배열 리스트의 i번째 원소를 x로 대체하기
    override fun <T> set(index: Int, x: T) {
        if (index >=0 && index <= numItems - 1)
            item[index] = x
    }


    // 원소x가 배열 리스트의 몇 번째 원소인지 알려주기
    private val NOT_FOUND = -12345
    override fun <T> indexOf(x: T) : Int {
        var searchingIndex = 0
        while (searchingIndex < numItems -1 && !item[searchingIndex].equals(x)) {
            searchingIndex++
        }
        if (searchingIndex == numItems) return NOT_FOUND

        return searchingIndex
    }


    // 리스트의 총 원소 수 알려주기
    override fun len() : Int {
        return item.length()
    }


    // 리스트가 비었는지 알려주기
    override fun isEmpty() : Boolean {
        return item.length == 0
    }


    // 리스트 깨끗이 청소하기
    override fun clear() {
        item =
        numItems = 0
    }

}