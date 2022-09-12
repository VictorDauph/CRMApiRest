package com.m2i.crm.model;

/**
 *
 * @author Victor
 */
public enum Active {
    ACTIVE,
    INACTIVE;
    
    public String toString(){
        switch(this){
            case ACTIVE:return "ACTIVE";
            case INACTIVE:return "INACTIVE";
            default:return "CONFIRMED";
        }
    }
}
