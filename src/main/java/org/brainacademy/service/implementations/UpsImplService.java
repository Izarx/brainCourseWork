package org.brainacademy.service.implementations;

import org.brainacademy.model.implementations.UpsImpl;

/**
 * Interface to cooperate with repository UpsImplRepository
 */

public interface UpsImplService extends ImplementationService<UpsImpl>{

    UpsImpl getByName(String name);

}
