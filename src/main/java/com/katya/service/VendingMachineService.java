package com.katya.service;

import com.katya.dao.VendingMachinePersistenceException;
import com.katya.dto.Item;

public interface VendingMachineService{
    void inventoryDecreaseCount(Item selectedItem) throws VendingMachinePersistenceException;

    void checkInventory(Item selectedItem) throws VendingMachineItemInventoryException, VendingMachinePersistenceException;

}
