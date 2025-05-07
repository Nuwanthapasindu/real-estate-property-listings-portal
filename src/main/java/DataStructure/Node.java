package DataStructure;

import com.replp.model.Property;

public class Node {
    Property property;
    Node left, right;

    Node(Property property) {
        this.property = property;
        left = right = null;
    }
}
class BinarySearchTree {
    Node root;

    // Insert a new price
    public void insert(Property property) {
        root = insertRec(root, property);
    }

    private Node insertRec(Node root, Property property) {
        if (root == null) {
            return new Node(property);
        }
        if (property < root.property.getPrice()) {
            root.left = insertRec(root.left, property);
        } else if (property> root.property.getPrice()) {
            root.right = insertRec(root.right, property);
        }
        return root;
    }

    // Find a node with the given price
    public boolean find(Property property) {
        return findRec(root, property);
    }

    private boolean findRec(Node root, Property property) {
        if (root == null) {
            return false;
        }
        if (property== root.property.getPrice()) {
            return true;
        }
        return property < root.property.getPrice() ? findRec(root.left, property) : findRec(root.right, property);
    }

    // Delete a node with the given price
    public void delete(Property property) {
        root = deleteRec(root, property);
    }

    private Node deleteRec(Node root, Property property) {
        if (root == null) return null;

        if (property < root.property.getPrice()){
            root.left = deleteRec(root.left, property);
        } else if (property > root.property.getPrice()) {
            root.right = deleteRec(root.right, property);
        } else {
            // Node with only one child or no child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // Node with two children: get inorder successor
            root.property.getPrice() = minValue(root.right);
            root.right = deleteRec(root.right, root.property.getPrice());
        }
        return root;
    }

    private double minValue(Node root) {
        double minv = root.property.getPrice();
        while (root.left != null) {
            root = root.left;
            minv = root.property.getPrice();
        }
        return minv;
    }

    // Update: delete old price and insert new price
    public void update(Property oldProperty, Property newProperty) {
        if (find(oldProperty)) {
            delete(oldProperty);
            insert(newProperty);
        } else {
            System.out.println("Price not found, cannot update.");
        }
    }

    // Inorder traversal for debugging
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.property + " ");
            inorderRec(root.right);
        }
    }

    // Main method to test
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(20.5);
        bst.insert(10.0);
        bst.insert(30.2);
        bst.insert(25.4);
        bst.insert(5.5);

        System.out.print("Inorder traversal: ");
        bst.inorder();

        System.out.println("Find 10.0: " + bst.find(10.0));
        System.out.println("Find 40.0: " + bst.find(40.0));

        System.out.println("Deleting 10.0");
        bst.delete(10.0);
        System.out.print("Inorder after deletion: ");
        bst.inorder();

        System.out.println("Updating 25.4 to 27.8");
        bst.update(25.4, 27.8);
        System.out.print("Inorder after update: ");
        bst.inorder();
    }
}
