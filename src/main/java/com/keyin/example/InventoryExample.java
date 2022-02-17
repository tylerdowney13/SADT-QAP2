package com.keyin.example;

import java.util.ArrayList;
import java.util.List;

public class InventoryExample {
    private InventoryDB inventoryDB;

    public InventoryExample() {
    }

    public InventoryExample(InventoryDB inventoryDB) {
        this.inventoryDB = inventoryDB;
    }

    public InventoryItem findInventoryItemByName(String itemName) {
        InventoryItem itemFound = null;

        List<InventoryItem> itemList = inventoryDB.getInventoryItems();

        for (InventoryItem i: itemList) {
            if (i.getName().contains(itemName)) {
                itemFound = i;
                break;
            }
        }

        return itemFound;
    }

    public int findInventoryItemByQuantity(int quantity) {
        List<InventoryItem> itemList = inventoryDB.getInventoryItems();
        List<InventoryItem> foundItems = new ArrayList<>();

        for (InventoryItem i: itemList) {
            if (i.getQuantity() == quantity) {
                foundItems.add(i);
            }
        }

        if (foundItems.size() > 0) {
            return foundItems.size();
        } else {
            return 0;
        }
    }

    public int findInventoryItemByPrice(double price) {
        List<InventoryItem> itemList = inventoryDB.getInventoryItems();
        List<InventoryItem> foundItems = new ArrayList<>();

        for (InventoryItem i: itemList) {
            if (i.getPrice() == price) {
                foundItems.add(i);
            }
        }

        if (foundItems.size() > 0) {
            return foundItems.size();
        } else {
            return 0;
        }
    }
}
