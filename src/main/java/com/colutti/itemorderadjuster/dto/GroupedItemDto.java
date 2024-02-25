package com.colutti.itemorderadjuster.dto;

import com.colutti.itemorderadjuster.model.Item;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class GroupedItemDto {

    @JsonProperty("grouped_items")
    private List<List<Item>> groupedItems;

    public List<List<Item>> getGroupedItems() {
        return groupedItems;
    }

    public void setGroupedItems(List<List<Item>> groupedItems) {
        this.groupedItems = groupedItems;
    }
}
