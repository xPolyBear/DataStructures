public class W15D3Coding {

    public static void main(String[] args) {

        System.out.println();
        W15D3Coding SearchTree = new W15D3Coding();
        SearchTree.insert(90);
        SearchTree.insert(20);
        SearchTree.insert(105);
        SearchTree.insert(15);
        SearchTree.insert(30);
        SearchTree.insert(100);
        SearchTree.insert(122);
        SearchTree.insert(10);
        SearchTree.insert(110);

        System.out.println("In-order Traversal:");
        SearchTree.inOrderTraversal();
        System.out.println();

        System.out.println("Reverse-order Traversal:");
        SearchTree.reverseOrderTraversal();
        System.out.println();

        System.out.println("Pre-order Traversal:");
        SearchTree.preorderTraversal();
        System.out.println();

        System.out.println("Post-order Traversal:");
        SearchTree.postorderTraversal();
        System.out.println();


        System.out.println("Searching for 20: " + SearchTree.search(20));
        System.out.println();

        System.out.println("Searching for 111: " + SearchTree.search(111));
        System.out.println();

        System.out.println("Removing 10: " + SearchTree.remove(10));
        System.out.println("In-order Traversal after removing 10:");
        SearchTree.inOrderTraversal();
        System.out.println();

        System.out.println("Removing 105: " + SearchTree.remove(105));
        System.out.println("In-order Traversal after removing 105:");
        SearchTree.inOrderTraversal();
        System.out.println();

        System.out.println("Search Tree Height: " + SearchTree.getHeight());
        System.out.println();


    }

    public class Node {

        public int key;
        public Node left;
        public Node right;

        public Node(int key) {
            this(key, null, null);
        }

        public Node(int key, Node left, Node right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }
    }

    public Node root = null;

    public void insert(int value) {

        insert(new Node(value));
    }

    public void insert(Node node) {
        if (root == null) {
            root = node;
        } else {
            Node currentNode = root;
            while (currentNode != null) {

                if (node.key == currentNode.key) {
                    return;
                } else if (node.key < currentNode.key) {

                    if (currentNode.left == null) {
                        currentNode.left = node;
                        currentNode = null;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = node;
                        currentNode = null;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
        }
    }

    public boolean remove(int value) {

        Node parent = null;
        Node currentNode = root;

        while (currentNode != null) {

            if (currentNode.key == value) {
                if (currentNode.left == null && currentNode.right == null) {
                    if (parent == null) {

                        root = null;
                    } else if (parent.left == currentNode) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }

                    return true;
                } else if (currentNode.left != null && currentNode.right == null) {

                    if (parent == null) {
                        root = currentNode.left;
                    } else if (parent.left == currentNode) {
                        parent.left = currentNode.left;
                    } else {
                        parent.right = currentNode.left;
                    }

                    return true;
                } else if (currentNode.left == null && currentNode.right != null) {

                    if (parent == null) {
                        root = currentNode.right;
                    } else if (parent.left == currentNode) {
                        parent.left = currentNode.right;
                    } else {
                        parent.right = currentNode.right;
                    }

                    return true;
                } else {

                    Node successor = currentNode.right;
                    while (successor.left != null) {
                        successor = successor.left;
                    }

                    currentNode.key = successor.key;
                    parent = currentNode;
                    currentNode = currentNode.right;
                    value = successor.key;
                }
            } else if (currentNode.key < value) {
                parent = currentNode;
                currentNode = currentNode.right;
            } else {

                parent = currentNode;
                currentNode = currentNode.left;
            }
        }

        return false;
    }

    public boolean search(int value) {

        Node currentNode = root;
        while (currentNode != null) {

            if (currentNode.key == value) {
                return true;
            } else if (value < currentNode.key) {

                currentNode = currentNode.left;

            } else {
                currentNode = currentNode.right;
            }
        }

        return false;
    }

    
    public void inOrderTraversal() {
        inOrder(root);
        System.out.println();
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }


    public void reverseOrderTraversal() {
        reverseOrder(root);
        System.out.println();
    }

    public void reverseOrder(Node node) {
        if (node != null) {
            reverseOrder(node.right);
            System.out.print(node.key + " ");
            reverseOrder(node.left);
        }
    }


    public void preorderTraversal() {
        preorder(root);
        System.out.println();
    }

    public void preorder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorderTraversal() {
        postorder(root);
        System.out.println();
    }

    public void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.key + " ");
        }
    }

    public int getHeight() {
        return height(root);
    }

    public int height(Node node) {
        if (node == null) {
            return -1; // O choose -1 so that height of tree with only the root node is 0
        } else 
        {

            int leftHeight = height(node.left);
            int rightHeight = height(node.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }



}
