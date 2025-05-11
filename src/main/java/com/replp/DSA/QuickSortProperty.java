package com.replp.DSA;

import com.replp.model.File;
import com.replp.model.Property;

import java.util.ArrayList;
import java.util.List;

public class QuickSortProperty {

        public static void quickSort(List<Property> properties, int low, int high) {
            if (low < high) {
                int pivotIndex = partition(properties, low, high);
                quickSort(properties, low, pivotIndex - 1);  // Left side of pivot
                quickSort(properties, pivotIndex + 1, high); // Right side of pivot
            }
        }

        private static int partition(List<Property> properties, int low, int high) {
            double pivot = properties.get(high).getPrice(); // Using last element as pivot
            int i = low - 1; // Index of smaller element

            for (int j = low; j < high; j++) {
                if (properties.get(j).getPrice() < pivot) {
                    i++;
                    swap(properties, i, j);
                }
            }

            swap(properties, i + 1, high); // Move pivot to correct position
            return i + 1;
        }

        private static void swap(List<Property> properties, int i, int j) {
            Property temp = properties.get(i);
            properties.set(i, properties.get(j));
            properties.set(j, temp);
        }
    }


 class Main {
    public static void main(String[] args) {
        List<Property> propertyList = new ArrayList<>();

        // Sample properties
        propertyList.add(new Property("1", "Villa", "House", "Miami", 500000, 3000, "Luxury villa", new ArrayList<File>(), "user1"));
        propertyList.add(new Property("2", "Apartment", "Flat", "NYC", 300000, 1000, "Modern apartment", new ArrayList<File>(), "user2"));
        propertyList.add(new Property("3", "Cottage", "House", "Denver", 200000, 1500, "Cozy cottage", new ArrayList<File>(), "user3"));
        propertyList.add(new Property("4", "Penthouse", "Flat", "LA", 800000, 2500, "High-end penthouse", new ArrayList<File>(), "user4"));

        System.out.println("Before sorting:");
        for (Property p : propertyList) {
            System.out.println(p);
        }

        // Apply quick sort
        QuickSortProperty.quickSort(propertyList, 0, propertyList.size() - 1);

        System.out.println("\nAfter sorting by price:");
        for (Property p : propertyList) {
            System.out.println(p);
        }
    }
}
