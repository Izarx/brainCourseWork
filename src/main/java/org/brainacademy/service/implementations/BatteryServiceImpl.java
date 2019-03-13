package org.brainacademy.service.implementations;

import org.brainacademy.dao.BatteryRepository;
import org.brainacademy.model.implementations.Battery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatteryServiceImpl implements BatteryService {

    @Autowired
    BatteryRepository batteryRepository;

    @Override
    public Battery getById(final Long id)
    {
        return null;
    }

    @Override
    public List<Battery> getList() {
        return batteryRepository.findAll();
    }

    @Override
    public Battery getBySerialNumber(String serialNumber) {
        return batteryRepository.findBySerialNumber(serialNumber);
    }

    @Override
    public List<Battery> getListByIsBroken(boolean isBroken) {
        return null;
    }

    @Override
    public Battery save(Battery battery) {
        return batteryRepository.save(battery);
    }

    @Override
    public void deleteById(final Long id)
    {

    }

    @Override
    public List<Battery> getByYear(int year) {
        return batteryRepository.findAll().stream().filter(s -> s.getDateFactory().getYear() == year).collect(Collectors.toList());
    }
}
