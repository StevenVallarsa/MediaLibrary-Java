
package com.sv.medialibrary2022.servicelayer;

import com.sv.medialibrary2022.dao.MediaLibraryPersistenceException;
import com.sv.medialibrary2022.dto.Library;
import com.sv.medialibrary2022.dto.Media;
import java.util.List;

/**
 *
 * @author StevePro
 */
public interface ServiceLayer {
    boolean checkForDuplicates(List<Media> media, Media item);
    void createMedia(Media media) throws MediaLibraryValidationException, MediaLibraryPersistenceException;
    void createLibrary(Library library) throws MediaLibraryValidationException, MediaLibraryPersistenceException;
    List<Media> findMedia(String search);
    void modifyLibrary(String[] libraryArray) throws MediaLibraryPersistenceException, MediaLibraryValidationException;
    void modifyMedia(String[] mediaArray) throws MediaLibraryPersistenceException, MediaLibraryValidationException;
    Media removeMedia(String id) throws MediaLibraryPersistenceException;
    Library removeLibrary(String id) throws MediaLibraryPersistenceException;
    List<Library> getAllLibraries() throws MediaLibraryPersistenceException;
    List<Media> getAllMedia() throws MediaLibraryPersistenceException;
}
