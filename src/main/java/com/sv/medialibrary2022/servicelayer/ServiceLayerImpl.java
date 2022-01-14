

package com.sv.medialibrary2022.servicelayer;

import com.sv.medialibrary2022.dao.MediaLibraryDao;
import com.sv.medialibrary2022.dao.MediaLibraryPersistenceException;
import com.sv.medialibrary2022.dto.Library;
import com.sv.medialibrary2022.dto.Media;
import java.util.List;


/**
 *
 * @author: Steven Vallarsa
 *   email: stevenvallarsa@gmail.com
 *    date: 2022-01-13
 * purpose: 
 */
public class ServiceLayerImpl implements ServiceLayer {
    
    MediaLibraryDao dao;

    public ServiceLayerImpl(MediaLibraryDao dao) {
        this.dao = dao;
    }
    

    @Override
    public boolean checkForDuplicates(List<Media> media, Media item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createMedia(Media media) throws MediaLibraryValidationException, MediaLibraryPersistenceException {
        validateMediaData(media);
        dao.addMedia(media);
    }

    @Override
    public void createLibrary(Library library) throws MediaLibraryValidationException, MediaLibraryPersistenceException {
        validateLibraryData(library);
        dao.addLibrary(library);
    }

    @Override
    public List<Media> findMedia(String search) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifyLibrary(String[] libraryArray) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifyMedia(String[] mediaArray) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Media removeMedia(String id) throws MediaLibraryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Library removeLibrary(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Library> getAllLibraries() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Media> getAllMedia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void validateMediaData(Media media) throws MediaLibraryValidationException {
        
        if (media.getTitle() == null 
                || media.getTitle().isBlank()
                || media.getFormat() == null
                || media.getFormat().isBlank()) {
            throw new MediaLibraryValidationException("ERROR: A minimum of the TITLE and FORMAT fields need to be filled out.");
        }
    }
    
    private void validateLibraryData(Library library) throws MediaLibraryValidationException {
        
        if (library.getName() == null
                || library.getName().isBlank()
                || library.getLocation() == null
                || library.getLocation().isBlank()) {
            throw new MediaLibraryValidationException("ERROR: The NAME and LOCATION fields must be filled out");
        }
    }

}
