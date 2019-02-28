package org.brainacademy.service.implementations;

import org.brainacademy.model.implementations.EquipmentImplementation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatteryServiceImpl implements BatteryService {
    @Override
    public List<EquipmentImplementation> getList() {
        return null;
    }

    @Override
    public EquipmentImplementation getBySerialNumber(String serialNumber) {
        return null;
    }

    @Override
    public List<EquipmentImplementation> getListByIsBroken(boolean isBroken) {
        return null;
    }

    @Override
    public EquipmentImplementation save(EquipmentImplementation equipmentImplementation) {
        return null;
    }
}
