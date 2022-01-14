
package com.sv.medialibrary2022.dao;

import com.sv.medialibrary2022.dto.Library;
import com.sv.medialibrary2022.dto.Media;
import java.util.List;

/**
 *
 * @author StevePro
 */
public interface MediaLibraryDao {
    
    /**
     * Return a List of all Media objects
     * 
     * @return List containing all Media in all the Libraries
     */
    List<Media> getAllMedia();
    
    /**
     * Return a List of all Library objects
     * 
     * @return List containing all Libraries
     */
    List<Library> getAllLibraries();
    
    /**
     * Add the given media to the collection and associate it with its ID.
     * If there is already a media item associated with the given ID it will
     * return that object, else it will return null.
     * 
     * @param mediaItem to be added to the collection
     * @return the media object if duplicate, or null if unique
     */
    Media addMedia(Media mediaItem) throws MediaLibraryPersistenceException;
    
    /**
     * Add the given media to the collection and associate it with its ID.
     * If there is already a media item associated with the given ID it will
     * return that object, else it will return null.
     * 
     * @param libraryItem to be added to the list of libraries
     * @return the library object if duplicate, or null if unique
     */
    Library addLibrary(Library libraryItem) throws MediaLibraryPersistenceException;
    
    /**
     * Returns a Media object with the given ID
     * 
     * @param mediaID ID of the media item to be retrieved
     * @return Media object of the given mediaID, or null if no such ID exists
     */
    List<Media> findMedia(String searchTerm) throws MediaLibraryPersistenceException;
    
    /**
     * Returns a Library object with the given ID
     * 
     * @param libraryID ID of the Library item to be retrieved
     * @return Library object of the given libraryID, or null if no such ID exists
     */
    Library getLibrary (String libraryID);
    
    /**
     * Removes Media object with the given ID
     * 
     * @param mediaID ID of the Media item to be removed
     * @return Media item that was removed, or null if ID doesn't exist
     */
    Media removeMedia(String mediaID) throws MediaLibraryPersistenceException;
    
    /**
     * Removes Library object with the given ID. Will iterate through all the
     * Media objects to change the library location to the default library
     * for Media objects in the deleted Library
     * 
     * @param libraryID ID of the Library to be removed
     * @return Library object that was removed, or null if ID doesn't exist
     */
    Library removeLibrary(String libraryID) throws MediaLibraryPersistenceException;
    
    /**
     * Move the Media object of mediaID to Library object of libraryID
     * 
     * @param m modified Media object
     * @return Media object (with Library ID)
     */
    void modifyMedia(Media m) throws MediaLibraryPersistenceException;
    
    /**
     * 
     * @param l modified Library object 
     * @return void 
     */
    void modifyLibrary(Library l) throws MediaLibraryPersistenceException;
    
    

}
