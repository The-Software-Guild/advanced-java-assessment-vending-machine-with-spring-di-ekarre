package dao;

import dto.Item;

import java.util.Map;

public interface FileDao {
    public Item unmarshallItem(String line);
    public String marshallItem(Item item);
    public void writeFile(Map<String, Item> itemsToWrite) throws VendingMachinePersistenceException;
    Map<String, Item> readFile() throws VendingMachinePersistenceException;
}
