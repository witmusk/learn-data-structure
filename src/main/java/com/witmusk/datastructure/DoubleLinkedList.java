package com.witmusk.datastructure;

import java.util.NoSuchElementException;

public class DoubleLinkedList<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        E data;
        Node prev;
        Node next;

        public Node(E data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public DoubleLinkedList() {
        this.size = 0;
        first = last = null;
    }

    public DoubleLinkedList<E> addFirst(E e) {
        if (first == null) {
            first = new Node(e, null, null);
            last = first;
        } else {
            Node n = new Node(e, null, first);
            first.prev = n;
            first = n;
        }
        size++;
        return this;
    }

    public DoubleLinkedList<E> addLast(E e) {
        if (last == null) {
            last = new Node(e, null, null);
            first = last;
        } else {
            Node n = new Node(e, last, null);
            last.next = n;
            last = n;
        }
        size++;
        return this;
    }

    public DoubleLinkedList<E> remove(E e) {
        if (first == null) {
            throw new NoSuchElementException();
        }
        Node n = first;
        while (n != null) {
            if (n.data.equals(e) || (n.data == null && e == null)) {
                break;
            }
            n = n.next;
        }
        if (n == null) {
            throw new NoSuchElementException();
        }
        Node prev = n.prev;
        Node next = n.next;
        if (n == first) {
            first = next;
        } else {
            prev.next = next;
        }
        if (n == last) {
            last = prev;
        } else {
            next.prev = prev;
        }
        size--;
        return this;
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.addLast(1).addLast(2).addLast(3);
        list.remove(2);
    }
}
