package com.witmusk.datastructure;

import java.util.NoSuchElementException;

public class LinkedList<E> {
    private int size;
    private Node first;

    private static class Node<E> {
        E data;
        Node next;

        public Node() {
        }

        public Node(E data) {
            this.data = data;
            this.next = null;
        }

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public LinkedList() {
        this.first = null;
        this.size = 0;
    }

    public E getFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return (E) first.data;
    }

    public int size() {
        return this.size;
    }

    public LinkedList<E> add(E e) {
        Node node = new Node(e, first);
        this.first = node;
        size++;
        return this;
    }

    public LinkedList<E> remove(E e) {
        if (first == null) {
            throw new NoSuchElementException();
        }
        if (first.data.equals(e) || (first.data == null && e == null)) {
            Node n = first;
            first = first.next;
            n = null;
            size--;
        } else {
            Node p = first;
            Node c = first.next;
            while (c != null) {
                if (c.data.equals(e) || (c.data == null && e == null)) {
                    break;
                }
                p = c;
                c = c.next;
            }

            if (c == null) {
                throw new NoSuchElementException();
            }
            p.next = c.next;
            c = null;
            size--;
        }
        return this;
    }

    public LinkedList clear() {
        Node n = first;
        while (n != null) {
            Node next = n.next;
            n.next = null;
            n.data = null;
            n = next;
        }
        first = null;
        size = 0;
        return this;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1).add(2).add(3);
        list.remove(1);
        list.clear();
    }
}
