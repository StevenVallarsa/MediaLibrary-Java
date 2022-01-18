/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.sv.medialibrary2022.servicelayer;

import com.sv.medialibrary2022.dao.MediaLibraryDao;
import com.sv.medialibrary2022.dao.MediaLibraryAuditDao;
import com.sv.medialibrary2022.dao.MediaLibraryPersistenceException;
import com.sv.medialibrary2022.dto.Media;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author StevePro
 */
public class ServiceLayerImplTest {
    private ServiceLayer service;
    
    public ServiceLayerImplTest() {
//        MediaLibraryDao dao = new MediaLibraryDaoStubImpl();
//        MediaLibraryAuditDao auditDao = new MediaLibraryAuditDaoStubImpl();
//        service = new ServiceLayerImpl(dao, auditDao);
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("service", ServiceLayer.class);
        
    }
  
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testCreateValidMedia() throws MediaLibraryPersistenceException {
        Media m = new Media("100");
        m.setTitle("Dune");
        m.setCreator("Frank Herbert");
        m.setDescription("");
        m.setYear("1965");
        m.setGenre("Sci-Fi");
        m.setFormat("Paperback");
        m.setLibrary("00");
        
        try {
            service.createMedia(m);
        } catch (MediaLibraryValidationException e) {
            fail("Media is valid and you shouldn't see this error message.");
        }
    }
    
    @Test
    public void testInvalidMediaCreation() throws MediaLibraryValidationException, MediaLibraryPersistenceException {
        Media m = new Media("100");
        m.setTitle("");
        m.setCreator("Frank Herbert");
        m.setDescription("");
        m.setYear("1965");
        m.setGenre("Sci-Fi");
        m.setFormat("Paperback");
        m.setLibrary("00");
        
        try {
            service.createMedia(m);
            fail("Exception should have been thrown and this text should not be printed");
        } catch (MediaLibraryValidationException e) {
            return;
        }
    }
    
    @Test
    public void testGetAllMedia() throws Exception {
        Media m = new Media("100");
        m = new Media("100");
        m.setTitle("2001");
        m.setCreator("Arthur C Clarke");
        m.setDescription("");
        m.setYear("1968");
        m.setGenre("Sci-Fi");
        m.setFormat("Paperback");
        m.setLibrary("00");
        
        assertEquals(1, service.getAllMedia().size(), "Should only be 1");
        assertTrue(service.getAllMedia().contains(m), "The only media should be 'Dune'");
    }
    
    @Test
    public void testFindMedia() throws Exception {
        Media m = new Media("100");
        m.setTitle("2001");
        m.setCreator("Arthur C Clarke");
        m.setDescription("");
        m.setYear("1968");
        m.setGenre("Sci-Fi");
        m.setFormat("Paperback");
        m.setLibrary("00");
        
        Media shouldBe2001 = service.findMedia("2001").get(0);
        assertNotNull(shouldBe2001, "Should return 2001 and not be null");
        assertEquals(shouldBe2001, m, "should be 2001");
        
        List<Media> shouldBeNull = service.findMedia("Dune");
        
        assertNull(shouldBeNull, "This should be null");
        
        List<Media> shouldNotBeNull = service.findMedia("2001");
        assertNotNull(shouldNotBeNull, "This should Not be null");
        
    }
    
    
    
}
