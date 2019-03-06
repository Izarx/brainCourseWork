package org.brainacademy.service.implementations;

import org.brainacademy.model.implementations.EquipmentImplementation;

import java.util.List;

/**
 * Interface to communicate with repository of Implementations
 */

public interface ImplementationService<T extends EquipmentImplementation> {

    T getById(Long id);

    List<T> getList();

    T getBySerialNumber(String serialNumber);

    List<T> getListByIsBroken(boolean isBroken);

    T save(T equipmentImplementation);

    void deleteById(Long id);

}
