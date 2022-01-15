
package com.sv.medialibrary2022.dao;

import com.sv.medialibrary2022.dto.Library;
import com.sv.medialibrary2022.dto.Media;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


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
    
    public static final String LIBRARY_FILE = "library.txt";
    public static final String MEDIA_FILE = "media.txt";
    public static final String DELIMITER = "::";
    
    public MediaLibraryDaoImpl() throws MediaLibraryPersistenceException {
        loadLibrary();
        loadMedia();
    }
    
/*    private void setDefaultLibrary() {
        Library lib = new Library("00");
        lib.setName("Default Library");
        lib.setLocation("Book Return Cart");
        lib.setDescription("The default location for new books");
        libraries.put(lib.getLibraryID(), lib);
        
        Library lib2 = new Library(String.valueOf(libraryIndex++));
        lib2.setName("Visual Media Shelf");
        lib2.setLocation("By TV");
        lib2.setDescription("");
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
*/

    @Override
    public List<Media> getAllMedia() {
        return new ArrayList<Media>(media.values());
    }

    @Override
    public List<Library> getAllLibraries() {
        return new ArrayList<Library>(libraries.values());
    }

    @Override
    public Media addMedia(Media mediaItem) throws MediaLibraryPersistenceException {
        mediaItem.setMediaID(String.valueOf(mediaIndex++));
        Media prevMedia = media.put(mediaItem.getMediaID(), mediaItem);
        writeMedia();
        return prevMedia;
    }

    @Override
    public Library addLibrary(Library libraryItem) throws MediaLibraryPersistenceException {
        libraryItem.setLibraryID(String.valueOf(libraryIndex++));
        Library prevLibrary = libraries.put(libraryItem.getLibraryID(), libraryItem);
        writeLibrary();
        return prevLibrary;
    }

    @Override
    public List<Media> findMedia(String searchTerm) {
        List<Media> media = getAllMedia();
        List<Media> results = new ArrayList<>();
        searchTerm = searchTerm.toLowerCase();
        for (Media m : media) {
            if (m.getMediaID().contains(searchTerm) 
                    || m.getTitle().toLowerCase().contains(searchTerm)
                    || m.getDescription().toLowerCase().contains(searchTerm)
                    || m.getCreator().toLowerCase().contains(searchTerm)
                    || m.getFormat().toLowerCase().contains(searchTerm)
                    || m.getYear().contains(searchTerm)
                    || m.getFormat().toLowerCase().contains(searchTerm)
                    || m.getGenre().toLowerCase().contains(searchTerm)) {
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
    public Media removeMedia(String mediaID) throws MediaLibraryPersistenceException {
        Media removedMedia = media.remove(mediaID);
        writeMedia();
        return removedMedia;
    }

    @Override
    public Library removeLibrary(String libraryID) throws MediaLibraryPersistenceException {
        Library removedLibrary = libraries.remove(libraryID);
        writeMedia();
        writeLibrary();
        return removedLibrary;
    }

    @Override
    public void modifyMedia(Media m) throws MediaLibraryPersistenceException {
        media.put(m.getMediaID(), m);
        writeMedia();
    }
    
    @Override
    public void modifyLibrary(Library l) throws MediaLibraryPersistenceException {
        libraries.put(l.getLibraryID(), l);
        writeLibrary();
    }
    
    
    
    
    

    private Library unmarshallLibrary(String libraryAsText) {
        String[] libraryTokens = libraryAsText.split(DELIMITER);
        
        Library libraryFromFile = new Library(libraryTokens[0]);
        libraryFromFile.setName(libraryTokens[1]);
        libraryFromFile.setLocation(libraryTokens[2]);
        libraryFromFile.setDescription(libraryTokens[3]);
        
        return libraryFromFile;
    }
    
    private Media unmarshallMedia(String mediaAsText) {
        String[] mediaTokens = mediaAsText.split(DELIMITER);
        
        Media mediaFromFile = new Media(mediaTokens[0]);
        mediaFromFile.setTitle(mediaTokens[1]);
        mediaFromFile.setCreator(mediaTokens[2]);
        mediaFromFile.setDescription(mediaTokens[3]);
        mediaFromFile.setYear(mediaTokens[4]);
        mediaFromFile.setGenre(mediaTokens[5]);
        mediaFromFile.setFormat(mediaTokens[6]);
        mediaFromFile.setLibrary(mediaTokens[7]);
        
        return mediaFromFile;
    }
    
    
    
    private void loadLibrary() throws MediaLibraryPersistenceException {
        Scanner scanner;
        
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new MediaLibraryPersistenceException("Could not load library into memory.", e);
        }
        
        libraryIndex = Integer.parseInt(scanner.nextLine());
        
        Library currentLibrary;
        
        while (scanner.hasNextLine()) {
            currentLibrary = unmarshallLibrary(scanner.nextLine());
            libraries.put(currentLibrary.getLibraryID(), currentLibrary);
        }
        scanner.close();
    }
    
    private void loadMedia() throws MediaLibraryPersistenceException {
        Scanner scanner;
        
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(MEDIA_FILE)));
        } catch (IOException e) {
            throw new MediaLibraryPersistenceException("Cound not load media data into memory", e);
        }
        
        Media currentMedia;
        
        mediaIndex = Integer.parseInt(scanner.nextLine());
        
        while (scanner.hasNext()) {
            currentMedia = unmarshallMedia(scanner.nextLine());
            media.put(currentMedia.getMediaID(), currentMedia);
        }
        scanner.close();
    }
    
    
    
    private String marshallLibrary(Library library) {
        String libraryAsText = library.getLibraryID() + DELIMITER;
        libraryAsText += library.getName() + DELIMITER;
        libraryAsText += library.getLocation() + DELIMITER;
        libraryAsText += library.getDescription();
        return libraryAsText;
    }
    
    private String marshallMedia(Media m) {
        String mediaAsText = m.getMediaID() + DELIMITER;
        mediaAsText += m.getTitle() + DELIMITER;
        mediaAsText += m.getCreator() + DELIMITER;
        mediaAsText += m.getDescription() + DELIMITER;
        mediaAsText += m.getYear() + DELIMITER;
        mediaAsText += m.getGenre() + DELIMITER;
        mediaAsText += m.getFormat() + DELIMITER;
        mediaAsText += m.getLibrary();
        return mediaAsText;
    }
    
    
    
    private void writeLibrary() throws MediaLibraryPersistenceException {
        
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new MediaLibraryPersistenceException("Could not save library data.", e);
        }
        
        out.println(String.valueOf(libraryIndex));
        String libraryAsText;
        for (Library library : libraries.values()) {
            libraryAsText = marshallLibrary(library);
            out.println(libraryAsText);
            out.flush();
        }
        out.close();
    }
    
    private void writeMedia() throws MediaLibraryPersistenceException {
        
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(MEDIA_FILE));
        } catch (IOException e) {
            throw new MediaLibraryPersistenceException("Could not save media data.", e);
        }
        out.println(String.valueOf(mediaIndex));
        String mediaAsText;
        for (Media mediaM : media.values()) {
            mediaAsText = marshallMedia(mediaM);
            out.println(mediaAsText);
            out.flush();
        }
        out.close();
    }
}
