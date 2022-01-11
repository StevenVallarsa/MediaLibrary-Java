
package com.sv.medialibrary2022.controller.dao;

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
     * @param mediaID unique identifier for the media item
     * @param mediaItem to be added to the collection
     * @return the media object if duplicate, or null if unique
     */
    Media addMedia(String mediaID, Media mediaItem);
    
    /**
     * Add the given media to the collection and associate it with its ID.
     * If there is already a media item associated with the given ID it will
     * return that object, else it will return null.
     * 
     * @param libraryID unique identifier for the library
     * @param libraryItem to be added to the list of libraries
     * @return the library object if duplicate, or null if unique
     */
    Library addLibrary(String libraryID, Library libraryItem);
    
    /**
     * Returns a Media object with the given ID
     * 
     * @param mediaID ID of the media item to be retrieved
     * @return Media object of the given mediaID, or null if no such ID exists
     */
    Media getMedia(String mediaID);
    
    /**
     * Returns a Library object with the given ID
     * 
     * @param libraryID ID of the Library item to be retrieved
     * @return Library object of the given libraryID, or null if no such ID exists
     */
    Library getLibrary(String libraryID);
    
    /**
     * Removes Media object with the given ID
     * 
     * @param mediaID ID of the Media item to be removed
     * @return Media item that was removed, or null if ID doesn't exist
     */
    Media removeMedia(String mediaID);
    
    /**
     * Removes Library object with the given ID. Will iterate through all the
     * Media objects to change the library location to the default library
     * for Media objects in the deleted Library
     * 
     * @param libraryID ID of the Library to be removed
     * @return Library object that was removed, or null if ID doesn't exist
     */
    Library removeLibrary(String libraryID);
    
    /**
     * Move the Media object of mediaID to Library object of libraryID
     * 
     * @param mediaID ID of selected Media object to move
     * @param libraryID ID of the Library the Media object is being moved to
     * @return Media object (with Library ID) if move is successful, and
     * null if either the Media or Library don't exist
     */
    Media moveMediaItem(String mediaID, String libraryID);
    
    

}
