package org.brainacademy.service.implementations;

import org.brainacademy.model.Enterprise;
import org.brainacademy.model.implementations.UpsImpl;
import org.brainacademy.model.models.Ups;

import java.util.List;

/**
 * Interface to cooperate with repository UpsImplRepository
 */

public interface UpsImplService extends ImplementationService{

    UpsImpl getByName(String name);

    Enterprise getEnterpriseById(Long id);

    List<String> getUpses();

    List<String> getEnterprises();

}
