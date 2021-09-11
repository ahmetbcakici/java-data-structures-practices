package main;

// LIFO - Last In First Out

import java.util.EmptyStackException;

public class Stack {

    private static class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;

    public void push(int data) {
        var newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public int pop() {
        if (head == null) throw new EmptyStackException();

        int data = head.data;
        head = head.next;
        size--;

        return data;
    }

    public int peek() {
        return head.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
