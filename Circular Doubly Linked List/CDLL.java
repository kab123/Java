public class CDLL
{
    private Node current;
    private int size = 0;

    /*
     * Insert creates a new node and puts in front of the current Node The new
     * node inserted becomes the list’s “current” Node
     */
    public void insert(int data)
    {
	Node newNode = new Node();
	newNode.data = data;
	if (current == null)
	{
	    current = newNode;
	    current.next = newNode;
	    current.previous = newNode;
	} else
	{
	    newNode.next = current;
	    newNode.previous = current.previous;
	    current.previous = newNode;
	    newNode.previous.next = newNode;
	    current = newNode;
	    current = newNode;
	}
	size++;
    }

    /*
     * Search starts from the current location and looks for the given data
     * value. If the Node is found, it returns the Node. Otherwise, it returns
     * null
     */

    public Node search(int data)
    {

	for (int i = 1; i <= size; i++)
	{
	    if (current == null)
		return null;
	    if (current.data == data)
	    {
		return current;
	    } else
	    {
		current = current.next;
	    }
	}
	return null;
    }

    /*
     * Update searches for the given oldData value. If the Node is found, it
     * changes the node value to newValue and returns true. Otherwise, it
     * returns false If the node is found, that node also becomes the current
     * Node
     */
    public boolean update(int oldValue, int newValue)
    {
	if(search(oldValue) == null)
	    return false;
	current.data = newValue;
	return true;
    }

    /*
     * Delete searches for the given data value. If the Node is found, it
     * removes the node from the list and returns true. Otherwise, it returns
     * false. If a node is removed, the next node becomes the current Node
     */
    public boolean delete(int data)
    {
	Node temp = search(data);
	if (temp == null)
	    return false;
	if (temp == current)
	{
	    if (size == 1)
	    {
		current = null;
	    } else
	    {
		current.previous.next = current.next;
		current.next.previous = current.previous;
		current = current.next;
	    }
	    size--;
	}
	return true;
    }

    /*
     * getCurrent returns the current Node in the list If the list is empty, it
     * returns null
     */
    public Node getCurrent()
    {
	return current;
    }

    /*
     * print displays all Nodes in order from the current node in the list using
     * the “next” node pointers of each node
     */
    public void print()
    {
	for (int i = 1; i <= size; i++)
	{
	    System.out.println(current.data + " ");
	    current = current.next;
	}
    }

    /*
     * print displays all Nodes in order from the current node in the list using
     * the “previous” node pointers of each node
     */
    public void printReverse()
    {
	for (int i = 1; i <= size; i++)
	{
	    System.out.println(current.data + " ");
	    current = current.previous;
	}

    }
}
