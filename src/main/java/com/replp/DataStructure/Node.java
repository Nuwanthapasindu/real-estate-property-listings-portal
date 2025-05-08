package com.replp.DataStructure;

import com.replp.model.Property;

public class Node {
    Property property;
    Node left, right;

    Node(Property property) {
        this.property = property;
        left = right = null;
    }
}


