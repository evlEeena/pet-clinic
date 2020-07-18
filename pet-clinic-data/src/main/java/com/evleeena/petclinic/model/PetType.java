package com.evleeena.petclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "types")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class PetType extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Builder
    public PetType(String name) {
        this.name = name;
    }
}
