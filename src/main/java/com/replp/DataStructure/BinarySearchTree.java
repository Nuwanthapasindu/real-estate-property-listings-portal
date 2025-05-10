package com.replp.DataStructure;

import com.replp.model.Property;

import java.util.ArrayList;
import java.util.List;

 class PropertyBST {
    private Node root;

    public PropertyBST() {
        this.root = null;
    }

    public void insert(Property property) {
        root = insertRec(root, property);
    }

    private Node insertRec(Node root, Property property) {
        if (root == null) {
            return new Node(property);
        }

        if (property.getPrice() < root.property.getPrice()) {
            root.left = insertRec(root.left, property);
        } else {
            root.right = insertRec(root.right, property);
        }

        return root;
    }

    public Property findByTitle(String title) {
        return findByTitleRec(root, title);
    }

    private Property findByTitleRec(Node root, String title) {
        if (root == null) {
            return null;
        }

        if (root.property.getTitle().equalsIgnoreCase(title)) {
            return root.property;
        }

        Property leftResult = findByTitleRec(root.left, title);
        if (leftResult != null) {
            return leftResult;
        }

        return findByTitleRec(root.right, title);
    }

    public void deleteById(String id) {
        root = deleteRec(root, id);
    }

    private Node deleteRec(Node root, String id) {
        if (root == null) {
            return null;
        }

        if (root.property.getId().equals(id)) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            Node minNode = findMin(root.right);
            root.property = minNode.property;
            root.right = deleteRec(root.right, minNode.property.getId());
        } else {
            root.left = deleteRec(root.left, id);
            root.right = deleteRec(root.right, id);
        }

        return root;
    }

    private Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public boolean updateById(String id, Property newProperty) {
        deleteById(id);
        insert(newProperty);
        return true;
    }

    public List<Property> inOrderTraversal() {
        List<Property> result = new ArrayList<>();
        inOrderRec(root, result);
        return result;
    }

    private void inOrderRec(Node root, List<Property> result) {
        if (root != null) {
            inOrderRec(root.left, result);
            result.add(root.property);
            inOrderRec(root.right, result);
        }
    }
}

