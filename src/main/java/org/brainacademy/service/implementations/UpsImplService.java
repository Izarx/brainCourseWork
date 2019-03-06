package org.brainacademy.service.implementations;

import org.brainacademy.model.implementations.UpsImpl;

/**
 * Interface to cooperate with repository UpsImplRepository
 */

public interface UpsImplService extends ImplementationService{

    UpsImpl getById(Long id);

    UpsImpl getByName(String name);

    void deleteById(Long id);

}
