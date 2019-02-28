package org.brainacademy.service.implementations;

import org.brainacademy.model.implementations.EquipmentImplementation;

import java.util.List;

/**
 * Interface to communicate with repository of Implementations
 */

public interface ImplementationService {

    List<EquipmentImplementation> getList();

    EquipmentImplementation getBySerialNumber(String serialNumber);

    List<EquipmentImplementation> getListByIsBroken(boolean isBroken);

    EquipmentImplementation save(EquipmentImplementation equipmentImplementation);

}
