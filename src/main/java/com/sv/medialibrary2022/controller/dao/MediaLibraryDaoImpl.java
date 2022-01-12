
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
        setDefaultMedia();
    }
    
    private void setDefaultLibrary() {
        Library lib = new Library("00");
        lib.setName("Default Library");
        lib.setLocation("Book Return Cart");
        libraries.put(lib.getLibraryID(), lib);
        
        Library lib2 = new Library(String.valueOf(libraryIndex++));
        lib2.setName("Visual Media Shelf");
        lib2.setLocation("By TV");
        libraries.put(lib2.getLibraryID(), lib2);
        
    }
    
    private void setDefaultMedia() {
        
        Media m1 = new Media(String.valueOf(mediaIndex++));
        m1.setTitle("2001: A Space Odyssey");
        m1.setCreator("Arthur C Clark");
        m1.setDescription("");
        m1.setYear("1968");
        m1.setGenre("Sci Fi");
        m1.setFormat("Paperback");
        m1.setLibrary("00");
        media.put(m1.getMediaID(), m1);
        
        Media mm1 = new Media(String.valueOf(mediaIndex++));
        mm1.setTitle("2001: A Space Odyssey");
        mm1.setCreator("Arthur C Clark / Stanley Kubrick");
        mm1.setDescription("");
        mm1.setYear("1968");
        mm1.setGenre("Sci Fi");
        mm1.setFormat("DVD");
        mm1.setLibrary("00");
        media.put(mm1.getMediaID(), mm1);
        
        Media m2 = new Media(String.valueOf(mediaIndex++));
        m2.setTitle("2010: Odyssey Two");
        m2.setCreator("Arthur C Clark");
        m2.setDescription("");
        m2.setYear("1982");
        m2.setGenre("Sci Fi");
        m2.setFormat("Paperback");
        m2.setLibrary("00");
        media.put(m2.getMediaID(), m2);

        Media m3 = new Media(String.valueOf(mediaIndex++));
        m3.setTitle("2061: Odyssey Three");
        m3.setCreator("Arthur C Clark");
        m3.setDescription("");
        m3.setYear("1987");
        m3.setGenre("Sci Fi");
        m3.setFormat("Hard Cover");
        media.put(m3.getMediaID(), m3);
        
        Media m4 = new Media(String.valueOf(mediaIndex++));
        m4.setTitle("3001: The Final Odyssey");
        m4.setCreator("Arthur C Clark");
        m4.setDescription("test");
        m4.setYear("1997");
        m4.setGenre("Sci Fi");
        m4.setFormat("Hard Cover");
        media.put(m4.getMediaID(), m4);
        
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
    public List<Media> findMedia(String searchTerm) {
        List<Media> media = getAllMedia();
        List<Media> results = new ArrayList<>();
        searchTerm = searchTerm.toLowerCase();
        for (Media m : media) {
            String title = m.getTitle().toLowerCase();
            System.out.println(m.getTitle().toLowerCase());
            System.out.println(searchTerm);
            if (m.getMediaID().contains(searchTerm) ||
                    m.getTitle().toLowerCase().contains(searchTerm) ||
                    m.getDescription().toLowerCase().contains(searchTerm) ||
                    m.getCreator().toLowerCase().contains(searchTerm) ||
                    m.getFormat().toLowerCase().contains(searchTerm) ||
                    m.getYear().contains(searchTerm) ||
                    m.getFormat().toLowerCase().contains(searchTerm) ||
                    m.getGenre().toLowerCase().contains(searchTerm) ) {
                results.add(m);
            }
        }
        return results;
    }

    @Override
    public Library getLibrary(String libraryID) {
        return libraries.get(libraryID);
    }

    @Override
    public Media removeMedia(String mediaID) {
        return media.remove(mediaID);
    }

    @Override
    public Library removeLibrary(String libraryID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifyMedia(String[] mediaArray) {
        Media m = new Media(mediaArray[0]);
        m.setTitle(mediaArray[1]);
        m.setCreator(mediaArray[2]);
        m.setDescription(mediaArray[3]);
        m.setYear(mediaArray[4]);
        m.setGenre(mediaArray[5]);
        m.setFormat(mediaArray[6]);
        m.setLibrary(mediaArray[7]);
        media.put(m.getMediaID(), m);
    }
    
    @Override
    public void modifyLibrary(String[] library) {
        Library l = new Library(library[0]);
        l.setName(library[1]);
        l.setLocation(library[2]);
        l.setDescription(library[3]);
        libraries.put(l.getLibraryID(), l);
    }



}
