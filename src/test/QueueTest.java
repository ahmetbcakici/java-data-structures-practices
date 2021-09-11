package test;

import main.Queue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueueTest {

    private Queue queue;

    @Before
    public void SetUp() {
        queue = new Queue();
    }

    @Test
    public void Add() {
        queue.add(5);
        queue.add(2);
        queue.add(21);

        Assert.assertEquals(3, queue.size());
        Assert.assertEquals(5, queue.peek());
    }

    @Test
    public void Remove() {
        queue.add(8);
        queue.add(72);
        queue.add(11);
        queue.remove();
        queue.add(15);
        queue.add(35);
        queue.remove();

        Assert.assertEquals(3, queue.size());
        Assert.assertEquals(11, queue.peek());
    }
}
