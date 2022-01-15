
package com.sv.medialibrary2022.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author: Steven Vallarsa
 *   email: stevenvallarsa@gmail.com
 *    date: 2022-01-14
 * purpose: 
 */
public class MediaLibraryAuditDaoImpl implements MediaLibraryAuditDao {

    private static final String AUDIT_FILE = "audit.txt";
    
    @Override
    public void writeAuditEntry(String entry) throws MediaLibraryPersistenceException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            throw new MediaLibraryPersistenceException("Cound not presist audit information", e);
        }
        
        LocalDateTime timestap = LocalDateTime.now();
        out.println(timestap.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString() + " : " + entry);
        out.flush();
    }

}
