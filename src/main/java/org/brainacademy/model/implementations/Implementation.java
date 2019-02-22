package org.brainacademy.model.implementations;

import org.brainacademy.model.ProjectEntity;
import org.brainacademy.model.api.Removable;

import javax.persistence.*;

/**
 * Abstract class produce implementation of equipment
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Implementation extends ProjectEntity implements Removable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;



}
