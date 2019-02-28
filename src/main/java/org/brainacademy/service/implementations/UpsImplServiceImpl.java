package org.brainacademy.service.implementations;

import org.brainacademy.dao.UpsImplRepository;
import org.brainacademy.model.implementations.EquipmentImplementation;
import org.brainacademy.model.implementations.UpsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UpsImplServiceImpl implements UpsImplService{

    @Autowired
    UpsImplRepository upsImplRepository;

    @Override
    public List<EquipmentImplementation> getList() {
        return upsImplRepository.findAll().stream().filter(s -> s instanceof UpsImpl).collect(Collectors.toList());
    }

    @Override
    public UpsImpl getByName(String name) {
        return upsImplRepository.findByName(name);
    }

    @Override
    public UpsImpl getBySerialNumber(String serialNumber) {
        return upsImplRepository.findBySerialNumber(serialNumber);
    }

    @Override
    public List<EquipmentImplementation> getListByIsBroken(boolean isBroken) {
        return null;
    }

    @Override
    public EquipmentImplementation save(EquipmentImplementation equipmentImplementation) {
        return upsImplRepository.save((UpsImpl) equipmentImplementation);
    }

}
