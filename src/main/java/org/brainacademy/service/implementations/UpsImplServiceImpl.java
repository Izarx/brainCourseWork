package org.brainacademy.service.implementations;

import org.brainacademy.dao.UpsImplRepository;
import org.brainacademy.model.implementations.UpsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of UPS Implementation Service interface to work with repository of UPS Implementations
 */

@Service
public class UpsImplServiceImpl implements UpsImplService{

    @Autowired
    UpsImplRepository upsImplRepository;

    @Override
    public List<UpsImpl> getList() {
        return upsImplRepository.findAll();
    }

    @Override
    public UpsImpl getById(Long id) {
        return upsImplRepository.findById(id).orElse(null);
    }

    @Override
    public UpsImpl getByName(String name) {
        return upsImplRepository.findByName(name);
    }

    @Override
    public void deleteById(Long id) {
        upsImplRepository.deleteById(id);
    }

    @Override
    public UpsImpl getBySerialNumber(String serialNumber) {
        return upsImplRepository.findBySerialNumber(serialNumber);
    }

    @Override
    public List<UpsImpl> getListByIsBroken(boolean isBroken) {
        return null;
    }

    @Override
    public UpsImpl save(UpsImpl equipmentImplementation) {
        return upsImplRepository.save(equipmentImplementation);
    }

}
