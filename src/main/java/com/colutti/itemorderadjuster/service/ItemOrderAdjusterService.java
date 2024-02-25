package com.colutti.itemorderadjuster.service;

import com.colutti.itemorderadjuster.model.Item;
import java.util.Comparator;
import java.util.List;

public class ItemOrderAdjusterService {

    private static final int FIRST_ORDER_TO_ITEMS = 1;

    public void removeItem(List<Item> items, int orderToRemove) {
        if (orderToRemove < 1 || orderToRemove > items.size()) {
            System.out.println("Invalid position. Removal not performed.");
            return;
        }

        // Remove the item from the specified position
        items.remove(orderToRemove - 1);

        // Reorder the remaining items
        for (int i = 0; i < items.size(); i++) {
            items.get(i).setOrder(i + 1);
        }
    }

    public void automaticallyAdjustPositions(List<Item> items) {
        // Sort the list of items based on their current positions
        items.sort(Comparator.comparingInt(items::indexOf));

        // Update the orders of the items based on their positions in the list
        int order = FIRST_ORDER_TO_ITEMS;
        for (Item item : items) {
            item.setOrder(order++);
        }
    }
}

