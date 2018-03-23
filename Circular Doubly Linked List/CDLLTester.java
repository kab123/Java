

/**
 * CDLLTester tests certain operations of the Circular LinkedList.
 * Do not modify anything inside this class.
 */
public class CDLLTester
{
    public static void main(String[] args)
    {
        CDLL list = new CDLL();

        /* Testing insert and delete method. */
        list.insert(5);
        if (list.delete(5) == true)
            System.out.println("Node 5 was deleted");
        else
            System.out.println("Node 5 was not deleted");
        if (list.delete(5) == true)
            System.out.println("Node 5 was deleted");
        else
            System.out.println("Node 5 was not deleted");
        list.print();

        /* Testing insert and print methods. */
        list.insert(9);
        list.insert(0);
        list.insert(3);
        list.insert(4);
        list.print();

        /* Testing search method. */
        Node findNode = list.search(3);
        if (findNode == null)
            System.out.println("Node 3 was not found");
        else
            System.out.println("Node 3 was found");
        list.print();

        findNode = list.search(5);
        if (findNode == null)
            System.out.println("Node 5 was not found");
        else
            System.out.println("Node 5 was found");
        list.print();

        /* Testing update and delete methods */
        if (list.update(0, 1) == true)
            System.out.println("Update of node 0 to 1 successful");
        else
            System.out.println("Update of node 0 to 1 not successful");
        System.out.println("Current node value is: " + list.getCurrent().data);
        list.printReverse();

        if (list.update(10, 1) == true)
            System.out.println("Update of node 10 to 1 successful");
        else
            System.out.println("Update of node 10 to 1 not successful");

        if (list.delete(5) == true)
            System.out.println("Node 5 was deleted");
        else
            System.out.println("Node 5 was not deleted");
        list.print();

        if (list.delete(4) == true)
            System.out.println("Node 4 was deleted");
        else
            System.out.println("Node 4 was not deleted");
        list.print();
    }

    /*

    Expected program output:

    Node 5 was deleted
    Node 5 was not deleted

    4
    3
    0
    9

    Node 3 was found
    3
    0
    9
    4

    Node 5 was not found
    3
    0
    9
    4
    
    Update of node 0 to 1 successful
    Current node values is: 1
    1
    3
    4
    9

    Update of node 10 to 1 not successful
    Node 5 was not deleted
    1
    9
    4
    3

    Node 4 was deleted
    3
    1
    9

    */
}
