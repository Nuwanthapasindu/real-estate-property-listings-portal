package com.replp.DSA;


import com.replp.model.Property;

public class Node {
    public Property property;
    public Node left;
    public Node right;

    public Node(Property property) {
        this.property = property;
        this.left = null;
        this.right = null;
    }
}