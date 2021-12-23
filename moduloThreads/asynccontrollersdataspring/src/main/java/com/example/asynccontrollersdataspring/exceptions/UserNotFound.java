package com.example.asynccontrollersdataspring.exceptions;

public class UserNotFound extends InterruptedException{

    public UserNotFound(){
        System.out.println("Usuario não encontrado" );
    }
}
