package test;

import main.LinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

    private LinkedList linkedList;

    @Before
    public void SetUp() {
        linkedList = new LinkedList();
    }

    @Test
    public void AddFront() {
        linkedList.addFront(1);
        linkedList.addFront(2);
        linkedList.addFront(3);

        Assert.assertEquals(3, linkedList.getFirst());
        Assert.assertEquals(1, linkedList.getLast());
    }

    @Test
    public void GetFirst() {
        linkedList.addFront(1);
        Assert.assertEquals(1, linkedList.getFirst());
    }

    @Test
    public void GetLast() {
        linkedList.addFront(1);
        linkedList.addFront(2);
        linkedList.addFront(3);

        Assert.assertEquals(1, linkedList.getLast());
    }

    @Test
    public void AddBack() {
        linkedList.addBack(1);
        linkedList.addBack(2);
        linkedList.addBack(3);

        Assert.assertEquals(1, linkedList.getFirst());
        Assert.assertEquals(3, linkedList.getLast());
    }

    @Test
    public void Size() {
        linkedList.addFront(2);

        Assert.assertEquals(1, linkedList.size());

        linkedList.addFront(1);
        linkedList.addBack(3);

        Assert.assertEquals(3, linkedList.size());
    }

    @Test
    public void Clear() {
        linkedList.addFront(34);
        linkedList.addFront(76);
        linkedList.addFront(11);

        linkedList.clear();

        Assert.assertEquals(0, linkedList.size());
    }

    @Test
    public void DeleteValue() {
        linkedList.addFront(34);
        linkedList.addFront(76);
        linkedList.addFront(26);
        linkedList.addFront(35);
        linkedList.addFront(44);
        linkedList.addFront(48);
        linkedList.addFront(11);

        linkedList.deleteValue(34);

        Assert.assertEquals(6, linkedList.size());
        Assert.assertEquals(11, linkedList.getFirst());
        Assert.assertEquals(76, linkedList.getLast());
    }
}
