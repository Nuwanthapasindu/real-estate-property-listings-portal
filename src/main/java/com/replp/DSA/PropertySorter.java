package com.replp.DSA;


import com.replp.model.Property;

import java.util.List;

public class PropertySorter {
    public static void quickSortByPrice(List<Property> properties, String order) {
        if (properties == null || properties.size() <= 1) {
            return;
        }
        quickSort(properties, 0, properties.size() - 1, order);
    }

    private static void quickSort(List<Property> properties, int low, int high, String order) {
        if (low < high) {
            int pi = partition(properties, low, high, order);
            quickSort(properties, low, pi - 1, order);
            quickSort(properties, pi + 1, high, order);
        }
    }

    private static int partition(List<Property> properties, int low, int high, String order) {
        double pivot = properties.get(high).getPrice();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            boolean shouldSwap;
            if ("ASC".equalsIgnoreCase(order)) {
                shouldSwap = properties.get(j).getPrice() <= pivot;
            } else if ("DESC".equalsIgnoreCase(order)) {
                shouldSwap = properties.get(j).getPrice() >= pivot;
            } else {
                throw new IllegalArgumentException("Order must be 'ASC' or 'DESC'");
            }

            if (shouldSwap) {
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