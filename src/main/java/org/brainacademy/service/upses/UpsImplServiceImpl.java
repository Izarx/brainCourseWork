package org.brainacademy.service.upses;

import org.brainacademy.dao.UpsImplRepository;
import org.brainacademy.model.upses.UpsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpsImplServiceImpl implements UpsImplService {

    @Autowired
    UpsImplRepository upsImplRepository;

    @Override
    public List<UpsImpl> getList() {
        return upsImplRepository.findAll();
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
    public List<UpsImpl> getByIsBroken(Boolean isBroken) {
        return upsImplRepository.findByIsBroken(isBroken);
    }

    @Override
    public UpsImpl save(UpsImpl upsImpl) {
        return upsImplRepository.save(upsImpl);
    }
}
