
package com.sv.medialibrary2022.dao;

/**
 *
 * @author StevePro
 */
public interface MediaLibraryAuditDao {
    public void writeAuditEntry(String entry) throws MediaLibraryPersistenceException;
}
