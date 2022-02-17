package com.keyin.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class InventoryExampleTest {
    @Mock
    private InventoryDB inventoryDB;

    @Test
    public void testFindItemByName() {
        List<InventoryItem> itemList = new ArrayList<InventoryItem>();

        InventoryItem itemToFind = new InventoryItem();

        itemToFind.setName("Marker");

        itemList.add(itemToFind);

        Mockito.when(inventoryDB.getInventoryItems()).thenReturn(itemList);

        InventoryExample inventoryExampleTest = new InventoryExample(inventoryDB);

        Assertions.assertNotNull(inventoryExampleTest.findInventoryItemByName("Marker"));
    }

    @Test
    public void testFindItemByQuantity() {
        List<InventoryItem> itemList = new ArrayList<InventoryItem>();

        InventoryItem itemToFind1 = new InventoryItem("Pen", 1, 4.00);
        InventoryItem itemToFind2 = new InventoryItem("Paper", 3, 1.00);
        InventoryItem itemToFind3 = new InventoryItem("Paint", 2, 3.00);
        InventoryItem itemToFind4 = new InventoryItem("Tape", 1, 3.00);

        itemList.add(itemToFind1);
        itemList.add(itemToFind2);
        itemList.add(itemToFind3);
        itemList.add(itemToFind4);

        Mockito.when(inventoryDB.getInventoryItems()).thenReturn(itemList);

        InventoryExample inventoryExampleTest = new InventoryExample(inventoryDB);

        Assertions.assertEquals(2, inventoryExampleTest.findInventoryItemByQuantity(1));
        Assertions.assertTrue(inventoryExampleTest.findInventoryItemByQuantity(3) == 1);
        Assertions.assertNotEquals(5, inventoryExampleTest.findInventoryItemByQuantity(2));

    }

    @Test
    public void testFindItemByPrice() {
        List<InventoryItem> itemList = new ArrayList<InventoryItem>();

        InventoryItem itemToFind1 = new InventoryItem("Pen", 1, 4.00);
        InventoryItem itemToFind2 = new InventoryItem("Paper", 3, 1.00);
        InventoryItem itemToFind3 = new InventoryItem("Paint", 2, 3.00);
        InventoryItem itemToFind4 = new InventoryItem("Tape", 1, 3.00);

        itemList.add(itemToFind1);
        itemList.add(itemToFind2);
        itemList.add(itemToFind3);
        itemList.add(itemToFind4);

        Mockito.when(inventoryDB.getInventoryItems()).thenReturn(itemList);

        InventoryExample inventoryExampleTest = new InventoryExample(inventoryDB);

        Assertions.assertEquals(2, inventoryExampleTest.findInventoryItemByPrice(3.00));
        Assertions.assertNotEquals(0, inventoryExampleTest.findInventoryItemByPrice(4.00));
        Assertions.assertTrue(inventoryExampleTest.findInventoryItemByPrice(1.00) == 1);
    }
}
