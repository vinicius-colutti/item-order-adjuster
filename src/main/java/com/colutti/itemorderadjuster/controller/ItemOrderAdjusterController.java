package com.colutti.itemorderadjuster.controller;

import com.colutti.itemorderadjuster.dto.GroupedItemDto;
import com.colutti.itemorderadjuster.model.Item;
import com.colutti.itemorderadjuster.service.ItemOrderAdjusterService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/adjust_order_items")
public class ItemOrderAdjusterController {

    @PostMapping
    public List<List<Item>> reorderLists(@RequestBody GroupedItemDto groupedItemDto){
        for (List<Item> list : groupedItemDto.getGroupedItems()) {
            ItemOrderAdjusterService itemOrderAdjusterService = new ItemOrderAdjusterService();
            itemOrderAdjusterService.automaticallyAdjustPositions(list);
        }
        return groupedItemDto.getGroupedItems();
    }
}
