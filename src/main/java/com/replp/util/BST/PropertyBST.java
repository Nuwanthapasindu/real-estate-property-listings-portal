package com.replp.util.BST;

import com.replp.model.Property;

public class PropertyBST {
    private Node root;

    public PropertyBST() {
        root = null;
    }


    public void insert(Property property) {
      Node newNode = new Node();
        newNode.id = property.get_id();
        newNode.property = property;

        if (root == null) {
            root = newNode;
        }else {
            Node current = root;
            Node parent;

            while (true) {
                parent = current;
                if (property.get_id() < current.id) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        break;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        break;
                    }
                }
            }



        }



    }



}
