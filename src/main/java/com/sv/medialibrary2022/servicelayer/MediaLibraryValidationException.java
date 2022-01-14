/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sv.medialibrary2022.servicelayer;

/**
 *
 * @author: Steven Vallarsa
 *   email: stevenvallarsa@gmail.com
 *    date: 2022-01-13
 * purpose: 
 */
public class MediaLibraryValidationException extends Exception {
    
    public MediaLibraryValidationException(String message) {
        super(message);
    }
    
    public MediaLibraryValidationException(String message, Throwable cause) {
        super(message, cause);
    }


}
