package com.evleeena.petclinic.model;

public class Vet extends Person {

    @Override
    public String toString() {
        return "Vet{" +
                "firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                "}";
    }
}
