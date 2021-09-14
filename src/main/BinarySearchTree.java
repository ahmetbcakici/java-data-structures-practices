package main;

public class BinarySearchTree {
    private static class Node {
        int key;
        String value;
        Node left;
        Node right;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    Node root;

    public void insert(int key, String value) {
        root = insertItem(root, key, value);
    }

    private Node insertItem(Node node, int key, String value) {
        if (node == null) {
            node = new Node(key, value);
            return node;
        }

        if (node.key > key) {
            node.left = insertItem(node.left, key, value);
        } else {
            node.right = insertItem(node.right, key, value);
        }

        return node;
    }

    // TODO best practice here: move this responsibility to Node class
    public int findMinKey() {
        return findMinKey(root).key;
    }

    private Node findMinKey(Node node) {
        if (node.left == null)
            return node;

        return findMinKey(node.left);
    }

    public String find(int key) {
        Node node = find(root, key);
        return node == null ? null : node.value;
    }

    private Node find(Node node, int key) {
        if (node == null || node.key == key) {
            return node;
        }

        if (node.key > key) {
            return find(node.left, key);
        } else {
            return find(node.right, key);
        }
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    private Node delete(Node node, int key) {
        if (node == null) return null;

        if (key < node.key) {
            node.left = delete(node.left, key);
        } else {
            node.right = delete(node.right, key);
        }

        // no child
        if (node.left == null && node.right == null) {
            node = null;
            return node;
        }

        // one child
        if (node.left == null) {
            node.right = node;
        } else {
            node.left = node;
        }

        // TODO: two child?

        return node;
    }
}
