
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
    public boolean createMedia(Media media) throws MediaLibraryValidationException, MediaLibraryPersistenceException {
        validateMediaData(media);
        boolean duplicate = checkForDuplicateMedia(dao.getAllMedia(), media);
        dao.addMedia(media);
        return duplicate;
    }

    @Override
    public void createLibrary(Library library) throws MediaLibraryValidationException, MediaLibraryPersistenceException {
        validateLibraryData(library);
        dao.addLibrary(library);
    }

    @Override
    public List<Media> findMedia(String search) throws MediaLibraryPersistenceException{
        return dao.findMedia(search);
    }

    @Override
    public boolean modifyLibrary(String[] libraryArray) throws MediaLibraryPersistenceException, MediaLibraryValidationException {
        
        if (libraryArray[1].isBlank() || libraryArray[2].isBlank()) {
            throw new MediaLibraryValidationException("ERROR: The NAME and LOCATION fields must be filled out.");
        }
        
        if (libraryArray[3].isEmpty()) {
            libraryArray[3] = " ";
        }
        
        Library l = new Library(libraryArray[0]);
        l.setName(libraryArray[1]);
        l.setLocation(libraryArray[2]);
        l.setDescription(libraryArray[3]);
        
        boolean duplicate = false;
        if (checkForDuplicateLibrary(dao.getAllLibraries(), l)) {
            duplicate = true;
        }
        dao.modifyLibrary(l);
        return duplicate;
    }

    @Override
    public boolean modifyMedia(String[] mediaArray) throws MediaLibraryPersistenceException, MediaLibraryValidationException {
        
        if (mediaArray[1].isBlank() || mediaArray[6].isBlank()) {
            throw new MediaLibraryValidationException("ERROR: The TITLE and FORMAT fields must be filled out.");
        }
        Media m = new Media(mediaArray[0]);
        m.setTitle(mediaArray[1]);
        m.setCreator(mediaArray[2]);
        m.setDescription(mediaArray[3]);
        m.setYear(mediaArray[4]);
        m.setGenre(mediaArray[5]);
        m.setFormat(mediaArray[6]);
        m.setLibrary(mediaArray[7]);
        
        boolean duplicate = false;
        
        if(checkForDuplicateMedia(dao.getAllMedia(), m)) {
            duplicate = true;
        }
        
        dao.modifyMedia(m);
        return duplicate;
    }

    @Override
    public Media removeMedia(String id) throws MediaLibraryPersistenceException {
        return dao.removeMedia(id);
    }

    @Override
    public Library removeLibrary(String id) throws MediaLibraryPersistenceException {
        return dao.removeLibrary(id);
    }

    @Override
    public List<Library> getAllLibraries() throws MediaLibraryPersistenceException {
        return dao.getAllLibraries();
    }

    @Override
    public List<Media> getAllMedia() throws MediaLibraryPersistenceException {
        return dao.getAllMedia();
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
    
    private boolean checkForDuplicateMedia(List<Media> media, Media item) {
        
        for (Media m : media) {
            if (m.getTitle().toLowerCase().equals(item.getTitle().toLowerCase()) && m.getFormat().toLowerCase().equals(item.getFormat().toLowerCase())) {
                return true;
            }
        }
        return false;
    }
    
    private boolean checkForDuplicateLibrary(List<Library> libraries, Library library) {
        
        for (Library l : libraries) {
            if (l.getName().toLowerCase().equals(library.getName().toLowerCase()) && l.getLocation().toLowerCase().equals(library.getLocation().toLowerCase())) {
                return true;
            }
        }
        return false;
    }

}




