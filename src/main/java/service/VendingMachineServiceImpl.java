package service;

import dao.AuditDao;
import dao.VendingMachinePersistenceException;
import dto.Item;

public class VendingMachineServiceImpl implements VendingMachineService{

    private AuditDao auditDao;

    public VendingMachineServiceImpl(AuditDao auditDao) throws VendingMachinePersistenceException {
        this.auditDao= auditDao;
    }

    public void inventoryDecreaseCount(Item selectedItem) throws VendingMachinePersistenceException {
        selectedItem.setInventory(selectedItem.getInventory() - 1);
        auditDao.writeAuditEntry("Inventory of " + selectedItem + " decreased.");
    }
    public void checkInventory(Item selectedItem) throws VendingMachineItemInventoryException, VendingMachinePersistenceException {
        if(selectedItem.getInventory()<= 0){
            auditDao.writeAuditEntry("Inventory of " + selectedItem + " has reached zero.");
            throw new VendingMachineItemInventoryException("Sorry we are out of " + selectedItem.getName());
        }
    }
}
