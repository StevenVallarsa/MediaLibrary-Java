/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.sv.medialibrary2022.dao;

import com.sv.medialibrary2022.dto.Library;
import com.sv.medialibrary2022.dto.Media;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author StevePro
 */
public class MediaLibraryDaoImplTest {
    
    MediaLibraryDao testDao;
    
    public MediaLibraryDaoImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws Exception {
        String mediaFile = "testMedia.txt";
        String libraryFile = "textLibrary.txt";
        
        PrintWriter out;
        
        out = new PrintWriter(new FileWriter(mediaFile));
        out.println("100");
        out.flush();
        out.close();
        
        out = new PrintWriter(new FileWriter(libraryFile));
        out.println("10");
        out.println("00::Default Library::Book Return Cart::The default location for new books");
        out.flush();
        out.close();
        
        testDao = new MediaLibraryDaoImpl(libraryFile, mediaFile);
        
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddMediaAndFindMedia() throws MediaLibraryPersistenceException {
        Media m = new Media("100");
        m.setTitle("Dune");
        m.setCreator("Frank Herbert");
        m.setDescription("");
        m.setYear("1965");
        m.setGenre("Sci-Fi");
        m.setFormat("Paperback");
        m.setLibrary("00");
        testDao.addMedia(m);
        
        List<Media> media = testDao.findMedia("Dune");
        assertEquals(1, media.size(), "Check size of returned ListArray: Should be '1'");
        assertEquals("Dune", media.get(0).getTitle(), "Checking title: Should be 'Dune'");
        assertEquals("00", media.get(0).getLibrary(), "Checking library number: Should be '00");
        assertEquals("Frank Herbert", media.get(0).getCreator(), "Checking Creator: Should be 'Frank Herbert'");
    
        m = new Media("101");
        m.setTitle("2001");
        m.setCreator("Arthur C Clarke");
        m.setLibrary("00");
        testDao.addMedia(m);
        
        media = testDao.getAllMedia();
        
        assertEquals(2, media.size(), "The size of the media ArrayList should be '2'");
        assertEquals("Dune", media.get(1).getTitle(), "Title should be 'Dune");
    }
    
    @Test
    public void testAddLibraryAndMoveMediaToNewLibrary() throws MediaLibraryPersistenceException {
        
        Media m = new Media("100");
        m.setTitle("2001");
        m.setCreator("Arthur C Clarke");
        m.setDescription("");
        m.setYear("");
        m.setGenre("");
        m.setFormat("Paperback");
        m.setLibrary("00");
        testDao.addMedia(m);
        
        m = new Media("101");
        m.setTitle("Dune");
        m.setCreator("Frank Herbert");
        m.setDescription("");
        m.setYear("1965");
        m.setGenre("Sci-Fi");
        m.setFormat("Paperback");
        m.setLibrary("00");
        testDao.addMedia(m);
        
        Library l = new Library("10");
        l.setName("Test Library");
        l.setLocation("Test Location");
        testDao.addLibrary(l);
        
        List<Library> libraries = testDao.getAllLibraries();
        List<Media> media = testDao.getAllMedia();
        
        assertEquals(2, libraries.size(), "There should be 2 libraries");
        assertEquals("Test Library", libraries.get(1).getName());
        
        libraries.get(1).setName("New Name");
        assertEquals("New Name", libraries.get(1).getName());
        
        m.setLibrary("10");
        testDao.modifyMedia(m);
        
        assertEquals("2001", media.get(0).getTitle());
        
        List<Media> foundMedia = testDao.findMedia("Dune");
        assertEquals(1, foundMedia.size());
    }
    
    @Test
    public void testDeleteMediaAndLibraries() throws MediaLibraryPersistenceException {
        
        Media m = new Media("100");
        m.setTitle("Dune");
        m.setCreator("Frank Herbert");
        m.setDescription("");
        m.setYear("1965");
        m.setGenre("Sci-Fi");
        m.setFormat("Paperback");
        m.setLibrary("00");
        testDao.addMedia(m);
        
        m = new Media("101");
        m.setTitle("2001");
        m.setCreator("Arthur C Clarke");
        m.setLibrary("00");
        testDao.addMedia(m);
        
        Library l = new Library("10");
        l.setName("Test Library");
        l.setLocation("Test Location");
        testDao.addLibrary(l);
        
        List<Media> media = testDao.getAllMedia();
        List<Library> libraries = testDao.getAllLibraries();
        
        assertEquals(2, media.size(), "There should be two media items");
        assertEquals(2, libraries.size(), "There should be two libraries");
        
        testDao.removeLibrary("10");
        
        libraries.clear();
        libraries = testDao.getAllLibraries();
        assertEquals(1, libraries.size(), "There should only be one library left");
        
        
        
    }
    
}
