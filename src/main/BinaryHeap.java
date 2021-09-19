package main;

public class BinaryHeap {

    private int capacity = 10;
    private int size = 0;

    public int[] items = new int[capacity];

    private int leftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    private int rightChildIndex(int parentIndex) {
        return parentIndex * 2 + 2;
    }

    private int parentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return parentIndex(index) < size;
    }

    private int leftChild(int index) {
        return items[leftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[rightChildIndex(index)];
    }

    private int parent(int index) {
        return items[parentIndex(index)];
    }

    public void insert(int item) {
        items[size] = item;
        size++;
        heapifyUp();
    }

    public int delete() {
        swap(0, size - 1);
        items[size - 1] = 0;
        size--;
        heapifyDown();
        return items[0];
    }

    private void heapifyUp() {
        int itemIndex = size - 1;

        while (items[itemIndex] > parent(itemIndex)) {
            swap(itemIndex, parentIndex(itemIndex));
            itemIndex = parentIndex(itemIndex);
        }
    }

    private void heapifyDown() {
        int index = 0;
        int biggerChildIndex = leftChild(index) > rightChild(index) ? leftChildIndex(index) : rightChildIndex(index);

        while (items[biggerChildIndex] > items[index]){
            swap(biggerChildIndex, index);
            index = biggerChildIndex;
            biggerChildIndex = leftChild(index) > rightChild(index) ? leftChildIndex(index) : rightChildIndex(index);
        }
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }
}
