
package com.sv.medialibrary2022.dto;

/**
 *
 * @author: Steven Vallarsa
 *   email: stevenvallarsa@gmail.com
 *    date: 2022-01-10
 * purpose: 
 */
public class Library {
    
    private String libraryID;
    private String name;
    private String location;
    private String description;
    
    // Once this entity is created as a database, the ID numbers  
    // will be auto generatred in sequential order.
    public Library(String libraryID) {
        this.libraryID = libraryID;
    }
    
    public Library() {
        
    }

    public String getLibraryID() {
        return libraryID;
    }
    
    public void setLibraryID(String libraryID) {
        this.libraryID = libraryID;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

}
