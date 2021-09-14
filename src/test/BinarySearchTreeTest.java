package test;

import main.BinarySearchTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {

    private BinarySearchTree bst;

    @Before
    public void SetUp() {
        bst = new BinarySearchTree();
    }

    @Test
    public void Insert() {
        bst.insert(5, "e");
        bst.insert(3, "c");
        bst.insert(2, "b");
        bst.insert(4, "d");
        bst.insert(7, "g");
        bst.insert(6, "f");
        bst.insert(8, "h");

        Assert.assertEquals("e", bst.find(5));
        Assert.assertEquals("c", bst.find(3));
        Assert.assertEquals("b", bst.find(2));
        Assert.assertEquals("d", bst.find(4));
        Assert.assertEquals("g", bst.find(7));
        Assert.assertEquals("f", bst.find(6));
        Assert.assertEquals("h", bst.find(8));
        Assert.assertEquals(null, bst.find(99));

//        bst.prettyPrint();
//        bst.printInOrderTraversal();
//        bst.printPreOrderTraversal();
//        bst.printPostOrderTraversal();
    }

    @Test
    public void MinKey() {
        bst.insert(23, "e");
        bst.insert(11, "e");
        bst.insert(30, "e");
        bst.insert(3, "b");
        bst.insert(25, "e");
        bst.insert(5, "e");
        bst.insert(8, "e");
        bst.insert(10, "c");
        bst.insert(1, "b");
        bst.insert(90, "b");
        bst.insert(2, "b");
        bst.insert(150, "b");
        bst.insert(4, "b");

        Assert.assertEquals(1, bst.findMinKey());
    }

    @Test
    public void DeleteNoChild() {
        bst.insert(5, "e");
        bst.insert(3, "c");
        bst.insert(2, "z");
        bst.insert(4, "d");
        bst.insert(7, "g");
        bst.insert(6, "f");
        bst.insert(8, "h");

        bst.delete(2);

        Assert.assertNull(bst.find(2));
    }

    @Test
    public void DeleteOneChild() {
        bst.insert(5, "e");
        bst.insert(3, "c");
        bst.insert(2, "b");
        bst.insert(4, "d");
        bst.insert(7, "g");
        bst.insert(8, "h");

        bst.delete(7);

        Assert.assertNull(bst.find(7));
    }
//
//    @Test
//    public void DeleteTwoChildren() {
//        bst.insert(5, "e");
//        bst.insert(3, "c");
//        bst.insert(2, "b");
//        bst.insert(4, "d");
//        bst.insert(7, "g");
//        bst.insert(6, "f");
//        bst.insert(8, "h");
//
//        bst.delete(7);
//
//        Assert.assertNull(bst.find(7));
//
//        bst.prettyPrint();
//    }
//
//    @Test
//    public void checkBST1() {
//        bst.insert(5, "e");
//        bst.insert(3, "c");
//        bst.insert(2, "b");
//        bst.insert(4, "d");
//        bst.insert(7, "g");
//        bst.insert(6, "f");
//        bst.insert(8, "h");
//
//        Assert.assertTrue(bst.checkBST(bst.root));
//    }
}
