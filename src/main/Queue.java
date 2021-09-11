package main;

import java.util.NoSuchElementException;

public class Queue {

    private static class Node {
        private int data;
        private Node next;

        private Node(int data) {
            this.data = data;
        }
    }

    private Node head; // remove from here
    private Node tail; // add to here
    private int size;

    public void add(int data) {
        var newNode = new Node(data);

        size++;
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public int remove() {
        if (head == null) throw new NoSuchElementException();

        int data = head.data;
        head = head.next;
        size--;

        return data;
    }

    public int peek() {
        return head.data;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
