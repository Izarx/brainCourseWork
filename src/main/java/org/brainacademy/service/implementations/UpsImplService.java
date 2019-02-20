package org.brainacademy.service.implementations;

import org.brainacademy.model.implementations.UpsImpl;

import java.util.List;

/**
 * Interface to cooperate with repository UpsImplRepository
 */

public interface UpsImplService {

    List<UpsImpl> getList();

    UpsImpl getByName(String name);

    UpsImpl getBySerialNumber(String serialNumber);

    List<UpsImpl> getByIsBroken(Boolean isBroken);

    UpsImpl save(UpsImpl upsImpl);

}
