package hw2;
/**
 * Do not modify anything inside this class.
 */
public class BinaryTreeTester
{
    public static void main(String[] args)
    {
        BinaryTree t1 = new BinaryTree();

        // Test insert functions
        t1.insert(100);
        t1.insert(50);
        t1.insert(175);
        t1.insert(200);
        t1.insert(150);

        // Test displayInOrder and displayPreOrder
        System.out.println("InOrder: ");
        t1.inOrder();
        System.out.println("PreOrder: ");
        t1.preOrder();

        // Test search function
        Node searchNode = t1.search(150);
        if (searchNode != null)
            System.out.println("150 Found");
        else
            System.out.println("150 Not Found");

        searchNode = t1.search(10);
        if (searchNode != null)
            System.out.println("10 Found");
        else
            System.out.println("10 Not Found");

        // Test delete function
        System.out.println();
        t1.insert(160);
        t1.insert(170);
        t1.insert(155);
        t1.insert(158);
        t1.preOrder();

        // Leaf remove test
        if (t1.remove(200) == true)
            System.out.println("200 was found and removed");
        else
            System.out.println("200 was not found");
        t1.preOrder();

        // Not found remove test
        if (t1.remove(1) == true)
            System.out.println("1 was found and removed");
        else
            System.out.println("1 was not found");

        // One child remove test
        if (t1.remove(155) == true)
            System.out.println("155 was found and removed");
        else
            System.out.println("155 was not found");
        t1.preOrder();

        // Two children at root remove test
        if (t1.remove(100) == true)
            System.out.println("100 was found and removed");
        else
            System.out.println("100 was not found");
        t1.preOrder();

        // End given functions testing

        // Update test 1 - node not found
        if (t1.update(1000, 20) == true)
            System.out.println("1000 was changed to 20");
        else
            System.out.println("1000 was not changed to 20");

        // Update test 2 - node found
        if (t1.update(160, 25) == true)
            System.out.println("160 was changed to 25");
        else
            System.out.println("160 was not changed to 25");
        t1.preOrder();

        // Update test 3 - node found and changed root
        if (t1.update(150, 75) == true)
            System.out.println("150 was changed to 75");
        else
            System.out.println("150 was not changed to 75");
        t1.preOrder();

        // Math functions test
        System.out.println("Math functions test");
        System.out.println(t1.findMin());
        System.out.println(t1.findMax());
        System.out.println(t1.calculateAverage());
        System.out.println(t1.getNumberOfNodes());

        // Balance test 1
        if (t1.isBalanced())
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");

        // Balance test 2
        t1.insert(171);
        t1.insert(172);
        t1.insert(173);
        t1.preOrder();
        if (t1.isBalanced())
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}

/*

Expected Output:

InOrder:
50
100
150
175
200
PreOrder:
100
50
175
150
200
150 Found
10 Not Found

100
50
175
150
160
155
158
170
200
200 was found and removed
100
50
175
150
160
155
158
170
1 was not found
155 was found and removed
100
50
175
150
160
158
170
100 was found and removed
150
50
175
160
158
170
1000 was not changed to 20
160 was changed to 25
150
50
25
175
170
158
150 was changed to 75
158
50
25
75
175
170
Math functions test
25
175
108.833333
6
Tree is balanced
158
50
25
75
175
170
171
172
173
Tree is not balanced

*/
