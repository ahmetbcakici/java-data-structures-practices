package main;

public class LinkedList {

    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    public void addFront(int data) {
        var newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addBack(int data) {
        var newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        var current = head;

        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public int getFirst() {
        return head.data;
    }

    public int getLast() {
        var current = head;
        while (current.next != null) {
            current = current.next;
        }

        return current.data;
    }

    public int size() {
        // this is second way to find size of linkedList.
        // first one is that keeping size variable and inc / dec it when add / remove element

        var size = 0;

        if (head == null) {
            return size;
        }

        var current = head;
        while (current != null) {
            current = current.next;
            size++;
        }

        return size;
    }

    public void clear() {
        head = null;
    }

    public void deleteValue(int value) {
        if (head == null)
            return;

        if (head.data == value) {
            head = head.next;
            return;
        }

        var current = head;

        while (current.next != null) {
            if (current.next.data == value) {
                current.next = current.next.next;
                return;
            }

            current = current.next;
        }
    }

    /*
    public static void main(String[] args) {}
    */
}
