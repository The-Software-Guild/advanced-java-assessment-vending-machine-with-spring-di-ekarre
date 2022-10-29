package com.katya.dao;

public interface AuditDao {
    public void writeAuditEntry(String entry) throws VendingMachinePersistenceException;
}
