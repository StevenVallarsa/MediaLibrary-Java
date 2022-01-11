
package com.sv.medialibrary2022.controller;

import com.sv.medialibrary2022.ui.UserIO;
import com.sv.medialibrary2022.ui.UserIOImpl;

/**
 *
 * @author: Steven Vallarsa
 *   email: stevenvallarsa@gmail.com
 *    date: 2022-01-10
 * purpose: Work with user input 
 */
public class MediaLibraryController {
    
    UserIO io = new UserIOImpl();
    
    public void run() {
        boolean isRunning = true;
        int menuSelection = 0;
        
        while(isRunning) {
            io.print("\nMAIN MENU");
            io.print("=========");
            io.print("1. List Media & Libraries");
            io.print("2. Create Media");
            io.print("3. Create Library");
            io.print("4. View Specific Media");
            io.print("5. View Specific Library");
            io.print("6. Remove Media");
            io.print("7. Remove Library");
            io.print("8. EXIT");
            
            menuSelection = io.readInt("\nWhat is your pleasure?", 1, 8);
            
            switch(menuSelection) {
                case 1:
                    io.print("List Media & Libraries");
                    break;
                case 2:
                    io.print("Create Media");
                    break;
                case 3:
                    io.print("Create Library");
                    break;
                case 4:
                    io.print("View Specific Media");
                    break;
                case 5:
                    io.print("View Specific Library");
                    break;
                case 6:
                    io.print("Remove Media");
                    break;
                case 7:
                    io.print("Remove Library");
                    break;
                case 8:
                    isRunning = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }
        }
        io.print("\nGOOD BYE!");
    }
}
