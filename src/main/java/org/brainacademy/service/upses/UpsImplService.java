package org.brainacademy.service.upses;

import org.brainacademy.model.upses.UpsImpl;

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
