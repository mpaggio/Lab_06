package it.unibo.exceptions.fakenetwork.api;

import java.util.Objects;
import java.util.IOException;

public class NetworkException extends IOException{
    
    public NetworkException(){
        IOException ioexception = new IOException();
        ioexception.message = "Network error: no response";
    }
}