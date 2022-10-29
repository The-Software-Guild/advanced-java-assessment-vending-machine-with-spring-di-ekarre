import controller.VendingMachineController;
import dao.*;
import dto.Change;
import service.VendingMachineInsufficientFundsException;
import service.VendingMachineItemInventoryException;
import service.VendingMachineService;
import service.VendingMachineServiceImpl;
import ui.UserIO;
import ui.UserIOImpl;
import ui.VendingMachineView;

public class App {

    public static void main(String[] args) throws VendingMachineInsufficientFundsException, VendingMachinePersistenceException, VendingMachineItemInventoryException, VendingMachineItemInventoryException {
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
