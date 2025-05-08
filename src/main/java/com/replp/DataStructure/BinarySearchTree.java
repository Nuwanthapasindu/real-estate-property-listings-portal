package com.replp.DataStructure;

import com.replp.model.Property;

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
        if (property.getPrice() < root.property.getPrice()) {
            root.left = insertRec(root.left, property);
        } else if (property.getPrice() > root.property.getPrice()) {
            root.right = insertRec(root.right, property);
        }
        return root;
    }

    // Find a node with the given price





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
}
