package org.example.util;


import java.util.Iterator;

public class LinkedList<E> implements Iterable<E>{

    private Node<E> head;
    private Node<E> tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int size() {
        int size = 0;
        Node<E> current = this.head;
        while (current!= null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public void add(E e) {
        Node<E> newNode = new Node<E>(e);
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = LinkedList.this.head;
            @Override
            public boolean hasNext() {
                return current!= null;
            }
            @Override
            public E next() {
                E e = current.getE();
                current = current.getNext();
                return e;
            }
        };
    }


    private class Node<E> {
        E e;
        Node<E> next;
        Node(E e, Node<E> next) {
            this.e = e;
            this.next = next;
        }
        Node(E e) {
            this(e, null);
        }

        public E getE() {
            return e;
        }

        public void setE(E e) {
            this.e = e;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }


}
