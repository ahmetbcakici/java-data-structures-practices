package test;

import main.BinaryHeap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinaryHeapTest {

    private BinaryHeap binaryHeap;

    @Before
    public void SetUp() {
        binaryHeap = new BinaryHeap();
    }

    @Test
    public void ExtractMax() {
        binaryHeap.insert(42);
        binaryHeap.insert(29);
        binaryHeap.insert(35);
        binaryHeap.insert(27);
        binaryHeap.insert(1);
        binaryHeap.insert(100);

        // Test insert
        Assert.assertEquals(100, binaryHeap.items[0]);
        Assert.assertEquals(29, binaryHeap.items[1]);
        Assert.assertEquals(42, binaryHeap.items[2]);
        Assert.assertEquals(27, binaryHeap.items[3]);
        Assert.assertEquals(1, binaryHeap.items[4]);
        Assert.assertEquals(35, binaryHeap.items[5]);

        // Text extract max
        Assert.assertEquals(42, binaryHeap.delete());
        Assert.assertEquals(35, binaryHeap.delete());
        Assert.assertEquals(29, binaryHeap.delete());
        Assert.assertEquals(27, binaryHeap.delete());
        Assert.assertEquals(1, binaryHeap.delete());
    }
}
