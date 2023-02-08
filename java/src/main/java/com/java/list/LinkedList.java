package com.java.list;

public class LinkedList<E> implements ListInterface<E> {
    private Node<E> head;
    private int numItems;

    public LinkedList() { //생성자
        numItems = 0;
        head = new Node<E>(null, null); //더미헤드
    }

    // main
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.append("hello");
        list.append("java");
        list.append("world");

        for (int i = 0; i < list.len(); i++) {
            System.out.printf("%d번째: %s", i, list.get(i));
            System.out.println(" ");
        }

        list.add(1, "python");
        list.append("!");


        for (int i = 0; i < list.len(); i++) {
            System.out.printf("%d번째: %s", i, list.get(i));
            System.out.println(" ");
        }

        list.remove(0);
        list.add(0, "bye");

        for (int i = 0; i < list.len(); i++) {
            System.out.printf("%d번째: %s", i, list.get(i));
            System.out.println(" ");
        }

    }



    @Override
    // 연결 리스트에 원소 x 삽입하기
    public void add(int index, E item) {
        if (index >= 0 && index <= numItems) {
            Node<E> prevNode = getNode(index-1);
            Node<E> newNode = new Node<>(item, prevNode.next);
            prevNode.next = newNode;
            numItems++;
        }
    }

    @Override
    // 연결 리스트의 맨 뒤에 원소 추가하기
    public void append(E item) {
        Node<E> prevNode = head; //더미노드
        while (prevNode.next != null) {
            prevNode = prevNode.next; //next가 null일 때까지 찾으면 마지막 원소가 되니깐
        } // prevNode 준비끝
        Node<E> newNode = new Node<>(item, null);
        prevNode.next = newNode;
        numItems++;
    }

    @Override
    // 리스트 원소 삭제하기
    public E remove(int index) {
        if (index >=0 && index < numItems) {
            Node<E> prevNode = getNode(index - 1);
            Node<E> currNode = prevNode.next;
            prevNode.next = currNode.next;
            numItems--;
            return currNode.item;
        } else {
            return null;
        }
    }

    @Override
    public boolean removeItem(E x) {
        Node<E> prevNode, currNode = head;
        for (int i = 0; i <= numItems-1; i++) {
            prevNode = currNode;
            currNode = currNode.next;
//            if (currNode.item.compareTo(x) == 0) ;
            if (currNode.item == x) {
                prevNode.next = currNode.next;
                numItems--;
                return true;
            }
        }
        return false;
    }

    @Override
    // k번째 노드의 값 구하기
    public E get(int index) {
        if (index >= 0 && index <= numItems - 1) {
            return getNode(index).item;
        } else {
            return null;
        }
    }

    // k번째 노드 구하기
    public Node<E> getNode(int index) {
        if (index >= -1 && index <= numItems - 1) { // prevNode를 구할 ㄸㅐ -1을 해서 들어오니깐.
            Node<E> currNode = head;
            for (int i = 0; i <= index; i++) {
                currNode = currNode.next;
            }
            return currNode;
        } else {
            return null;
        }
    }

    @Override
    // 연결 리스트의 k번째 원소를 x로 대체하기
    public void set(int index, E x) {
        if (index >=0 && index <= numItems -1) {
            getNode(index).item = x;
        } else {
            /*예외처리*/
        }
    }

    public static final int NOT_FOUND = -1234;
    @Override
    public int indexOf(E x) {
        Node<E> currNode = head;
        int i;
        for (i = 0 ; i < numItems ; i++) {
            currNode = currNode.next;
            if (((Comparable)(currNode.item)).compareTo(x) == 0) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    @Override
    public int len() {
        return numItems;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public void clear() {
        numItems = 0;
        head = new Node<>(null, null);

    }

}