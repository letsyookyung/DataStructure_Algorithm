package com.java.list;

public interface ListInterface<E> {
    void add(int i, E x);
    void append(E x);
    E remove(int i);
    boolean removeItem(E x);
    E get(int i);
    void set(int i, E x);
    int indexOf(E x);
    int len();
    boolean isEmpty();
    void clear();
}