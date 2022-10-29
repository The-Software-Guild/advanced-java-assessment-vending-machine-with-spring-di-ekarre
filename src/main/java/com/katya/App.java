package com.katya;

import com.katya.controller.VendingMachineController;
import com.katya.dao.*;
import com.katya.dto.Change;
import com.katya.service.VendingMachineInsufficientFundsException;
import com.katya.service.VendingMachineItemInventoryException;
import com.katya.service.VendingMachineService;
import com.katya.service.VendingMachineServiceImpl;
import com.katya.ui.UserIO;
import com.katya.ui.UserIOImpl;
import com.katya.ui.VendingMachineView;

public class App {

    public static void main(String[] args) throws VendingMachineInsufficientFundsException, VendingMachinePersistenceException, VendingMachineItemInventoryException {
        UserIO myIo = new UserIOImpl();
        Change myChange = new Change();
        VendingMachineView myView = new VendingMachineView(myIo, myChange);
        VendingMachineDao myDao = new VendingMachineDaoImpl();
        AuditDao myAuditDao = new AuditDaoImpl();
        VendingMachineService myService = new VendingMachineServiceImpl(myAuditDao);
        VendingMachineController controller = new VendingMachineController(myDao, myView);
        controller.run();

    }
}
