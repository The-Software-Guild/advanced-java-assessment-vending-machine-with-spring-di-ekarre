import com.katya.dao.AuditDao;
import com.katya.dao.VendingMachinePersistenceException;
import com.katya.dto.Item;
import com.katya.service.VendingMachineItemInventoryException;
import com.katya.service.VendingMachineService;
import com.katya.service.VendingMachineServiceImpl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class VendingMachineServiceImplTest {

    private VendingMachineService service;

    public VendingMachineServiceImplTest() throws VendingMachinePersistenceException {
        AuditDao auditDao = new AuditDaoStubImpl();
        service = new VendingMachineServiceImpl(auditDao);
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testInventoryDecreaseCount() throws VendingMachinePersistenceException {
        Item testItem = new Item("A0");
        testItem.setInventory(5);
        service.inventoryDecreaseCount(testItem);
        assertEquals(4, testItem.getInventory(), "Checking to see if the inventories match");
    }

    @Test
    void testCheckInventory() throws VendingMachineItemInventoryException, VendingMachinePersistenceException{
        Item testItem = new Item("A0");
        testItem.setInventory(5);
        try{
            service.checkInventory(testItem);
        }catch (VendingMachineItemInventoryException | VendingMachinePersistenceException e) {
            fail("Inventory should not have thrown this exception because it was greater than 0");
        }
        testItem.setInventory(0);
        try{
            service.checkInventory(testItem);
            fail("Inventory should  have thrown this exception because it was 0");
        }catch (VendingMachineItemInventoryException | VendingMachinePersistenceException e) {
            //if we are here, then the exception was thrown which is what we want
        }
    }
}
