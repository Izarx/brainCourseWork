package org.brainacademy.service.implementations;

import org.brainacademy.model.Enterprise;
import org.brainacademy.model.implementations.UpsImpl;
import org.brainacademy.model.models.Ups;

import java.util.List;

/**
 * Interface to cooperate with repository UpsImplRepository
 */

public interface UpsImplService {

    List<UpsImpl> getList();

    UpsImpl getByName(String name);

    UpsImpl getBySerialNumber(String serialNumber);

    List<UpsImpl> getByIsBroken(Boolean isBroken);

    Ups getUpsById(Long id);

    Enterprise getEnterpriseById(Long id);

    List<String> getUpses();

    List<String> getEnterprises();

    UpsImpl save(UpsImpl upsImpl);

}
