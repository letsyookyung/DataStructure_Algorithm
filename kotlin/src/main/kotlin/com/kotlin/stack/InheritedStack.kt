package com.kotlin.stack

import com.kotlin.list.LinkedList

/*
- 연결 리스트 클래스를 상속해서 스택을 구현
- 연결 리스트 관점으로 다룸
- 상속을 받으면, 매소드 호출이 있으면 매소드 이름을 해당 클래스에서 "먼저" 찾아보고 없으면 상위 클래스에서 찾는다.
이들을 상위 클래스에서 찾는다는 것을 명시적으로 표시하려면 각각 super.add(), super.remove() ~ 이런 습관을 갖는게 가독성을
높인다고 생각할 수도 있음.
 */

class InheritedStack : LinkedList(), StackInterfaceString {

    override fun push(newItem: String) {
        super.add(0, newItem)
    }

    override fun pop(): String? {
        if (!isEmpty()) {
            return super.remove(0)
        }
        return null
    }

    override fun top(): String? {
        if (!isEmpty()) {
            return super.get(0)
        }
        return null
    }

    // 이렇게 override해도 되지만, 굳이 parent class랑 같은 메소드명 내용이라서, 명시를 안해놔도 parent class의 isEmpty를 불러와서 일함
//    override fun isEmpty(): Boolean {
//        println("child isEmpty")
//        return super.isEmpty()
//    }


    override fun popAll() {
        super.clear()
    }


}