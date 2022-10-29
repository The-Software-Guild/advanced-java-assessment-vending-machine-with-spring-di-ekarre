package service;

import dao.VendingMachinePersistenceException;
import dto.Item;

public interface VendingMachineService{
    void inventoryDecreaseCount(Item selectedItem) throws VendingMachinePersistenceException;

    void checkInventory(Item selectedItem) throws VendingMachineItemInventoryException, VendingMachinePersistenceException;

}
