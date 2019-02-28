package org.brainacademy.service.implementations;

import org.brainacademy.dao.BatteryRepository;
import org.brainacademy.model.implementations.Battery;
import org.brainacademy.model.implementations.EquipmentImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatteryServiceImpl implements BatteryService {

    @Autowired
    BatteryRepository batteryRepository;

    @Override
    public List<EquipmentImplementation> getList() {
        return batteryRepository.findAll().stream().filter(s -> s instanceof Battery).collect(Collectors.toList());
    }

    @Override
    public EquipmentImplementation getBySerialNumber(String serialNumber) {
        return batteryRepository.findBySerialNumber(serialNumber);
    }

    @Override
    public List<EquipmentImplementation> getListByIsBroken(boolean isBroken) {
        return null;
    }

    @Override
    public EquipmentImplementation save(EquipmentImplementation equipmentImplementation) {
        return batteryRepository.save((Battery) equipmentImplementation);
    }

    @Override
    public List<Battery> getByYear(int year) {
        return batteryRepository.findAll().stream().filter(s -> s.getDateFactory().getYear() == year).collect(Collectors.toList());
    }
}
