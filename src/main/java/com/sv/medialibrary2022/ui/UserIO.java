
package com.sv.medialibrary2022.ui;

/**
 *
 * @author StevePro
 */
public interface UserIO {
    
    void print(String prompt);
    void printMedia(String prompt, String[] args);
    String readString(String prompt);
    int readInt(String prompt);
    int readInt(String prompt, int min, int max);
    
}
