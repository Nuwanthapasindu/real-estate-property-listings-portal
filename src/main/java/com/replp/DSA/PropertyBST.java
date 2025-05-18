package com.replp.DSA;

import com.replp.model.Property;

import java.util.ArrayList;
import java.util.List;

public class PropertyBST {
    private static Node root;
        static {
            root = null;
        }

    public static void insert(Property property) {
        root = insertRec(root, property);
    }

    private static Node insertRec(Node root, Property property) {
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

    public static Property  findByTitle(String title) {
        return findByTitleRec(root, title);
    }

    private static Property findByTitleRec(Node root, String title) {
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

    public static Property findById(String id) {
        return findByIdRec(root, id);
    }

    private static Property findByIdRec(Node root, String id) {
        if (root == null) {
            return null;
        }

        if (root.property.getId().equals(id)) {
            return root.property;
        }

        Property leftResult = findByIdRec(root.left, id);
        if (leftResult != null) {
            return leftResult;
        }

        return findByIdRec(root.right, id);
    }

    public static void deleteById(String id) {
        root = deleteRec(root, id);
    }

    private static Node deleteRec(Node root, String id) {
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

    private static Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static boolean updateById(String id, Property newProperty) {
        deleteById(id);
        insert(newProperty);
        return true;
    }

    public static List<Property> inOrderTraversal() {
        List<Property> result = new ArrayList<>();
        inOrderRec(root, result);
        return result;
    }

    private static void inOrderRec(Node root, List<Property> result) {
        if (root != null) {
            inOrderRec(root.left, result);
            result.add(root.property);
            inOrderRec(root.right, result);
        }
    }
}



