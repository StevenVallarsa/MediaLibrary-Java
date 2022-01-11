
package com.sv.medialibrary2022.controller.dao;

import com.sv.medialibrary2022.dto.Library;
import com.sv.medialibrary2022.dto.Media;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 *
 * @author: Steven Vallarsa
 *   email: stevenvallarsa@gmail.com
 *    date: 2022-01-10
 * purpose: 
 */
public class MediaLibraryDaoImpl implements MediaLibraryDao {
    
    private Map<String, Media> media = new HashMap<>();
    private Map<String, Library> libraries = new HashMap<>();
    
    public MediaLibraryDaoImpl() {
        setDefaultLibrary();
    }
    
    private void setDefaultLibrary() {
        Library lib = new Library();
        lib.setLibraryID("00");
        lib.setDescription("Default Library");
        lib.setLocation("Book Return");
        libraries.put(lib.getLibraryID(), lib);
    }

    @Override
    public List<Media> getAllMedia() {
        return new ArrayList<Media>(media.values());
    }

    @Override
    public List<Library> getAllLibraries() {
        return new ArrayList<Library>(libraries.values());
        
    }

    @Override
    public Media addMedia(String mediaID, Media mediaItem) {
        Media prevMedia = media.put(mediaID, mediaItem);
        return prevMedia;
    }

    @Override
    public Library addLibrary(String libraryID, Library libraryItem) {
        Library prevLibrary = libraries.put(libraryID, libraryItem);
        return prevLibrary;
    }

    @Override
    public Media getMedia(String mediaID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Library getLibrary(String libraryID) {
        return libraries.get(libraryID);
    }

    @Override
    public Media removeMedia(String mediaID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Library removeLibrary(String libraryID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Media moveMediaItem(String mediaID, String libraryID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
