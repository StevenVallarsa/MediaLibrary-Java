
package com.sv.medialibrary2022.dao;

import com.sv.medialibrary2022.dao.MediaLibraryDao;
import com.sv.medialibrary2022.dao.MediaLibraryPersistenceException;
import com.sv.medialibrary2022.dto.Library;
import com.sv.medialibrary2022.dto.Media;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author: Steven Vallarsa
 *   email: stevenvallarsa@gmail.com
 *    date: 2022-01-15
 * purpose: 
 */
public class MediaLibraryDaoStubImpl implements MediaLibraryDao {
    
    public Media m1;
    public Library l1;
    
    public MediaLibraryDaoStubImpl() {
        m1 = new Media("100");
        m1.setTitle("2001");
        m1.setCreator("Arthur C Clarke");
        m1.setDescription("");
        m1.setYear("1968");
        m1.setGenre("Sci-Fi");
        m1.setFormat("Paperback");
        
        l1 = new Library("10");
        l1.setName("Default Library");
        l1.setLocation("Return Cart");
        l1.setDescription("Default Library");
    }

    @Override
    public List<Media> getAllMedia() {
        List<Media> media = new ArrayList<>();
        media.add(m1);
        return media;
    }

    @Override
    public List<Library> getAllLibraries() {
        List<Library> libraries = new ArrayList<>();
        libraries.add(l1);
        return libraries;
    }

    @Override
    public Media addMedia(Media mediaItem) throws MediaLibraryPersistenceException {
        if (mediaItem.getMediaID().equals(m1.getMediaID())) {
            return mediaItem;
        } else {
            return null;
        }
    }

    @Override
    public Library addLibrary(Library libraryItem) throws MediaLibraryPersistenceException {
        if (libraryItem.getLibraryID().equals(l1.getLibraryID())) {
            return libraryItem;
        } else {
            return null;
        }
    }

    @Override
    public List<Media> findMedia(String searchTerm) throws MediaLibraryPersistenceException {
        if (searchTerm.equals(m1.getTitle())) {
            return getAllMedia();
        } else {
            return null;
        }
    }

    @Override
    public Library getLibrary(String libraryID) {
        if (libraryID.equals(l1.getLibraryID())) {
            return l1;
        } else {
            return null;
        }
    }

    @Override
    public Media removeMedia(String mediaID) throws MediaLibraryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Library removeLibrary(String libraryID) throws MediaLibraryPersistenceException {
        if (libraryID.equals(l1.getName())) {
            return l1;
        } else {
            return null;
        }
    }

    @Override
    public void modifyMedia(Media m) throws MediaLibraryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifyLibrary(Library l) throws MediaLibraryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
