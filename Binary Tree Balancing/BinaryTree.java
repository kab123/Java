package hw2;

public class BinaryTree
{
    private Node root;
    private int nodeNumbers;

    public BinaryTree()
    {
	root = null;
    }

    //
    // INSTERT
    //
    public void insert(int n)
    {
	Node current = root;
	Node newNode = new Node();
	newNode.data = n;
	newNode.left = null;
	newNode.right = null;

	if (root == null)
	    root = newNode;
	else
	    while (true)
	    {
		if (newNode.data > current.data)
		    if (current.right == null)
		    {
			current.right = newNode;
			break;
		    } else
			current = current.right;
		else if (current.left == null)
		{
		    current.left = newNode;
		    break;
		} else
		    current = current.left;
		nodeNumbers++;
	    }

    }

    //
    // SEARCH
    //
    public Node search(int n)
    {
	Node current = root;
	while (current != null)
	    if (current.data == n)
		return current;
	    else if (current.data > n)
		current = current.left;
	    else
		current = current.right;
	return null;
    }

    //
    // DELETE
    //
    public boolean remove(int n)
    {
	// Check empty tree
	if (root == null)
	    return false;

	// Prepare search for node
	Node current = root;
	Node parent = root;
	boolean currentIsLeft = true;

	while (current.data != n)
	{
	    parent = current;
	    if (current.data > n)
	    {
		currentIsLeft = true;
		current = current.left;
	    } else
	    {
		currentIsLeft = false;
		current = current.right;
	    }
	    nodeNumbers--;
	    // If current is null, node n was not found
	    if (current == null)
		return false;
	}
	// Situation 1 - leaf node
	if (current.left == null && current.right == null)

	    // Check if current node is root
	    if (parent == current)
		root = null;

	    // Check which child pointer of parent to set
	    else if (currentIsLeft)
		parent.left = null;
	    else
		parent.right = null;
	// Situation 2 - one child. Parent inherits child
	// or if current is root, root takes child
	else if (current.left == null)
	    if (parent == current)
		root = current.right;
	    else if (currentIsLeft)
		parent.left = current.right;
	    else
		parent.right = current.right;
	else if (current.right == null)
	    if (parent == current)
		root = current.left;
	    else if (currentIsLeft)
		parent.left = current.left;
	    else
		parent.right = current.left;
	// Situation 3: two children
	else
	{
	    Node successor = getSuccessor(current);
	    // Replace current node with successor
	    if (parent == current)
		root = successor;
	    else if (currentIsLeft)
		parent.left = successor;
	    else
		parent.right = successor;
	    // Successor will always come from the right, so
	    // it must also take deleted node’s left child
	    successor.left = current.left;
	}
	return true;
    }

    //
    // GET SUCSESSOR
    //
    private Node getSuccessor(Node removedNode)
    {
	// Prepare successor search by keeping track
	// of parent and current
	Node successorParent = removedNode;
	Node successor = removedNode;
	Node current = successor.right;
	while (current != null)
	{
	    successorParent = successor;
	    successor = current;
	    current = current.left;
	}

	if (successor != removedNode.right)
	{
	    successorParent.left = successor.right;
	    successor.right = removedNode.right;
	}

	return successor;
    }

    public void inOrder()
    {
	displayInOrder(root);
    }

    void displayInOrder(Node current)
    {
	if (current != null)
	{
	    displayInOrder(current.left);
	    System.out.println(current.data);
	    displayInOrder(current.right);
	}
    }

    public void preOrder()
    {
	displayPreOrder(root);
    }

    void displayPreOrder(Node current)
    {
	if (current != null)
	{
	    System.out.println(current.data);
	    displayPreOrder(current.left);
	    displayPreOrder(current.right);
	}
    }

    //
    // UPDATE
    //
    public boolean update(int i, int j)
    {
	Node compare = search(i);
	if (compare == null)
	    return false;
	else
	{
	    remove(i);
	    insert(j);
	    return true;
	}

    }

    //
    // FIND MIN
    //
    public int findMin()
    {
	System.out.print("min: ");
	return min(root);
    }

    public int min(Node current)
    {

	while (current.left != null)
	{
	    current = current.left;
	}
	return (current.data);
    }

    //
    // FIND MAX
    //
    public int findMax()
    {
	System.out.print("max: ");
	return max(root);
    }

    public int max(Node current)
    {
	while (current.right != null)
	{
	    current = current.right;
	}
	return (current.data);
    }

    //
    // AVERAGE
    //
    public double calculateAverage()
    {

	System.out.print("average: ");
	return treeAverageHelper(root) / nodeNumbers;
    }

    public static double treeAverageHelper(Node node)
    {
	if (node == null)
	    return 0;
	return node.data + treeAverageHelper(node.left) + treeAverageHelper(node.right);
    }

    //
    // NUMBER OF NODES
    //
    public int getNumberOfNodes()
    {
	System.out.print("number of nodes: ");
	return nodeNumbers;
    }

    //
    // IS BALANCED
    //
    public boolean isBalanced()
    {
	return balancing(root);
    }

    public boolean balancing(Node current)
    {
	if (current == null || (current.left == null && current.right == null))
	    return true;
	else
	{
	    // if left sub tree of current is balanced
	    // and if right sub tree of current is balanced
	    // and if the current left subtree height is differs than right
	    // subtree height by less than or equal to 1
	    // return true
	    // else return false
	    if (balancing(current.left) == true && balancing(current.right) == true
		    && Math.abs(getHeight(current.left) - getHeight(current.right)) <= 1)
		return true;
	    else return false;
	}
    }

    public int getHeight(Node current)
    {
	//if current is null
	//return 0
	//else
	// go to currents child and count it as the height
	if(current == null)
	return 0;
	else
	{
	 //if left subtree height is bigger than right subtree height
	 //return 1 + the height of left sub tree
	 //else return 1 + right subtree height
	    if(getHeight(current.left) > getHeight(current.right))
	    return 1 + getHeight(current.left);
	    else
		return 1+ getHeight(current.right);
	}
	    
    }

}
