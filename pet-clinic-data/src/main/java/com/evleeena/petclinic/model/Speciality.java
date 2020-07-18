package com.evleeena.petclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "specialities")
@Getter
@Setter
@Builder
@ToString(callSuper = true)
public class Speciality extends BaseEntity {

    @Column(name = "description")
    private String description;
}
