package com.evleeena.petclinic.services;

import com.evleeena.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String latName);
}
