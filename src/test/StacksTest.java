package test;

import main.Stacks;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StacksTest {

    private Stacks stacks;

    @Before
    public void SetUp() {
        stacks = new Stacks();
    }

    @Test
    public void Push() {
        stacks.push(15);
        stacks.push(25);
        stacks.push(75);

        Assert.assertEquals(3, stacks.size());
        Assert.assertEquals(75, stacks.peek());
        Assert.assertEquals(false, stacks.isEmpty());
    }

    @Test
    public void Pop() {
        stacks.push(15);
        stacks.push(25);
        stacks.pop();
        stacks.push(35);
        stacks.pop();

        Assert.assertEquals(15, stacks.peek());
        Assert.assertEquals(1, stacks.size());
        Assert.assertEquals(false, stacks.isEmpty());
        Assert.assertEquals(15, stacks.pop());
    }
}
