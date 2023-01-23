package com.webjdbc.webjdbc;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    
    // item repository (FOR EVENTUAL JPA)
    ItemService itemService;

    ItemController(ItemService service) {
        this.itemService = service;
    }
    
    @PostMapping("/createitem")
    Item createItem(@RequestBody Item newItem) {
        String title = newItem.getTitle();
        String desc = newItem.getDescription();
        try {
            Item createdItem = this.itemService.createItem(title, desc);
            return createdItem;
        } catch (SQLException s) {
            return null;
        }
    }

    @PostMapping("/markitemasdone/{title}")
    int markItemAsDone(@PathVariable String title) {
        try {
            int result = this.itemService.markItemAsDone(title);
            return result;
        } catch (SQLException s) {
            return 0;
        }   
    }

    @PutMapping("/updateitemdescription/{title}")
    int updateItemDescription(@RequestBody Item newItem) {
        String title = newItem.getTitle();
        String desc = newItem.getDescription();
        try {
            int result = this.itemService.updateItemDescription(title, desc);
            return result;
        } catch (SQLException s) {
            return 0;
        } 
    }

    @GetMapping("/viewitem/{title}")
    Item viewItem(@PathVariable String title) {
        try {
            return this.itemService.viewItem(title);
        } catch (SQLException s) {
            return null;
        }
    }

    @GetMapping("/viewitems")
    List<Item> viewItems() {
        try {
            return this.itemService.viewItems();
        } catch (SQLException s) {
            return null;
        }
    }

    @DeleteMapping("/deleteitem/{title}")
    int deleteItem(@PathVariable String title) {
        try {
            int result = this.itemService.deleteItem(title);
            return result;
        } catch (SQLException s) {
            return 0;
        }
    }

    @DeleteMapping("/deleteitems")
    int deleteItems() {
        try {
            int result = this.itemService.deleteItems();
        return result;
        } catch (SQLException s) {
            return 0;
        }
    }
}