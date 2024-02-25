package com.colutti.itemorderadjuster;

import com.colutti.itemorderadjuster.dto.GroupedItemDto;
import com.colutti.itemorderadjuster.model.Item;
import com.colutti.itemorderadjuster.service.ItemOrderAdjusterService;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdjustItemOrderTest {

    @Test
    public void whenPass_messyList_thenReturn_orderListUsingOrderAttribute(){

        List<List<Item>> groupedItems = new ArrayList<>();
        List<Item> firstItemList = new ArrayList<>();
        firstItemList.add(new Item("item_01", 1));
        firstItemList.add(new Item("item_03", 3));
        firstItemList.add(new Item("item_10", 10));
        firstItemList.add(new Item("item_04", 4));
        firstItemList.add(new Item("item_05", 5));
        firstItemList.add(new Item("item_08", 8));
        firstItemList.add(new Item("item_06", 6));
        firstItemList.add(new Item("item_07", 7));
        firstItemList.add(new Item("item_02", 2));
        firstItemList.add(new Item("item_09", 9));

        groupedItems.add(firstItemList);
        GroupedItemDto groupedItemDto = new GroupedItemDto();
        groupedItemDto.setGroupedItems(groupedItems);

        for(List<Item> itemList : groupedItemDto.getGroupedItems()){
            ItemOrderAdjusterService itemOrderAdjusterService = new ItemOrderAdjusterService();
            itemOrderAdjusterService.automaticallyAdjustPositions(itemList);
            assertEquals(itemList.get(0).getOrder(), 1);
            assertEquals(itemList.get(1).getOrder(), 2);
            assertEquals(itemList.get(1).getName(), "item_03");
        }

        List<Item> orderedItemList = groupedItemDto.getGroupedItems().get(0);
        ItemOrderAdjusterService itemOrderAdjusterService = new ItemOrderAdjusterService();
        itemOrderAdjusterService.removeItem(orderedItemList,3);

        assertEquals(orderedItemList.get(2).getName(), "item_04");
    }
}
