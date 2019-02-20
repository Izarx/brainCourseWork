package org.brainacademy.service.models;

import org.brainacademy.dao.UpsRepository;
import org.brainacademy.model.models.Ups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpsServiceImpl implements UpsService {

    @Autowired
    UpsRepository upsRepository;

    @Override
    public List<Ups> getList() {
        return upsRepository.findAll();
    }

    @Override
    public List<Ups> getByType(String type) {
        return upsRepository.findByType(type);
    }

    @Override
    public Ups getByName(String name) {
        return upsRepository.findByName(name);
    }

    @Override
    public Ups save(Ups ups) throws ClassCastException {
        return upsRepository.save(ups);
    }
}
