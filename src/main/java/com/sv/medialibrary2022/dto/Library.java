
package com.sv.medialibrary2022.dto;

import java.util.Objects;

/**
 *
 * @author: Steven Vallarsa
 *   email: stevenvallarsa@gmail.com
 *    date: 2022-01-10
 * purpose: 
 */
public class Library {

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.libraryID);
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + Objects.hashCode(this.location);
        hash = 17 * hash + Objects.hashCode(this.description);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Library other = (Library) obj;
        if (!Objects.equals(this.libraryID, other.libraryID)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Library{" + "libraryID=" + libraryID + ", name=" + name + ", location=" + location + ", description=" + description + '}';
    }
    
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
