package com.java.stack;

import com.java.list.LinkedList;
import com.java.list.ListInterface;

/*
- ADT 리스트 사용해서 스택을 구현
- 연결 리스트의 상위 인터페이스인 ListInterface<E> 관점 (ADT 리스트 관점)으로 다룸
- 스택으로 사용할 리스트를 래퍼런스하는 변수를 이용하여, 클라이언트 프로그램이 직접 접근하지 못하고,
객체 내부의 매서들을 통해서만 접근할 수 있다
 */

public class ListStack<E> implements StackInterface<E> {
	private ListInterface<E> list;
	
	public ListStack() {
		list = new LinkedList<E>();
	}
	
	public void push(E newItem) {
		list.add(0, newItem);
	}

	@Override
	public E pop() {
		if (!isEmpty()) {
			return list.remove(0);
		}
		return null;
	}

	@Override
	public E top() {
		return list.get(0);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void popAll() {
		list.clear();
	}


}
