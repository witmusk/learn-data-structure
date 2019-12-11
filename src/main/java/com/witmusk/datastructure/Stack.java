package com.witmusk.datastructure;

public class Stack<E> {
    private LinkedList<E> elements;

    public Stack(){
        elements = new LinkedList<>();
    }

    public Stack<E> clear(){
        elements.clear();
        return this;
    }

    public int size(){
        return elements.size();
    }

    public E getTop(){
        return elements.getFirst();
    }

    public Stack<E> push(E e){
        elements.addFirst(e);
        return this;
    }

    public E pop(){
        return elements.remove(0);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1).push(2).push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
