
package com.sv.medialibrary2022;

import com.sv.medialibrary2022.controller.MediaLibraryController;
import com.sv.medialibrary2022.dao.MediaLibraryAuditDao;
import com.sv.medialibrary2022.dao.MediaLibraryAuditDaoImpl;
import com.sv.medialibrary2022.dao.MediaLibraryDao;
import com.sv.medialibrary2022.dao.MediaLibraryPersistenceException;
import com.sv.medialibrary2022.dao.MediaLibraryDaoMemoryImpl;
import com.sv.medialibrary2022.servicelayer.MediaLibraryValidationException;
import com.sv.medialibrary2022.servicelayer.ServiceLayer;
import com.sv.medialibrary2022.servicelayer.ServiceLayerImpl;
import com.sv.medialibrary2022.ui.MediaLibraryView;
import com.sv.medialibrary2022.ui.UserIO;
import com.sv.medialibrary2022.ui.UserIOConsoleImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author: Steven Vallarsa
 *   email: stevenvallarsa@gmail.com
 *    date: 2022-01-10
 * purpose: Console app to keep track of media (books, tapes, CDs, DVDs, etc...)
 *          using CRUD MVC pattern
 */
public class App {
    public static void main(String[] args) throws MediaLibraryPersistenceException, MediaLibraryValidationException {
//        UserIO myIO = new UserIOConsoleImpl();
//        MediaLibraryView myView = new MediaLibraryView(myIO);
//        MediaLibraryDao dao = new MediaLibraryDaoMemoryImpl();
//        MediaLibraryAuditDao auditDao = new MediaLibraryAuditDaoImpl();
//        ServiceLayer service = new ServiceLayerImpl(dao, auditDao);
//        MediaLibraryController controller = new MediaLibraryController(service, myView);
        ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        MediaLibraryController controller = appContext.getBean("controller", MediaLibraryController.class);
        controller.run();
    }
}
