
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
    
    private int mediaIndex = 100;
    private int libraryIndex = 10;
    
    // Creates default library at runtime
    public MediaLibraryDaoImpl() {
        setDefaultLibrary();
        setStubMedia();
    }
    
    private void setDefaultLibrary() {
        Library lib = new Library("00");
        lib.setDescription("Default Library");
        lib.setLocation("Book Return Cart");
        libraries.put(lib.getLibraryID(), lib);
        
        Library lib2 = new Library("01");
        lib2.setDescription("Visual Media Shelf");
        lib2.setLocation("By TV");
        libraries.put(lib2.getLibraryID(), lib2);
        
    }
    
    private void setStubMedia() {
        
        Media m1 = new Media(String.valueOf(mediaIndex++));
        m1.setTitle("2001: A Space Odyssey");
        m1.setCreator("Arthur C Clark");
        m1.setFormat("Paperback");
        
        Media mm1 = new Media(String.valueOf(mediaIndex++));
        mm1.setTitle("2001: A Space Odyssey");
        mm1.setCreator("Arthur C Clark / Stanley Kubrick");
        mm1.setFormat("DVD");
        mm1.setYear("1968");
        mm1.setLibrary("01");
        
        
        Media m2 = new Media(String.valueOf(mediaIndex++));
        m2.setTitle("2010: Odyssey Two");
        m2.setCreator("Arthur C Clark");
        m2.setFormat("Paperback");

        Media m3 = new Media(String.valueOf(mediaIndex++));
        m3.setTitle("2061: Odyssey Three");
        m3.setCreator("Arthur C Clark");
        m3.setFormat("Hard Cover");
        
        Media m4 = new Media(String.valueOf(mediaIndex++));
        m4.setTitle("3001: The Final Odyssey");
        m4.setCreator("Arthur C Clark");
        m4.setFormat("Hard Cover");
        
        media.put(m1.getMediaID(), m1);
        media.put(m2.getMediaID(), m2);
        media.put(m3.getMediaID(), m3);
        media.put(m4.getMediaID(), m4);
        media.put(mm1.getMediaID(), mm1);
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
    public Media addMedia(Media mediaItem) {
        mediaItem.setMediaID(String.valueOf(mediaIndex++));
        Media prevMedia = media.put(mediaItem.getMediaID(), mediaItem);
        return prevMedia;
    }

    @Override
    public Library addLibrary(Library libraryItem) {
        libraryItem.setLibraryID(String.valueOf(libraryIndex++));
        Library prevLibrary = libraries.put(libraryItem.getLibraryID(), libraryItem);
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
