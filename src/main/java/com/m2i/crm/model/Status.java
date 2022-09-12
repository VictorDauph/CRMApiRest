package com.m2i.crm.model;


public enum Status {
    CANCELED,
    OPTION,
    CONFIRMED;
    
    public String toString(){
        switch(this){
            case CANCELED:return "CANCELED";
            case OPTION:return "OPTION";
            default:return "CONFIRMED";
        }
        
    }
}
