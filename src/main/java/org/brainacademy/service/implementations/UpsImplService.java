package org.brainacademy.service.implementations;

import org.brainacademy.model.implementations.UpsImpl;

import java.util.List;

/**
 * Interface to cooperate with repository UpsImplRepository
 */

public interface UpsImplService extends ImplementationService<UpsImpl>{

    UpsImpl getByName(String name);

    List<String> getListOfNames();

}
