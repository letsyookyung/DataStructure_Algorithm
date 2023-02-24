package com.java.memo;

interface Iterable<T> {
	Iterator<T> iterator();

}

class MyCollection implements Iterable<Integer> {
	Integer x1, x2, x3;
	int i;


	@Override
	public Iterator<Integer> iterator() {
		return new MyIterator<Integer>();
	}
}

///////////////////////////////////////////////////////////


interface Iterator<E> {
	boolean hasNext();
	E next();
	void remove();

}

class MyIterator implements Iterator<Integer> {
	MyCollection c;
	public MyIterator(MyCollection c){
		this.c = c;
		c.i = 1;
		c.x1 = 123; c.x2 = 456; c.x3 = 789;
	}

	@Override
	public boolean hasNext() {
		return c.i == 1 || c.i == 2 || c.i == 3;
	}

	@Override
	public Integer next() {
		if (c.i == 1) {c.i++; return c.x1;}
		else if (c.i == 2) {c.i++; return c.x2;}
		else if (c.i == 3) {c.i++; return c.x3;}
		else return null;
	}

	@Override
	public void remove() {

	}
}