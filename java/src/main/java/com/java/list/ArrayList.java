package com.java.list;

public class ArrayList<E> implements ListInterface<E> {
    private E[] item;
    private int numItems;
    private static final int DEFAULT_CAPACITY = 64;

    public ArrayList() { //생성자1
        item = (E[]) new Object[DEFAULT_CAPACITY]; // Object타입의 배열을 생성한 다음 이를 E타입으로 타입 캐스팅 해주었다
        numItems = 0;
    }

    public ArrayList(int n) { //생성자2
        item = (E[]) new Object[n];
        numItems = 0;
    }


    // main
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(10);
        list.append(1);
        list.append(2);
        list.append(3);
        list.remove(2);
        list.append(4);

        list.add(0,100);
        list.add(0,200);

        list.set(3,4000);

        list.removeItem(100);

        list.indexOf(4000);

        list.add(4, 1234);
        list.add(5, 1234);

        for (int i = 0; i < list.len(); i++) {
            System.out.printf("%d번째: %s", i, list.get(i));
            System.out.println(" ");
        }
    }



    // 배열 리스트의 k번째 자리에 원소 x 삽입하기
    public void add(int index, E x) {
        if (numItems >= item.length || index < 0 || index > numItems) {
           System.out.println("Wrong input or array full");
        } else {
            for (int i = numItems - 1; i >= index; i--)
                item[i+1] = item[i]; //우시프트
            item[index] = x;
            numItems++;
        }
    }

    // 배열 리스트의 맨 뒤에 원소 추가하기
    public void append(E x) {
        if (numItems >= item.length) {
            /*에러처리*/
        } else {
            item[numItems++] = x;
        }
    }

    // 배열 리스트의 k번째 원소 삭제하기
    public E remove(int index) {
        if (isEmpty() || index < 0 || index > numItems - 1)
            return null;
        else {
            E tmp = item[index];
            for (int i = index; i <= numItems - 2; i++)
                item[i] = item[i + 1]; //좌시프트
            numItems--;
            return tmp;
            }
        }


    // 배열 리스트에서 원소 x 삭제하기
    public boolean removeItem(E x) {
        int k = 0;
        while (k < numItems && ((Comparable)item[k]).compareTo(x) != 0)
            k++;
        if (k == numItems) return false;
        else {
            for (int i = k; i <= numItems - 2; i++) {
                item[i] = item[i+1];
            }
            numItems--;
            return true;
        }
    }

    // 리스트의 i번째 원소 알려주기
    public E get(int index) {
        if (index >= 0 && index <= numItems - 1) {
            return item[index];
        } else {
            return null;
        }
    }

    // 배열 리스트의 i번째 원소를 x로 대체하기
    public void set(int index, E x) {
        if (index >= 0 && index <= numItems - 1) {
            item[index] = x;
        } else {
            /*예외처리*/
        }
    }

    // 원소x가 배열 리스트의 몇 번째 원소인지 알려주기
    private final int NOT_FOUND = -1;
    public int indexOf(E x) {
        int i = 0;
        for (i = 0; i < numItems - 1 ; i++) {
            if (((Comparable)item[i]).compareTo(x) == 0) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    // 리스트의 총 원소 수 알려주기
    public int len() {
        return numItems;
    }

    // 리스트가 비었는지 알려주기
    public boolean isEmpty() {
        return numItems == 0;
    }

    // 리스트 깨끗이 청소하기
    public void clear() {
        item = (E[]) new Object[item.length];
        numItems = 0;
    }

}