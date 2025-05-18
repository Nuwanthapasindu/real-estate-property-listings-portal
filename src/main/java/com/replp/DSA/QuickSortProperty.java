package com.replp.DSA;

import com.replp.model.Property;

import java.util.List;

public class QuickSortProperty {

    public enum Order {
        ASCENDING,
        DESCENDING
    }

    public static void quickSort(List<Property> properties, int low, int high, Order order) {
        if (low < high) {
            int pivotIndex = partition(properties, low, high, order);
            quickSort(properties, low, pivotIndex - 1, order);
            quickSort(properties, pivotIndex + 1, high, order);
        }
    }

    private static int partition(List<Property> properties, int low, int high, Order order) {
        double pivot = properties.get(high).getPrice();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            boolean condition = (order == Order.ASCENDING)
                    ? properties.get(j).getPrice() < pivot
                    : properties.get(j).getPrice() > pivot;

            if (condition) {
                i++;
                swap(properties, i, j);
            }
        }

        swap(properties, i + 1, high);
        return i + 1;
    }

    private static void swap(List<Property> properties, int i, int j) {
        Property temp = properties.get(i);
        properties.set(i, properties.get(j));
        properties.set(j, temp);
    }
}



