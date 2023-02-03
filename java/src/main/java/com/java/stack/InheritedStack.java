package com.java.stack;

import com.java.list.LinkedList;

/*
- 연결 리스트 클래스를 상속해서 스택을 구현
- 연결 리스트 관점으로 다룸
- 상속을 받으면, 매소드 호출이 있으면 매소드 이름을 해당 클래스에서 "먼저" 찾아보고 없으면 상위 클래스에서 찾는다.
이들을 상위 클래스에서 찾는다는 것을 명시적으로 표시하려면 각각 super.add(), super.remove() ~ 이런 습관을 갖는게 가독성을
높인다고 생각할 수도 있음.
 */

public class InheritedStack<E> extends LinkedList<E> implements StackInterface<E> {

	public InheritedStack() {
		super(); //상위 클래스의 생성자를 수행한다
	}


	@Override
	public void push(E newItem) {
		add(0, newItem);
	}

	@Override
	public E pop() {
		if (!isEmpty()) {
			return remove(0);
		}
		return null;
	}

	@Override
	public E top() {
		return get(0);
	}

	@Override
	public void popAll() {
		clear();
	}
}
