package org.brainacademy.service.implementations;

import org.brainacademy.dao.EnterpriseRepository;
import org.brainacademy.dao.UpsImplRepository;
import org.brainacademy.dao.UpsRepository;
import org.brainacademy.model.Enterprise;
import org.brainacademy.model.implementations.UpsImpl;
import org.brainacademy.model.models.Ups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UpsImplServiceImpl implements UpsImplService {

    @Autowired
    UpsImplRepository upsImplRepository;

    @Autowired
    UpsRepository upsRepository;

    @Autowired
    EnterpriseRepository enterpriseRepository;

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
    public Ups getUpsById(Long id) {
        return upsRepository.getOne(id);
    }

    @Override
    public Enterprise getEnterpriseById(Long id) {
        return enterpriseRepository.getOne(id);
    }

    @Override
    public List<String> getUpses() {
        List<String> list = new ArrayList<>();
        for (Ups ups: upsRepository.findAll()){
            list.add(ups.getName());
        }
        return list;
    }

    @Override
    public List<String> getEnterprises() {
        List<String> list = new ArrayList<>();
        for (Enterprise enterprise: enterpriseRepository.findAll()){
            list.add(enterprise.getName());
        }
        return list;
    }

    @Override
    public UpsImpl save(UpsImpl upsImpl) {
        return upsImplRepository.save(upsImpl);
    }
}
