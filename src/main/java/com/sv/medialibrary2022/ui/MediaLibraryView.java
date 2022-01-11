
package com.sv.medialibrary2022.ui;

/**
 *
 * @author: Steven Vallarsa
 *   email: stevenvallarsa@gmail.com
 *    date: 2022-01-10
 * purpose: 
 */
public class MediaLibraryView {
    
    private UserIO io = new UserIOImpl();
    
        public int printMenuAndGetSelection() {

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
            
            return io.readInt("\nWhat is your pleasure?", 1, 8);
        }
}
