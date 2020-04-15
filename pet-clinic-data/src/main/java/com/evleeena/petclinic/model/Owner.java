package com.evleeena.petclinic.model;

public class Owner extends Person {
    @Override
    public String toString() {
        return "Owner{" +
                "firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                "}";
    }
}